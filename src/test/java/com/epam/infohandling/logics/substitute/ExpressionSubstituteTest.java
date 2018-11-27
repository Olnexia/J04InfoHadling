package com.epam.infohandling.logics.substitute;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.logics.interpreter.calculator.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExpressionSubstituteTest {
    private static final Lexeme FIRST_TEST_WORD = Lexeme.word("Substitute");
    private static final Lexeme SECOND_TEST_WORD = Lexeme.expression("5 2 4 - *");
    private static final Lexeme THIRD_TEST_WORD = Lexeme.word("class");
    private static final Lexeme FOURTH_TEST_WORD = Lexeme.expression("5 2 - 2 +");
    private static final Lexeme FIFTH_TEST_WORD = Lexeme.word("test");
    private static final Composite FIRST_TEST_SENTENCE = new Composite(Arrays.asList(FIRST_TEST_WORD,SECOND_TEST_WORD));
    private static final Composite SECOND_TEST_SENTENCE = new Composite(Arrays.asList(THIRD_TEST_WORD,FOURTH_TEST_WORD,FIFTH_TEST_WORD));
    private static final Composite FIRST_TEST_PARAGRAPH = new Composite(Arrays.asList(FIRST_TEST_SENTENCE));
    private static final Composite SECOND_TEST_PARAGRAPH = new Composite(Arrays.asList(SECOND_TEST_SENTENCE));
    private static final Composite TEST_COMPOSITE = new Composite(Arrays.asList(FIRST_TEST_PARAGRAPH,SECOND_TEST_PARAGRAPH));
    private static final String EXPECTED_SUBSTITUTION = "42";

    @Test
    public void shouldSubstituteCorrectWhenDataValid(){
        //given
        ExpressionCalculator calculatorMock = mock(ExpressionCalculator.class);
        when(calculatorMock.calculate(anyString())).thenReturn(42);
        ExpressionSubstitute substitute = new ExpressionSubstitute(calculatorMock);
        //when
        Component actual = substitute.substitute(TEST_COMPOSITE);
        //then
        List<Component> paragraphs = actual.getChildren();

        Component firstParagraph = paragraphs.get(0);
        List<Component> firstSentences = firstParagraph.getChildren();
        Component firstSentence = firstSentences.get(0);
        List<Component> firstLexemes = firstSentence.getChildren();
        Lexeme first = (Lexeme) firstLexemes.get(0);
        Lexeme second = (Lexeme) firstLexemes.get(1);

        Component secondParagraph = paragraphs.get(1);
        List<Component> secondSentences = secondParagraph.getChildren();
        Component secondSentence = secondSentences.get(0);
        List<Component> secondLexemes = secondSentence.getChildren();
        Lexeme third = (Lexeme) secondLexemes.get(0);
        Lexeme fourth = (Lexeme) secondLexemes.get(1);
        Lexeme fifth = (Lexeme) secondLexemes.get(2);

        Assert.assertEquals("Substitute",first.getValue());
        Assert.assertEquals(EXPECTED_SUBSTITUTION,second.getValue());
        Assert.assertEquals("class",third.getValue());
        Assert.assertEquals(EXPECTED_SUBSTITUTION,fourth.getValue());
        Assert.assertEquals("test",fifth.getValue());

    }
}
