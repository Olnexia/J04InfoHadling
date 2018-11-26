package com.epam.infohandling.logics.interpreter.calculator;

import com.epam.infohandling.logics.interpreter.AbstractMathExpression;
import com.epam.infohandling.logics.interpreter.Context;
import com.epam.infohandling.logics.interpreter.nonterminal.ExpressionNumber;
import com.epam.infohandling.logics.interpreter.terminal.ExpressionDivide;
import com.epam.infohandling.logics.interpreter.terminal.ExpressionMinus;
import com.epam.infohandling.logics.interpreter.terminal.ExpressionMultiply;
import com.epam.infohandling.logics.interpreter.terminal.ExpressionPlus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolishNotationCalculator {

    public int calculateExpression(String expression){
        Context context = new Context();
        List<AbstractMathExpression> abstractExpressions = parseExpression(expression);
        for (AbstractMathExpression terminal : abstractExpressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<AbstractMathExpression> parseExpression(String expression){
        List<AbstractMathExpression> abstractExpressions = new ArrayList <>();
        for(String lexeme : expression.split("\\p{Blank}+")){
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    abstractExpressions.add(new ExpressionPlus());
                    break;
                case '-':
                    abstractExpressions.add(new ExpressionMinus());
                    break;
                case '*':
                    abstractExpressions.add(new ExpressionMultiply());
                    break;
                case '/':
                    abstractExpressions.add(new ExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        abstractExpressions.add(
                                new ExpressionNumber(scan.nextInt()));
                    }
            }
        }
        return abstractExpressions;
    }
}
