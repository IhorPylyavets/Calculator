package com.goit.project.parser;

import org.junit.Test;

public class ParserTest {
    Parser parser = new Parser();

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpressionCountBrackets() throws Exception {
        String inputStringExpression  = "(23*2))";

        parser.parseExpression(inputStringExpression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpressionForCorrect() throws Exception {
        String inputStringExpression  = "(23*-2)";

        parser.parseExpression(inputStringExpression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpressionCorrectRegularityBrackets() throws Exception {
        String inputStringExpression  = ")23*2(";

        parser.parseExpression(inputStringExpression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpressionLastSignOfExpression() throws Exception {
        String inputStringExpression  = "(23*2)^";

        parser.parseExpression(inputStringExpression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpressionSize() throws Exception {
        String inputStringExpression  = "/2";

        parser.parseExpression(inputStringExpression);
    }
}