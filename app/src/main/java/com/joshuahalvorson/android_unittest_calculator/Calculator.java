package com.joshuahalvorson.android_unittest_calculator;

public class Calculator {
    String enteredString;

    public Calculator() {
        this.enteredString = "";
    }

    public String addSymbol(String symbol){
        enteredString += symbol;
        return enteredString;
    }

    public String getEnteredString() {
        return enteredString;
    }
}
