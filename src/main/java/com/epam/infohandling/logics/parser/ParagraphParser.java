package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import java.util.*;

public class ParagraphParser extends Parser {
    private static final String SENTENCE_SEPARATOR = "(?<=\\?)|(?<=!)|(?<=(\\.{3}))|(?<=\\.)";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String paragraph) {
        String[] sentences  = paragraph.split(SENTENCE_SEPARATOR);
        Component paragraphComposite = new Composite();
        Arrays.stream(sentences).forEach(s->paragraphComposite.addComponent(getSuccessor().parse(s)));
        return paragraphComposite;
    }
}
