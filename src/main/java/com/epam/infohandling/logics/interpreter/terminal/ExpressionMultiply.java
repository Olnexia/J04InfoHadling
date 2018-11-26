package com.epam.infohandling.logics.interpreter.terminal;

import com.epam.infohandling.logics.interpreter.AbstractMathExpression;
import com.epam.infohandling.logics.interpreter.Context;

public class ExpressionMultiply extends AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        int firstOperand = context.popValue();
        int secondOperand = context.popValue();
        context.pushValue(firstOperand * secondOperand);
    }
}
