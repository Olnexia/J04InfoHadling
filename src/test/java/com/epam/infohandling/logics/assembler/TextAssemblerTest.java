package com.epam.infohandling.logics.assembler;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TextAssemblerTest {
    private static final Lexeme FIRST_TEST_WORD = Lexeme.word("\tHi");
    private static final Lexeme SECOND_TEST_WORD = Lexeme.word("there!");
    private static final Lexeme THIRD_TEST_WORD = Lexeme.word("\tHow");
    private static final Lexeme FOURTH_TEST_WORD = Lexeme.word("are");
    private static final Lexeme FIFTH_TEST_WORD = Lexeme.word("you?");
    private static final Composite FIRST_TEST_SENTENCE = new Composite(Arrays.asList(FIRST_TEST_WORD,SECOND_TEST_WORD));
    private static final Composite SECOND_TEST_SENTENCE = new Composite(Arrays.asList(THIRD_TEST_WORD,FOURTH_TEST_WORD,FIFTH_TEST_WORD));
    private static final Composite FIRST_TEST_PARAGRAPH = new Composite(Arrays.asList(FIRST_TEST_SENTENCE));
    private static final Composite SECOND_TEST_PARAGRAPH = new Composite(Arrays.asList(SECOND_TEST_SENTENCE));
    private static final Composite TEST_COMPOSITE= new Composite(Arrays.asList(FIRST_TEST_PARAGRAPH,SECOND_TEST_PARAGRAPH));
    private static final String EXPECTED_TEXT = "\tHi there!\tHow are you?";

    @Test
    public void shouldAssembleTextWhenDataValid(){
        //given
        TextAssembler textAssembler = new TextAssembler();
        //when
        String actualText = textAssembler.assemble(TEST_COMPOSITE);
        //then
        Assert.assertEquals(EXPECTED_TEXT,actualText);
    }
}
