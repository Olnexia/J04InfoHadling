package com.epam.infohandling;

import com.sun.tools.javac.util.List;

public class Lexeme implements Component,Value {
    private String value;
    private boolean expression;

    public Lexeme(String value,boolean expression){
        this.value = value;
        this.expression = expression;
    }

    public static Lexeme word(String value){
        return new Lexeme(value,false);
    }

    public static Lexeme expression(String value){
        return new Lexeme(value,true);
    }

    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    public String getValue(){
        return value;
    }
}
