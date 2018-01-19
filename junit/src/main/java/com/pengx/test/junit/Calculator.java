package com.pengx.test.junit;

/**
 * @author PengXin
 */
public class Calculator {

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Divider cannot be 0");
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

}
