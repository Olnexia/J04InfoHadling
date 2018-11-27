package com.epam.infohandling.logics.interpreter.calculator;

import org.junit.Assert;
import org.junit.Test;

public class PolishNotationCalculatorTest {
    private static final String FIRST_TEST_EXPRESSION = "5 4 * 5 - 30 +";
    private static final String SECOND_TEST_EXPRESSION = "2 4 - 2 + 12 *";

    @Test
    public void shouldCalculateFirstExpressionWhenDataValid(){
        //given
        PolishNotationCalculator prnCalculator = new PolishNotationCalculator();
        //when
        int actual = prnCalculator.calculate(FIRST_TEST_EXPRESSION);
        //then
        Assert.assertEquals(15,actual);
    }

    @Test
    public void shouldCalculateSecondExpressionWhenDataValid(){
        //given
        PolishNotationCalculator prnCalculator = new PolishNotationCalculator();
        //when
        int actual = prnCalculator.calculate(SECOND_TEST_EXPRESSION);
        //then
        Assert.assertEquals(48,actual);
    }
}
