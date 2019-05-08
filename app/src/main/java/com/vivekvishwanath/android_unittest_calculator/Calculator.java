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

    public String subtract() {
        String[] numbers = enteredSymbols.split("-");
        double before = Double.parseDouble(numbers[0]);
        double after = Double.parseDouble(numbers[1]);

        double difference = before - after;
        enteredSymbols = Double.toString(difference);
        return enteredSymbols;
    }

    public String multiply() {
        String[] numbers = enteredSymbols.split("\\*");
        double before = Double.parseDouble(numbers[0]);
        double after = Double.parseDouble(numbers[1]);

        double product = before * after;
        enteredSymbols = Double.toString(product);
        return enteredSymbols;
    }

    public String divide() {
        String[] numbers = enteredSymbols.split("/");
        double before = Double.parseDouble(numbers[0]);
        double after = Double.parseDouble(numbers[1]);

        double quotient = before / after;
        enteredSymbols = Double.toString(quotient);
        return enteredSymbols;
    }

    public String clear() {
        enteredSymbols = "";
        return enteredSymbols;
    }

}
