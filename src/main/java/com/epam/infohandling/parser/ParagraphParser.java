package com.epam.infohandling.parser;

import com.epam.infohandling.Composite;

public class ParagraphParser extends Parser {
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Parser getSuccessor() {
        return super.getSuccessor();
    }

    @Override
    public Composite parse(String input) {
        return null;
    }
}
