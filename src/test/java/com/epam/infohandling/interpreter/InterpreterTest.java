package com.epam.infohandling.interpreter;

import com.epam.infohandling.interpreter.calculator.PolishNotationCalculator;
import org.junit.Assert;
import org.junit.Test;

public class InterpreterTest {
    private static final String TEST_EXPRESSION = "5 4 * 5 - 30 +";

    @Test
    public void shouldInterpretExpressionsWhenDataValid(){
        //given
        PolishNotationCalculator prnCalculator = new PolishNotationCalculator();
        //when
        int actual = prnCalculator.calculateExpression(TEST_EXPRESSION);
        //then
        Assert.assertEquals(15,actual);
    }
}
