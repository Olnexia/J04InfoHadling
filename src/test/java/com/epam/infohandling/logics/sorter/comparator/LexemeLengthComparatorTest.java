package com.epam.infohandling.logics.sorter.comparator;

import com.epam.infohandling.entity.Lexeme;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class LexemeLengthComparatorTest {
    private static final Lexeme FIRST_TEST_WORD = Lexeme.word("external");
    private static final Lexeme SECOND_TEST_WORD = Lexeme.word("java");
    private static final Lexeme THIRD_TEST_WORD = Lexeme.word("training");

    @DataProvider
    public static Object[][] wordLengthComparator() {
        return new Object[][] {
                { FIRST_TEST_WORD,SECOND_TEST_WORD,1 },
                { FIRST_TEST_WORD,THIRD_TEST_WORD,0 },
                { SECOND_TEST_WORD,FIRST_TEST_WORD,-1},
        };
    }

    @Test
    @UseDataProvider("wordLengthComparator")
    public void shouldCompareByWordLengthCorrectWhenDataValid(Lexeme firstWord, Lexeme secondWord, int expected){
        //given
        WordLengthComparator comparator = new WordLengthComparator();
        //when
        int actual = comparator.compare(firstWord,secondWord);
        //then
        Assert.assertEquals(expected,actual);
    }
}