package com.epam.infohandling.logics.substitute;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.logics.interpreter.calculator.ExpressionCalculator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionSubstitute {
    private ExpressionCalculator expressionCalculator;

    public ExpressionSubstitute( ExpressionCalculator expressionCalculator){
        this.expressionCalculator = expressionCalculator;
    }

    public Component substitute(Component text){
        List<Component> paragraphs = text.getChildren();
        paragraphs = paragraphs.stream().map(this::substituteParagraph).collect(Collectors.toList());
        return new Composite(paragraphs);
    }

    private Component substituteParagraph(Component paragraph){
        List<Component> sentences = paragraph.getChildren();
        sentences = sentences.stream().map(this::substituteSentence).collect(Collectors.toList());
        return new Composite(sentences);
    }

    private Component substituteSentence(Component sentence){
        List<Component> lexemes = sentence.getChildren();
        lexemes = lexemes.stream().map(this::substituteLexeme).collect(Collectors.toList());
        return new Composite(lexemes);
    }

    private Component substituteLexeme( Component lexemeComponent){
        Lexeme lexeme = (Lexeme) lexemeComponent;
        String lexemeValue = lexeme.getValue();
        if(lexeme.isExpression()){
            Integer expressionResult = expressionCalculator.calculate(lexemeValue);
            return Lexeme.expression(expressionResult.toString());
        } else{
            return Lexeme.word(lexemeValue);
        }
    }
}
