package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Component;

public abstract class Parser {
    private Parser successor;

    public Parser(){
    }

    public Parser(Parser successor){
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public abstract Component parse(String input);
}
