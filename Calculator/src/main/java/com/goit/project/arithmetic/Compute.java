package com.goit.project.arithmetic;

import com.goit.project.expression.Expression;
import com.goit.project.expression.ExpressionElement;
import com.goit.project.expression.ExpressionElementType;

import java.util.ArrayList;
import java.util.List;

public class Compute {
    public double computeExpression(Expression expression) {
        double result;

        while (isParenthesis(expression)) {
            doComputeInBrackets(expression);
        }

        result = expressDecision(expression.elementSet);

        return result;
    }

    private boolean isParenthesis(Expression expression) {
        for (ExpressionElement expressionElement : expression.elementSet) {
            if (expressionElement.elementType == ExpressionElementType.OPEN_PARENTHESIS) {
                return true;
            }
        }
        return false;
    }

    private void doComputeInBrackets(Expression expression) {
        int[] arrayFromTo = searchExpressionToCompute(expression.elementSet);

        List<ExpressionElement> elementSetForCompute =
                new ArrayList<ExpressionElement>(expression.elementSet.subList(arrayFromTo[0] + 1, arrayFromTo[1]));

        expressDecision(elementSetForCompute);

        removeElementFromList(expression.elementSet, arrayFromTo[0], arrayFromTo[1]);

        expression.elementSet.add(arrayFromTo[0], elementSetForCompute.get(0));
    }

    /**
     * находим индексы скобок "(" и ")" в списке выражения
     * результат int[]
     * где result[0] - индекс "(", result[1] - индекс ")"
     * */
    private int[] searchExpressionToCompute(List<ExpressionElement> elementSet) {
        int[] result = {0, 0};
        boolean flag = false;

        for (int i = 0; i < elementSet.size(); i++) {
            if (elementSet.get(i).elementType == ExpressionElementType.OPEN_PARENTHESIS) {
                flag = true;
                result[0] = i;
            }

            if (elementSet.get(i).elementType == ExpressionElementType.CLOSE_PARENTHESIS && flag) {
                flag = false;
                result[1] = i;
            }

            if (elementSet.get(i).elementType != ExpressionElementType.OPEN_PARENTHESIS && flag
                    && elementSet.get(i).elementType != ExpressionElementType.CLOSE_PARENTHESIS) {
            }

            if (elementSet.get(i).elementType == ExpressionElementType.OPEN_PARENTHESIS) {
                result[0] = i;
            }
        }

        return result;
    }

    private double expressDecision(List<ExpressionElement> elementSet) {
        while (isOperationPriority(elementSet, 5)) {
            doOperation(elementSet, 5);
        }

        while (isOperationPriority(elementSet, 4)) {
            doOperation(elementSet, 4);
        }

        while (isOperationPriority(elementSet, 3)) {
            doOperation(elementSet, 3);
        }

        return elementSet.get(0).value;
    }

    private void removeElementFromList(List<ExpressionElement> list, int from, int to) {
        for (int i = from - 1, j = from; i < to; i++) {
            list.remove(j);
        }
    }

    private boolean isOperationPriority(List<ExpressionElement> elementSet, int operationPriority) {
        for (ExpressionElement expressionElement : elementSet) {
            if (expressionElement.operationPriority == operationPriority)
                return true;
        }
        return false;
    }

    private List<ExpressionElement> doOperation(List<ExpressionElement> elementSet, int operationPriority) {
        Maths maths = new Maths();

        for (int i = 1; i < elementSet.size()-1; i++) {
            if (elementSet.get(i).operationPriority == operationPriority) {
                if (operationPriority == 5) {
                    elementSet.get(i-1).value =
                            maths.power(elementSet.get(i-1).value, elementSet.get(i+1).value);
                }

                else if (operationPriority == 4) {
                    if (elementSet.get(i).elementType == ExpressionElementType.MULTIPLY) {
                        elementSet.get(i-1).value =
                                maths.multiply(elementSet.get(i-1).value, elementSet.get(i+1).value);
                    }
                    else if (elementSet.get(i).elementType == ExpressionElementType.DIVIDE){
                        elementSet.get(i-1).value =
                                maths.divide(elementSet.get(i-1).value, elementSet.get(i+1).value);
                    }
                }

                else if (operationPriority == 3) {
                    if (elementSet.get(i).elementType == ExpressionElementType.PLUS) {
                        elementSet.get(i-1).value =
                                maths.add(elementSet.get(i-1).value, elementSet.get(i+1).value);
                    }
                    else if (elementSet.get(i).elementType == ExpressionElementType.MINUS){
                        elementSet.get(i-1).value =
                                maths.subtract(elementSet.get(i-1).value, elementSet.get(i+1).value);
                    }
                }

                elementSet.remove(i+1);
                elementSet.remove(i);

                return elementSet;
            }
        }

        return elementSet;
    }
}
