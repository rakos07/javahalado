package hu.me.spring_boot_calculator.service;

import org.springframework.stereotype.Service;

@Service
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

    public double divide(double a, double b){ return a / b; }

}