package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Composite;
import java.util.Arrays;

public class TextParser extends Parser {
    private static final String PARAGRAPH_SEPARATOR = "\\r\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        String[] content = text.trim().split(PARAGRAPH_SEPARATOR);
        Composite textComposite = new Composite();
        Arrays.stream(content).forEach(p->textComposite.addComponent(getSuccessor().parse(p)));
        return textComposite;
    }
}