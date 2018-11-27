package com.epam.infohandling.logics.interpreter.calculator;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class PolishNotationCalculatorTest {

    @DataProvider
    public static Object[][] expressionCalculator() {
        return new Object[][] {
                { "5 4 * 5 - 30 +",15 },
                { "2 4 - 2 + 12 *",48 },
                { "2 12 + 28 /",2}
        };
    }

    @Test
    @UseDataProvider("expressionCalculator")
    public void shouldCalculateExpressionsWhenDataValid(String expression,int expected){
        //given
        PolishNotationCalculator prnCalculator = new PolishNotationCalculator();
        //when
        int actual = prnCalculator.calculate(expression);
        //then
        Assert.assertEquals(expected,actual);
    }
}
