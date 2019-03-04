package hu.me.logika;

import hu.me.logika.Calculator;

public class CalculatorImpl implements Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b){

        return a / b;
    }

}

