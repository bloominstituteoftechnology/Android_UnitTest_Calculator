package com.example.calculatorunittest.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public enum Operator {ADD, SUBTRACT, DIVISION, MULTIPLICATION}

    private String calculations;
    private Operator operator;
    private Double lastDigit = 0.0;
    private Double lastSum = 0.0;

    public Calculator() {
    }

    public String addSymbol(String string) {
    //todo
        if (calculations == "" || calculations == null) {
            calculations = string;
        } else {
            calculations += string;
        }
        return calculations;
    }

    public String getCalculations() {
        return calculations;
    }

    public String addDecimal() {
        if (calculations.contains(".")) {
            return calculations;
        } else {
            return calculations += ".";
        }
    }

    public String removeLastCharacter() {
        if (!calculations.isEmpty()) {
            calculations = calculations.substring(0, calculations.length() - 1);
        } else {
            calculations = "";
        }
        return calculations;

    }

    public String add() {
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("\\+")));

        Double num1 = Double.parseDouble(values.get(0));
        Double num2 = Double.parseDouble(values.get(1));
        Double sum = num1 + num2;

        operator = Operator.ADD;
        lastSum = sum;
        lastDigit = num2;
        return sum.toString();
    }

    public String sub() {
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("-")));
        Double num1 = Double.parseDouble(values.get(0));
        Double num2 = Double.parseDouble(values.get(1));
        Double sum = num1 - num2;
        operator = Operator.SUBTRACT;
        lastSum = sum;
        lastDigit = num2;

        return sum.toString();

    }

    public String div() {
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("/")));
        Double num1 = Double.parseDouble(values.get(0));
        Double num2 = Double.parseDouble(values.get(1));
        if (num2 == 0) {
            return null;
        } else {
            Double sum = num1 / num2;
            operator = Operator.DIVISION;
            lastSum = sum;
            lastDigit = num2;
            return sum.toString();

        }
    }

    public String mult() {
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("\\*")));
        Double num1 = Double.parseDouble(values.get(0));
        Double num2 = Double.parseDouble(values.get(1));
        Double sum = num1 * num2;
        operator = Operator.MULTIPLICATION;
        lastSum = sum;
        lastDigit = num2;
        return sum.toString();

    }

    public String repeatCalc() {
        double answer = 0.0;
        switch (operator) {
            case ADD:
                 answer = lastSum + lastDigit;
            break;
            case SUBTRACT:
                answer = lastSum - lastDigit;
            break;
            case DIVISION:
                answer = lastSum / lastDigit;
            break;
            case MULTIPLICATION:
                answer = lastSum * lastDigit;
            break;
        }
        return String.valueOf(answer);
    }

    public void clear() {
        calculations = "";
    }
}
