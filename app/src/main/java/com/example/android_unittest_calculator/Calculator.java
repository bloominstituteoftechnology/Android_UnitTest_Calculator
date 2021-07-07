package com.example.android_unittest_calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public static final String[] ALLOWED_SYMBOLS = {"+", "-", "*", "/"};

    private String displayString;
    private ArrayList<String> operators = new ArrayList<>();
    private ArrayList<Double> numbers = new ArrayList<>();
    private StringBuilder numberBuilder = new StringBuilder();

    public Calculator(String displayString) {
        this.displayString = displayString;
    }

    String addSymbol(String input) {
        if (Arrays.asList(ALLOWED_SYMBOLS).contains(input)) {
            if (displayString.length() == 0) {
                displayString += "0";
                numberBuilder.append("0");
            }
            String lastChar = displayString.substring(displayString.length() - 1);
            if (Arrays.asList(ALLOWED_SYMBOLS).contains(lastChar)) {
                removeLast();
            }
            operators.add(input);

            if(numberBuilder.length()>0) {
                numbers.add(Double.valueOf(numberBuilder.toString()));
                numberBuilder.setLength(0);
            }
            displayString += input;
        }
        return displayString;
    }

    String addDigit(String input) {
        String addedString = "";
        if (input.substring(0, 1).equals("-")) {
            addedString = "-";
            input = input.substring(1);
        }
        if (isDigitsOnly(input)) {
            addedString += input;
        }
        numberBuilder.append(addedString);
        displayString += addedString;
        return displayString;
    }


    String addDecimal() {
        //TODO add a 0 if not numeric before it.
        if (!displayString.contains(".")) {
            displayString += ".";
            numberBuilder.append(".");
        }
        return displayString;
    }

    String removeLast() {
        if (displayString.length() > 0) {
            //TODO figure out what to do if backpsace past an operator into a number.
            String lastChar = displayString.substring(displayString.length() - 1);
            if (Arrays.asList(ALLOWED_SYMBOLS).contains(lastChar)) {
                operators.remove(operators.size() - 1);
            }
            displayString = displayString.substring(0, displayString.length() - 1);
        }
        return displayString;
    }

    String calculate() {

        if(numberBuilder.length()>0) {
            numbers.add(Double.valueOf(numberBuilder.toString()));
            numberBuilder.setLength(0);
        } else if (numbers.size()<2){
            numbers.add(numbers.get(numbers.size()-1));
        }

        double total = numbers.get(0);

        for (int i = 0; i <operators.size(); ++i) {
            String operator = operators.get(i);
            double number = numbers.get(i + 1);
            switch (operator) {
                case "+":
                    total = total + number;
                    break;
                case "-":
                    total = total - number;
                    break;
                case "*":
                    total = total * number;
                    break;
                case "/":
                    total = total / number;
            }
        }

        Double lastNumber = numbers.get(numbers.size()-1);
        numbers.clear();
        numbers.add(total);
        numbers.add(lastNumber);

        String lastOperator = operators.get(operators.size()-1);
        operators.clear();
        operators.add(lastOperator);

        if (total == (int) total) {
            displayString = String.valueOf((int) total);
        } else {
            displayString = String.valueOf(total);
        }

        return displayString;
    }


    //Copied from TextUtils.isDigitsOnly to make it work with tests.
    private static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!Character.isDigit(cp)) {
                return false;
            }
        }
        return true;
    }


}
