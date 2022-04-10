package com.example.goodbills;

import java.io.Serializable;

public class Traveller implements Serializable {

    private String name;
    private double expenses;

    public Traveller(String name) {
        this.name = name;
        this.expenses = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}
