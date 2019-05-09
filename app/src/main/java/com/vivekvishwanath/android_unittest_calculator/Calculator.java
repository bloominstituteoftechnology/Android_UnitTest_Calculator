package com.vivekvishwanath.android_unittest_calculator;

public class Calculator {

    private String enteredSymbols;
    private String previousSymbols;


    public Calculator() {
        enteredSymbols = "";
        previousSymbols = "";
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
        if (enteredSymbols.contains("+")) {
            previousSymbols = enteredSymbols;
            String[] numbers = enteredSymbols.split("\\+");
            double before = Double.parseDouble(numbers[0]);
            double after = Double.parseDouble(numbers[1]);

            double sum = before + after;
            enteredSymbols = Double.toString(sum);
            return enteredSymbols;
        }
        return enteredSymbols;
    }

    public String subtract() {
        if (enteredSymbols.contains("-")) {
            previousSymbols = enteredSymbols;
            String[] numbers = enteredSymbols.split("-");
            double before = Double.parseDouble(numbers[0]);
            double after = Double.parseDouble(numbers[1]);

            double difference = before - after;
            enteredSymbols = Double.toString(difference);
            return enteredSymbols;
        }
        return enteredSymbols;
    }

    public String multiply() {
        if (enteredSymbols.contains("*")) {
            previousSymbols = enteredSymbols;
            String[] numbers = enteredSymbols.split("\\*");
            double before = Double.parseDouble(numbers[0]);
            double after = Double.parseDouble(numbers[1]);

            double product = before * after;
            enteredSymbols = Double.toString(product);
            return enteredSymbols;
        }
        return enteredSymbols;
    }

    public String divide() {
        if (enteredSymbols.contains("/")) {
            previousSymbols = enteredSymbols;
            String[] numbers = enteredSymbols.split("/");
            double before = Double.parseDouble(numbers[0]);
            double after = Double.parseDouble(numbers[1]);

            double quotient = before / after;
            enteredSymbols = Double.toString(quotient);
            return enteredSymbols;
        }
        return enteredSymbols;
    }

    public String clear() {
        enteredSymbols = "";
        return enteredSymbols;
    }

    public String performRepeatedCalculation() {
        if (previousSymbols.contains("+")) {
            String[] numbers = previousSymbols.split("\\+");
            double operand = Double.parseDouble(numbers[1]);
            double previousResult = Double.parseDouble(enteredSymbols);
            double result = previousResult + operand;
            enteredSymbols = Double.toString(result);
            return enteredSymbols;
        } else if (previousSymbols.contains("-")) {
            String[] numbers = previousSymbols.split("-");
            double operand = Double.parseDouble(numbers[1]);
            double previousResult = Double.parseDouble(enteredSymbols);
            double result = previousResult - operand;
            enteredSymbols = Double.toString(result);
            return enteredSymbols;
        } else if (previousSymbols.contains("*")) {
            String[] numbers = previousSymbols.split("\\*");
            double operand = Double.parseDouble(numbers[1]);
            double previousResult = Double.parseDouble(enteredSymbols);
            double result = previousResult * operand;
            enteredSymbols = Double.toString(result);
            return enteredSymbols;
        } else if (previousSymbols.contains("/")) {
            String[] numbers = previousSymbols.split("/");
            double operand = Double.parseDouble(numbers[1]);
            double previousResult = Double.parseDouble(enteredSymbols);
            double result = previousResult / operand;
            enteredSymbols = Double.toString(result);
            return enteredSymbols;
        }
        return enteredSymbols;
    }

}
