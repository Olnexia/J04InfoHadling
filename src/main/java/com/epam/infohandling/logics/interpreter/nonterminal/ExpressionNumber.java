package com.epam.infohandling.logics.interpreter.nonterminal;

import com.epam.infohandling.logics.interpreter.AbstractMathExpression;
import com.epam.infohandling.logics.interpreter.Context;

public class ExpressionNumber extends AbstractMathExpression {
    private int number;

    public ExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}