package com.epam.infohandling;


import com.epam.infohandling.parser.SentenceParser;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {
    private static final String TEST_SENTENCE = "Test of sentence parser class.";

    @Test
    public void shouldParseSentenceWhenDataValid(){
        //given
        SentenceParser sentenceParser = new SentenceParser();
        //when
        Component actual = sentenceParser.parse(TEST_SENTENCE);
        //then
        List<Component> components = actual.getChildren();
        Assert.assertEquals(components.size(),5);
        Assert.assertEquals(components.get(0),"Test");
        Assert.assertEquals(components.get(1),"of");
        Assert.assertEquals(components.get(2),"sentence");
        Assert.assertEquals(components.get(3),"parser");
        Assert.assertEquals(components.get(4),"class");
    }

}
