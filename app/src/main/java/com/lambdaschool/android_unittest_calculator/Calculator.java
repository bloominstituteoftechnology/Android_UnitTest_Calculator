package com.lambdaschool.android_unittest_calculator;

public class Calculator {

    private String expression;

    public Calculator() {
        expression = "";
    }

    public String addSymbol(String symbol) {
        String firstChar = symbol.substring(0, 1);
        this.expression += firstChar;
        return firstChar;
    }
}
