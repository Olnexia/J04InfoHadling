package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import java.util.Arrays;

public class TextParser extends Parser {
    private static final String PARAGRAPH_SEPARATOR = "\\r\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        String[] paragraphs = text.trim().split(PARAGRAPH_SEPARATOR);
        Component textComposite = new Composite();
        Arrays.stream(paragraphs).forEach(p->textComposite.addComponent(getSuccessor().parse(p)));
        return textComposite;
    }
}
