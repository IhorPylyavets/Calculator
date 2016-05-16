package com.goit.project.expression;

public class ExpressionElement{

    public double value;
    public ExpressionElementType elementType;
    public int operationPriority;

    public ExpressionElement(ExpressionElementType elementType) {
        this.value = 0;
        this.elementType = elementType;

        if (elementType == ExpressionElementType.OPEN_PARENTHESIS) {
            this.operationPriority = 1;
        } else if (elementType == ExpressionElementType.CLOSE_PARENTHESIS) {
            this.operationPriority = 2;
        } else if (elementType == ExpressionElementType.PLUS || elementType == ExpressionElementType.MINUS) {
            this.operationPriority = 3;
        } else if (elementType == ExpressionElementType.MULTIPLY || elementType == ExpressionElementType.DIVIDE) {
            this.operationPriority = 4;
        } else if (elementType == ExpressionElementType.POWER) {
            this.operationPriority = 5;
        }
    }

    public ExpressionElement(double value) {
        this.value = value;
        this.elementType = ExpressionElementType.NUMBER;
        this.operationPriority = 0;
    }

    @Override
    public String toString() {
        return "ExpressionElement{" +
                "value=" + value +
                ", elementType=" + elementType +
                ", operationPriority=" + operationPriority +
                '}';
    }
}
