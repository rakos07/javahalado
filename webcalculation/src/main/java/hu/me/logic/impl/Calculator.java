package hu.me.logic.impl;

import hu.me.logic.CalculatorInterface;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements CalculatorInterface {
    public double add(double num1, double num2){ return num1 + num2; }

    public double sub(double num1, double num2){
        return num1 - num2;
    }

    public double mult(double num1, double num2){
        return num1 * num2;
    }

    public double div(double num1, double num2) { return num1 / num2; }
}
