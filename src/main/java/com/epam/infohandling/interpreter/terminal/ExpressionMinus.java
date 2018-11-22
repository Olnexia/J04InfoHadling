package com.epam.infohandling.interpreter.terminal;

import com.epam.infohandling.interpreter.AbstractMathExpression;
import com.epam.infohandling.interpreter.Context;

public class ExpressionMinus extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        int firstOperand = context.popValue();
        int secondOperand = context.popValue();
        context.pushValue(firstOperand-secondOperand);
    }
}
