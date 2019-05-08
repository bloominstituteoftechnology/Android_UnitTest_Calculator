package com.example.israel.android_unittest_calculator;

public class Calculator {

    public static final String OPERATORS = "+-*/";
    private StringBuilder symbols = new StringBuilder();

    public Calculator() {

    }

    public String getSymbols() {
        return symbols.toString();
    }

    public String addSymbol(String symbol) {
        // @NOTE: in case a multi-letter-symbol is implemented it accepts a string
        // but for now, only single-letter-symbol is accepted

        if (symbol.length() != 1) {
            return symbols.toString();
        }

        if (symbols.length() == 0) {
            // first symbol is operator check
            for (int i = 0; i < OPERATORS.length(); ++i) {
                String operatorStr = Character.toString(OPERATORS.charAt(i));
                if (symbol.equals(operatorStr)) { // adding operator symbol
                    return "";
                }
            }

            // add 0 first if first symbol is decimal
            if (symbol.equals(".")) {
                symbols.append("0");
            }
        } else {
            // double decimal check
            if (symbol.equals(".") && symbols.indexOf(symbol) != -1) {
                return symbols.toString();
            }

            char lastChar = symbols.charAt(symbols.length() - 1);

            for (int i = 0; i < OPERATORS.length(); ++i) {
                if (lastChar == OPERATORS.charAt(i)) { // last char is an operator
                    // consecutive operator check
                    for (int j = 0; j < OPERATORS.length(); ++j) {
                        String operatorStr = Character.toString(OPERATORS.charAt(j));
                        if (symbol.equals(operatorStr)) { // adding operator symbol
                            return symbols.toString();
                        }
                    }
                    break;
                }
            }
        }

        symbols.append(symbol);
        return symbols.toString();
    }

    public String removeLast() {
        int length = symbols.length();
        if (length == 0) {
            return "";
        }

        symbols.setLength(length - 1);
        return symbols.toString();
    }

    public String calculate() {
        if (symbols.length() == 0) {
            return "";
        }

        float total = 0.f;
        Character operator = null;
        for (int i = 0; i < symbols.length(); ++i) {
            StringBuilder numberStr = new StringBuilder();
            char c = symbols.charAt(i);
            do { // build a numberStr until it hits an operator
                numberStr.append(c);

                // this is the last char and it's a number
                if (i == symbols.length() - 1) {

                    if (operator == null) { // only number
                        return "";
                    }

                    // do the last calculation
                    total = calculate(total, Float.parseFloat(numberStr.toString()), operator);
                    if (total == Math.round(total)) { // float can be an integer
                        return Integer.toString((int)total);
                    }
                    return Float.toString(total);
                }

                c = symbols.charAt(++i);
            } while (Character.isDigit(c) || c == '.');

            // this is the last char and it's an operator
            if (i == symbols.length() - 1) { // TODO this can be checked at the start
                return "";
            }

            if (operator != null) {
                // do the calculation
                total = calculate(total, Float.parseFloat(numberStr.toString()), operator);
            } else {
                total = Float.parseFloat(numberStr.toString());
            }
            numberStr.setLength(0);

            operator = c;
        }

        return Float.toString(total);
    }

    private static float calculate(float numberA, float numberB, Character operator) {
        switch (operator) {
            case '+': return numberA + numberB;
            case '-': return numberA - numberB;
            case '*': return numberA * numberB;
            case '/': return numberA / numberB;
        }

        return 0.f;
    }

    public void clear() {
        symbols.setLength(0);
    }

}
