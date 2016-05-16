package com.goit.project.arithmetic;

import com.goit.project.expression.Expression;
import com.goit.project.expression.ExpressionElement;
import com.goit.project.expression.ExpressionElementType;
import org.junit.Assert;
import org.junit.Test;

public class ComputeTest {
    Compute compute = new Compute();

    private static final double number1 = 123.12;
    private static final double number2 = 34;
    private static final double number3 = 12;
    private static final double number4 = 10;
    private static final double number5 = 1;
    private static final double number6 = 3;

    private static final ExpressionElement plus = new ExpressionElement(ExpressionElementType.PLUS);
    private static final ExpressionElement minus = new ExpressionElement(ExpressionElementType.MINUS);
    private static final ExpressionElement multiply = new ExpressionElement(ExpressionElementType.MULTIPLY);
    private static final ExpressionElement divide = new ExpressionElement(ExpressionElementType.DIVIDE);
    private static final ExpressionElement power = new ExpressionElement(ExpressionElementType.POWER);
    private static final ExpressionElement openParenthesis = new ExpressionElement(ExpressionElementType.OPEN_PARENTHESIS);
    private static final ExpressionElement closeParenthesis = new ExpressionElement(ExpressionElementType.CLOSE_PARENTHESIS);

    @Test
    public void testComputeExpressionFirst() throws Exception {
        //123.12 + 34 * (12 - 10)
        Expression expression = new Expression();
        expression.elementSet.add(new ExpressionElement(number1));
        expression.elementSet.add(plus);
        expression.elementSet.add(new ExpressionElement(number2));
        expression.elementSet.add(multiply);
        expression.elementSet.add(openParenthesis);
        expression.elementSet.add(new ExpressionElement(number3));
        expression.elementSet.add(minus);
        expression.elementSet.add(new ExpressionElement(number4));
        expression.elementSet.add(closeParenthesis);

        double expected = 191.12;
        double actualResult = compute.computeExpression(expression);

        Assert.assertEquals("Compute should be computeExpression correctly", expected, actualResult, 0.0001);
    }

    @Test
    public void testComputeExpressionSecond() throws Exception {
        //12 / 10 - 123.12 ^ (3 - 1)
        Expression expression = new Expression();
        expression.elementSet.add(new ExpressionElement(number3));
        expression.elementSet.add(divide);
        expression.elementSet.add(new ExpressionElement(number4));
        expression.elementSet.add(minus);
        expression.elementSet.add(new ExpressionElement(number1));
        expression.elementSet.add(power);
        expression.elementSet.add(openParenthesis);
        expression.elementSet.add(new ExpressionElement(number6));
        expression.elementSet.add(minus);
        expression.elementSet.add(new ExpressionElement(number5));
        expression.elementSet.add(closeParenthesis);

        double expected = -15157.3344;
        double actualResult = compute.computeExpression(expression);

        Assert.assertEquals("Compute should be computeExpression correctly", expected, actualResult, 0.0001);
    }
}