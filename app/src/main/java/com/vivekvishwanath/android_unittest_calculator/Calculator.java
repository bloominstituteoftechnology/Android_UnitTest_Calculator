package com.vivekvishwanath.android_unittest_calculator;

public class Calculator {

    private String enteredSymbols;

    public Calculator() {
        enteredSymbols = "";
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

}
