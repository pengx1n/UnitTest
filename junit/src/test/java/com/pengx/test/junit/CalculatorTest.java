package com.pengx.test.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author PengXin
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        mCalculator = null;
    }

    @Test
    public void sum() throws Exception {
        assertEquals(6, mCalculator.sum(1, 5), 0);
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(0, mCalculator.subtract(8, 8), 0);
    }

    @Test
    public void divide() throws Exception {
        assertEquals(0.33, mCalculator.divide(1, 3), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideException() {
        mCalculator.divide(4, 0);
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(9.0, mCalculator.multiply(3.0, 3), 0);
    }

}