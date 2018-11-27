package com.epam.infohandling.logics.parser;

import org.junit.Assert;
import org.junit.Test;

public class ChainBuilderTest {

    @Test
    public void shouldBuildParserChain(){
        //given
        ParserChainBuilder parserChainBuilder = new ParserChainBuilder();
        //when
        Parser parser = parserChainBuilder.buildChain();
        //then
        Class parserClass = parser.getClass();
        Assert.assertEquals(parserClass,TextParser.class);

        Parser firstSuccessor = parser.getSuccessor();
        Class firstSuccessorClass = firstSuccessor.getClass();
        Assert.assertEquals(firstSuccessorClass,ParagraphParser.class);

        Parser secondSuccessor = firstSuccessor.getSuccessor();
        Class secondSuccessorClass = secondSuccessor.getClass();
        Assert.assertEquals(secondSuccessorClass,SentenceParser.class);
    }
}
