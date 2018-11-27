package com.epam.infohandling.logics.substitute;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.logics.interpreter.calculator.ExpressionCalculator;
import java.util.List;

public class ExpressionSubstitute {
    private ExpressionCalculator expressionCalculator;

    public ExpressionSubstitute( ExpressionCalculator expressionCalculator){
        this.expressionCalculator = expressionCalculator;
    }

    public Composite substitute(Composite text){
        List<Component> paragraphs = text.getChildren();
        paragraphs.forEach(p->p.getChildren().forEach(s->s.getChildren().forEach( l->{
            Lexeme lexeme = (Lexeme)l;
            if(lexeme.isExpression()){
                String lexemeValue = lexeme.getValue();
                Integer evaluatedExpression = expressionCalculator.calculate(lexemeValue);
                lexeme.setValue(evaluatedExpression.toString());
            }
        }
        )));
        return new Composite(paragraphs);
    }
}
