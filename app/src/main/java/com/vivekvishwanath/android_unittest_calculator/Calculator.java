package com.vivekvishwanath.android_unittest_calculator;

public class Calculator {

    private String enteredSymbols;
    private  String afterOpString;

    public Calculator() {
        enteredSymbols = "";
        afterOpString = "";
    }

    public String display() {
        return enteredSymbols;
    }

    public String addSymbol(String symbol) {
        if (symbol.equals(".")) {
            if (!enteredSymbols.contains(".")) {
                enteredSymbols += symbol;
                return enteredSymbols;
            } else {
                enteredSymbols = enteredSymbols.replace(".", "");
                enteredSymbols += symbol;
                return enteredSymbols;
            }
        } else {
            enteredSymbols += symbol;
            return enteredSymbols;
        }
    }

    public String add() {
        String[] numbers = enteredSymbols.split("\\+");
        double before = Double.parseDouble(numbers[0]);
        double after = Double.parseDouble(numbers[1]);

        double sum = before + after;
        enteredSymbols = Double.toString(sum);
        return enteredSymbols;
    }

}
