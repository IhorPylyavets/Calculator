package com.goit.project.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class MathsTest {
    Maths maths = new Maths();

    private static final double a = 34.2;
    private static final double b = 67.09;

    @Test
    public void testAdd() throws Exception {
        double expected = 101.29;
        double actualResult = maths.add(a, b);

        Assert.assertEquals("Maths should be add correctly", expected, actualResult, 0.0001);
    }

    @Test
    public void testSubtract() throws Exception {
        double expected = -32.89;
        double actualResult = maths.subtract(a, b);

        Assert.assertEquals("Maths should be subtract correctly", expected, actualResult, 0.0001);
    }

    @Test
    public void testMultiply() throws Exception {
        double expected = 2294.478;
        double actualResult = maths.multiply(a, b);

        Assert.assertEquals("Maths should be multiply correctly", expected, actualResult, 0.0001);
    }

    @Test
    public void testDivide() throws Exception {
        double expected = 0.509763;
        double actualResult = maths.divide(a, b);

        Assert.assertEquals("Maths should be divide correctly", expected, actualResult, 0.0001);
    }

    @Test
    public void testPower() throws Exception {
        double expected = 1169.64;
        double actualResult = maths.power(a, 2);

        Assert.assertEquals("Maths should be power correctly", expected, actualResult, 0.0001);
    }
}