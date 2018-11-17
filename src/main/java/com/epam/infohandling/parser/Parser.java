package com.epam.infohandling.parser;

import com.epam.infohandling.Composite;

abstract class Parser {
    Parser successor;

    public Parser(){
    }

    public Parser(Parser successor){
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public abstract Composite parse(String input);

}
