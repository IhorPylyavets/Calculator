package com.goit.project.parser;

import com.goit.project.arithmetic.Compute;
import com.goit.project.expression.Expression;
import com.goit.project.expression.ExpressionElement;

/**
 * Created by vbevz on 5/14/2016.
 */
public class ParserRunner {
    public static void main(String[] args) {
        String stringExpression = "123.12 + 34 * (12 - 10)";
        Parser parser = new Parser();

        Expression expression = parser.parseExpression(stringExpression);

        for (ExpressionElement expressionElement : expression.elementSet) {
            System.out.println(expressionElement.toString());
        }

        Compute compute = new Compute();

        double res = compute.computeExpression(expression);

        System.out.println(res);
    }
}
