package com.epam.infohandling.parser;

import com.epam.infohandling.Composite;

public class SentenceParser extends Parser {

    public SentenceParser(){
    }

    @Override
    public Parser getSuccessor() {
        return super.getSuccessor();
    }

    @Override
    public Composite parse(String sentence) {
        String[] content = sentence.split("\\s+");
        Composite composite = new Composite();
        for(String SentenceComponent : content){

        }
    }
}
