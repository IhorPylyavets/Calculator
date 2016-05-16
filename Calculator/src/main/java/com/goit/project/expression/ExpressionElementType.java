package com.goit.project.expression;

public enum ExpressionElementType {

    NUMBER, PLUS, MINUS, MULTIPLY, DIVIDE, POWER, OPEN_PARENTHESIS, CLOSE_PARENTHESIS;

    @Override
    public String toString() {
        switch (this) {
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case MULTIPLY:
                return "*";
            case DIVIDE:
                return "/";
            case POWER:
                return "^";
            case OPEN_PARENTHESIS:
                return "(";
            case CLOSE_PARENTHESIS:
                return ")";
        }
        return null;
    }

    public static ExpressionElementType stringToType(String type) {
        if (type.equals("+")) return PLUS;
        else if (type.equals("-")) return MINUS;
        else if (type.equals("*")) return MULTIPLY;
        else if (type.equals("/")) return DIVIDE;
        else if (type.equals("^")) return POWER;
        else if (type.equals("(")) return OPEN_PARENTHESIS;
        else return CLOSE_PARENTHESIS;
    }
}
