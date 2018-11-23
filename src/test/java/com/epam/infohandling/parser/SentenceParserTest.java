package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {
    private static final String TEST_SENTENCE = "Test of sentence 5 4 - parser class 2 5 - 7 +";

    @Test
    public void shouldParseSentenceWhenDataValid(){
        //given
        Parser sentenceParser = new SentenceParser();
        //when
        Component actual = sentenceParser.parse(TEST_SENTENCE);
        //then
        List<Component> components = actual.getChildren();
        Assert.assertEquals(7,components.size());
        Lexeme first = (Lexeme) components.get(0);
        Assert.assertEquals("Test",first.getValue());
        Lexeme second = (Lexeme) components.get(1);
        Assert.assertEquals("of",second.getValue());
        Lexeme third = (Lexeme) components.get(2);
        Assert.assertEquals("sentence",third.getValue());
        Lexeme fourth = (Lexeme) components.get(3);
        Assert.assertEquals("5 4 -",fourth.getValue());
        Lexeme fifth = (Lexeme) components.get(4);
        Assert.assertEquals("parser",fifth.getValue());
        Lexeme sixth = (Lexeme) components.get(5);
        Assert.assertEquals("class",sixth.getValue());
        Lexeme seven = (Lexeme) components.get(6);
        Assert.assertEquals("2 5 - 7 +",seven.getValue());
    }

}
