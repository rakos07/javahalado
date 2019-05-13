package hu.me.dto;

import javax.validation.constraints.NotNull;

public class Input {
    @NotNull
    private String operations;
    @NotNull
    private Double num1;
    @NotNull
    private Double num2;
    @NotNull
    private int userID;
    @NotNull
    private String userName;
    @NotNull
    private int userAge;


    public Input(String operations, double num1, double num2, int userID, String userName, int userAge){
        this.operations = operations;
        this.num1 = num1;
        this.num2 = num2;
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
    }

    public String getOperations() {
        this.operations = operations;
        return operations;
    }

    public void setOperations(String operations){
        this.operations = operations;
    }

    public Double getNum1() { return num1; }

    public void setNum1(Double num1) { this.num1 = num1; }

    public Double getNum2() { return num2; }

    public void setNum2(Double num2) { this.num2 = num2; }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "Input{" +
                "operations=" + operations +
                ", operandus num1=" + num1 +
                ", operandus num2=" + num2 +
                ", id=" + userID +
                ", name=" + userName +
                ", age=" + userAge +
                '}';
    }
}
