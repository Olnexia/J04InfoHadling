package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Composite;

public class TextParser extends Parser {
    private static final String PARAGRAPH_SEPARATOR = "(?<!^)\\t";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        String[] content = text.trim().split(PARAGRAPH_SEPARATOR);
        Composite textComposite = new Composite();
        for(String textComponent : content){
            Composite paragraph = getSuccessor().parse(textComponent);
            textComposite.addComponent(paragraph);
        }
        return textComposite;
    }
}
