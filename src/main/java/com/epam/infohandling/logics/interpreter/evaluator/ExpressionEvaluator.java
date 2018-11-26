package com.epam.infohandling.logics.interpreter.evaluator;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.logics.interpreter.calculator.PolishNotationCalculator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionEvaluator {

    public Composite evaluate(Composite text){
        List<Component> paragraphComponents = text.getChildren();
        List<Component> evaluateParagraphs = paragraphComponents.stream().map(this::evaluateParagraph).collect(Collectors.toList());
        return new Composite(evaluateParagraphs);
    }

    private Component evaluateParagraph(Component paragraph){
        List<Component> sentenceComponents = paragraph.getChildren();
        List<Component> evaluateSentences = sentenceComponents.stream().map(this::evaluateSentence).collect(Collectors.toList());
        return new Composite(evaluateSentences);
    }

    private Component evaluateSentence(Component sentence){
        List<Component> lexemeComponents = sentence.getChildren();
        List<Component> evaluatedLexemes = lexemeComponents.stream().map(this::evaluateLexeme).collect(Collectors.toList());
        return new Composite(evaluatedLexemes);
    }

    private Component evaluateLexeme( Component lexemeComponent){
        Lexeme lexeme = (Lexeme) lexemeComponent;
        String lexemeValue = lexeme.getValue();
        if(lexeme.isExpression()){
            PolishNotationCalculator calculator = new PolishNotationCalculator();
            Integer expressionResult = calculator.calculateExpression(lexemeValue);
            return Lexeme.expression(expressionResult.toString());
        }
        else{
            return lexeme;
        }
    }
}
