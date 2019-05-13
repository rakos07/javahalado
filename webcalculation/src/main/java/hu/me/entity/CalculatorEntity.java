package hu.me.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalculatorEntity {
    @Id
    @GeneratedValue
    private int id;
    private double num1;
    private double num2;
    private String operations;
    private double result;
    private int userID;

    public CalculatorEntity(){}

    public CalculatorEntity(double num1, double num2, String operations, double result, int userID) {
        this.num1 = num1;
        this.num2 = num2;
        this.operations = operations;
        this.result = result;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNum1() { return num1; }

    public void setNum1(Double num1) { this.num1 = num1; }

    public Double getNum2() { return num2; }

    public void setNum2(Double num2) { this.num2 = num2; }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}