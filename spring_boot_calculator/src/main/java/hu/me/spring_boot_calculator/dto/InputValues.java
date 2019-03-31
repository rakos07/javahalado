package hu.me.spring_boot_calculator.dto;

import javax.validation.constraints.NotNull;


public class InputValues {

    @NotNull
    private String operation;

    @NotNull
    private Integer number1;

    @NotNull
    private Integer number2;

    public InputValues(@NotNull String operation, @NotNull Integer number1, @NotNull Integer number2) {
        this.operation = operation;
        this.number1 = number1;
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "InputValues{" +
                "operation='" + operation + '\'' +
                ", number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}

