package com.lambdaschool.android_unittest_calculator;

public class Calculator {

    private String expression;

    public Calculator() {
        this.expression = "";
    }

    public String addSymbol(String symbol) {
        String firstChar = symbol.substring(0, 1);
        this.expression += firstChar;
        return firstChar;
    }

    public String addDecimal() {
        return expression;
    }

    public String backspace() {
        return expression;
    }

    public String addition() {
        return expression;
    }

    public String subtraction() {
        return expression;
    }

    public String multiplication() {
        return expression;
    }

    public String division() {
        return expression;
    }

    public String square() {
        return expression;
    }

    public String squareRoot() {
        return expression;
    }

    public String pi() {
        return expression;
    }

    public String calculate() {
        return expression;
    }

    public void reset() {

    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
