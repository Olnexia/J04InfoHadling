package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Composite;

public class ParagraphParser extends Parser {
    private static final String SENTENCE_SEPARATOR = "(?<=\\?)|(?<=!)|(?<=(\\.{3}))|(?<=\\.)";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String paragraph) {
        String[] components  = paragraph.split(SENTENCE_SEPARATOR);

        Composite paragraphComposite = new Composite();
        for(String sentenceComponent :components){
            Composite sentence = getSuccessor().parse(sentenceComponent);
            paragraphComposite.addComponent(sentence);
        }
        return paragraphComposite;
    }
}
