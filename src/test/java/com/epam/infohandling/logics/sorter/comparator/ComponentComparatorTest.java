package com.epam.infohandling.logics.sorter.comparator;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class ComponentComparatorTest {
    private static final Lexeme FIRST_TEST_WORD = Lexeme.word("test");
    private static final Lexeme SECOND_TEST_WORD = Lexeme.word("text");
    private static final Lexeme THIRD_TEST_WORD = Lexeme.word("is");
    private static final Lexeme FOURTH_TEST_WORD = Lexeme.word("right");
    private static final Lexeme FIFTH_TEST_WORD = Lexeme.word("here");
    private static final Composite FIRST_TEST_SENTENCE = new Composite(Arrays.asList(FIRST_TEST_WORD,SECOND_TEST_WORD));
    private static final Composite SECOND_TEST_SENTENCE = new Composite(Arrays.asList(THIRD_TEST_WORD,FOURTH_TEST_WORD,FIFTH_TEST_WORD));
    private static final Composite THIRD_TEST_SENTENCE = new Composite(Arrays.asList(SECOND_TEST_WORD,THIRD_TEST_WORD));

    @DataProvider
    public static Object[][] componentComparator() {
        return new Object[][] {
                { FIRST_TEST_SENTENCE,SECOND_TEST_SENTENCE,-1 },
                { FIRST_TEST_SENTENCE,THIRD_TEST_SENTENCE,0 },
                { SECOND_TEST_SENTENCE,FIRST_TEST_SENTENCE,1},
        };
    }

    @Test
    @UseDataProvider("componentComparator")
    public void shouldCompareByComponentAmountCorrectWhenDataValid(Component firstComponent,Component secondComponent,int expected){
        //given
        ComponentAmountComparator comparator = new ComponentAmountComparator();
        //when
        int actual = comparator.compare(firstComponent,secondComponent);
        //then
        Assert.assertEquals(expected,actual);
    }
}
