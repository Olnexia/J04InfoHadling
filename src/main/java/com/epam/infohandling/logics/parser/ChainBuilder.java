package com.epam.infohandling.logics.parser;

public class ChainBuilder {

    public Parser buildChain(){
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}
