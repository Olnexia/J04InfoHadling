package com.epam.infohandling.logics.assembler;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.logics.interpreter.evaluator.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextAssembler {
    private static final String REDUNDANT_SPACES_BEFORE_TABS = "\\s+\\t";
    private static final String REDUNDANT_SPACES_AT_END = "\\s+$";

    public String assemble(Composite textComposite, boolean evaluateFlag){
        StringBuilder textBuilder = new StringBuilder();
        if(evaluateFlag){
            ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
            textComposite = expressionEvaluator.evaluate(textComposite);
        }
        List<Lexeme> lexemes = receiveLexemes(textComposite);
        for(Lexeme lexeme : lexemes){
             String lexemeContent = lexeme.getValue();
             textBuilder.append(lexemeContent+" ");
        }
        return textBuilder.toString().replaceAll(REDUNDANT_SPACES_BEFORE_TABS,"\t")
                                    .replaceAll(REDUNDANT_SPACES_AT_END, "");
    }

    private List<Lexeme> receiveLexemes(Composite text){
        List<Component> paragraphs = text.getChildren();
        List<Component> sentences = paragraphs.stream().flatMap(p->p.getChildren().stream()).collect(Collectors.toList());
        List<Component> lexemeComponents = sentences.stream().flatMap(s->s.getChildren().stream()).collect(Collectors.toList());
        List<Lexeme> lexemes = new ArrayList<>();
        for(Component lexemeComponent:lexemeComponents){
            lexemes.add((Lexeme) lexemeComponent);
        }
        return lexemes;
    }
}
