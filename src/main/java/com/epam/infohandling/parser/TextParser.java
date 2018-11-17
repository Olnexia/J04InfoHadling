package com.epam.infohandling.parser;

import com.epam.infohandling.Composite;

public class TextParser extends Parser {

    public TextParser(Parser successor) {
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
