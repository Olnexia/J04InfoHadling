package com.epam.infohandling.parser;

public class ChainBuilder {

    public Parser buildChain(){
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new TextParser(paragraphParser);
        return textParser;
    }
}
