package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextParserTest {
    private static final String FIRST_TEST_PARAGRAPH ="The company was founded as EPAM by Belarus natives Arkadiy Dobkin " +
            "in Princeton, New Jersey, and Leo Lozner in Minsk, Belarus in 1993.It incorporated as EPAM Systems" +
            " on December 18, 2002.[3] The company has since grown to approximately 25,900 tech employees, as of March 2018.";
    private static final String SECOND_TEST_PARAGRAPH ="EPAM initially stood for \"Effective Programming for America\", " +
            "though the company simply uses the acronym in all its marketing and information materials.";
    private static final String THIRD_TEST_PARAGRAPH ="On January 24, 2012, EPAM announced the launch of an IPO on the " +
            "New York Stock Exchange under the ticker EPAM.[5] This is the first IPO that comes from the outsourcing" +
            " industry in Eastern Europe.";
    private static final String TEST_TEXT = FIRST_TEST_PARAGRAPH+"\r\n"
            +SECOND_TEST_PARAGRAPH+"\r\n"
            +THIRD_TEST_PARAGRAPH;

    @Test
    public void shouldParseTextWhenDataValid(){
        //given
        ParagraphParser paragraphParserMock = mock(ParagraphParser.class);
        when(paragraphParserMock.parse(anyString())).thenAnswer((Answer<Component>) invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            String text = (String)args[0];
            Component paragraph = new Composite();
            paragraph.addComponent(Lexeme.word(text));
            return paragraph;
        });
        Parser textParser = new TextParser(paragraphParserMock);
        //when
        Component actual = textParser.parse(TEST_TEXT);
        //then
        List<Component> components = actual.getChildren();
        Assert.assertEquals(3,components.size());

        Component first = components.get(0);
        Lexeme firstParagraph = (Lexeme) first.getChildren().get(0);
        Assert.assertEquals(FIRST_TEST_PARAGRAPH,firstParagraph.getValue());

        Component second = components.get(1);
        Lexeme secondParagraph = (Lexeme) second.getChildren().get(0);
        Assert.assertEquals(SECOND_TEST_PARAGRAPH,secondParagraph.getValue());

        Component third = components.get(2);
        Lexeme thirdParagraph = (Lexeme) third.getChildren().get(0);
        Assert.assertEquals(THIRD_TEST_PARAGRAPH,thirdParagraph.getValue());
    }
}
