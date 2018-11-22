package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.parser.ParagraphParser;
import com.epam.infohandling.parser.Parser;
import com.epam.infohandling.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import java.util.List;
import static org.mockito.Mockito.*;

public class ParagraphParserTest {
    private static final String FIRST_TEST_SENTENCE ="You can’t look at Java as just a collection of " +
            "features—some of the features make no sense in isolation.";
    private static final String SECOND_TEST_SENTENCE ="You can use the sum of the " +
            "parts only if you are thinking about design, not simply coding.";
    private static final String THIRD_TEST_SENTENCE ="And to understand Java" +
            "in this way,you must understand the problems with the language and with programming in general!";
    private static final String TEST_PARAGRAPH = FIRST_TEST_SENTENCE
                                                +SECOND_TEST_SENTENCE
                                                +THIRD_TEST_SENTENCE;

    @Test
    public void shouldParseParagraphWhenDataValid(){
        //given
        SentenceParser sentenceParserMock = mock(SentenceParser.class);
        when(sentenceParserMock.parse(anyString())).thenAnswer((Answer <Component>) invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            String text = (String)args[0];
            Component sentence = new Composite();
            sentence.addComponent(Lexeme.word(text));
            return sentence;
        });
        Parser paragraphParser = new ParagraphParser(sentenceParserMock);
        //when
        Component actual = paragraphParser.parse(TEST_PARAGRAPH);
        //then
        List<Component> components = actual.getChildren();
        Assert.assertEquals(3,components.size());

        Component first = components.get(0);
        Lexeme firstSentence = (Lexeme) first.getChildren().get(0);
        Assert.assertEquals(FIRST_TEST_SENTENCE,firstSentence.getValue());

        Component second = components.get(1);
        Lexeme secondSentence = (Lexeme) second.getChildren().get(0);
        Assert.assertEquals(SECOND_TEST_SENTENCE,secondSentence.getValue());

        Component third = components.get(2);
        Lexeme thirdSentence = (Lexeme) third.getChildren().get(0);
        Assert.assertEquals(THIRD_TEST_SENTENCE,thirdSentence.getValue());
    }
}
