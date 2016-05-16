package com.goit.project.parser;

import com.goit.project.expression.Expression;
import com.goit.project.expression.ExpressionElement;
import com.goit.project.expression.ExpressionElementType;

public class Parser {
    public Expression parseExpression(String stringExpression) throws IllegalArgumentException {
        Expression expression  = new Expression();
        char[] charArray = stringExpression.toCharArray();

        validationExpression(charArray);

        String str = "";
        for (int i = 0; i < charArray.length; i++) {
            if (isSign(charArray[i])) {
                if (str.length() == 0 && isSignMinus(charArray[i])) {
                    str = String.valueOf(charArray[i]);
                } else {
                    if (str.length() != 0) {
                        expression.elementSet.add(new ExpressionElement(Double.parseDouble(str)));
                    }

                    String stringSign = String.valueOf(charArray[i]);
                    expression.elementSet.add(new ExpressionElement(ExpressionElementType.stringToType(stringSign)));

                    str = "";
                }
            }
            else if (isDigit(charArray[i])) {
                if (str.length() == 0) {
                    str = String.valueOf(charArray[i]);
                } else {
                    str = str.concat(String.valueOf(charArray[i]));
                }
            }
        }

        if (!str.isEmpty()) {
            expression.elementSet.add(new ExpressionElement(Double.parseDouble(str)));
        }

        if (expression.elementSet.size() <= 2) {
            throw new IllegalArgumentException();
        }

        return expression;
    }

    private void validationExpression(char[] charArray) {
        if (!isCorrectCountBrackets(charArray)) {
            throw new IllegalArgumentException();
        }
        if (!isCorrectExpressionRegularitySignNumber(charArray)) {
            throw new IllegalArgumentException();
        }
        if (!isCorrectRegularityBrackets(charArray)) {
            throw new IllegalArgumentException();
        }
        if (!checkLastSignOfExpression(charArray)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCorrectCountBrackets(char[] charArray) {
        int countBrackets = 0;

        for (char c : charArray) {
            if (String.valueOf(c).equals(ExpressionElementType.OPEN_PARENTHESIS.toString())) {
                countBrackets += 1;
            }

            if (String.valueOf(c).equals(ExpressionElementType.CLOSE_PARENTHESIS.toString())) {
                countBrackets -= 1;
            }
        }

        if (countBrackets != 0) {
            return false;
        }
        return true;
    }

    private boolean isCorrectExpressionRegularitySignNumber(char[] charArray) {
        for (int i = 0; i < charArray.length-1; i++) {
            if (isOperationSign(charArray[i]) && isOperationSign(charArray[i+1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isOperationSign(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    private boolean isCorrectRegularityBrackets(char[] charArray) {
        int count = 0;

        for (char c : charArray) {
            if (String.valueOf(c).equals("(")) {
                count += 1;
            }

            if (String.valueOf(c).equals(")")) {
                count -= 1;
            }

            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLastSignOfExpression(char[] charArray) {
        return !isOperationSign(charArray[charArray.length-1]);
    }

    private boolean isSign(char c) {
        return "+-*/^()".indexOf(c) != -1;
    }

    private boolean isSignMinus(final char c) {
        return "-".indexOf(c) != -1;
    }

    private static boolean isDigit(final char c) {
        return "0123456789.".indexOf(c) != -1;
    }
}
