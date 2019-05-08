package com.jakeesveld.calculator.Objects;

public class Calculator {
    private String equation;
    public Calculator() {
        equation = "";
    }

    public String addSymbol(String symbol){
        StringBuilder builder = new StringBuilder();
        builder.append(equation).append(symbol);
        equation = builder.toString();
        return equation;
    }
}
