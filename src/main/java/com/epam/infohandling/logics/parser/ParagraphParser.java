package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Composite;
import java.util.*;

public class ParagraphParser extends Parser {
    private static final String SENTENCE_SEPARATOR = "(?<=\\?)|(?<=!)|(?<=(\\.{3}))|(?<=\\.)";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String paragraph) {
        String[] components  = paragraph.split(SENTENCE_SEPARATOR);
        Composite paragraphComposite = new Composite();
        Arrays.stream(components).forEach(s->paragraphComposite.addComponent(getSuccessor().parse(s)));
        return paragraphComposite;
    }
}
