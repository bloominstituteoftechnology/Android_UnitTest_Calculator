package com.jakeesveld.calculator.Objects;

public class Calculator {
    private String firstNumber;
    private String secondNumber;
    private String operand;

    private static final String MULTIPLY = "multiply";
    private static final String DIVIDE = "divide";
    private static final String ADD = "add";
    private static final String SUBTRACT = "subtract";

    public Calculator() {
        firstNumber = "";
        secondNumber = "";
        operand = null;
    }

    public String addSymbol(String symbol){
        StringBuilder builder = new StringBuilder();
        if(operand == null) {
            builder.append(firstNumber).append(symbol);
            firstNumber = builder.toString();
            return firstNumber;
        }else{
            builder.append(secondNumber).append(symbol);
            secondNumber = builder.toString();
            return secondNumber;
        }
    }

    public String removeLastSymbol(){
        StringBuilder builder = new StringBuilder();
        if(operand == null){
            builder.append(firstNumber).deleteCharAt(firstNumber.length() -1);
            firstNumber = builder.toString();
            return firstNumber;
        } else if (secondNumber != null){
            builder.append(secondNumber).deleteCharAt(secondNumber.length() -1);
            secondNumber = builder.toString();
            return secondNumber;
        } else{
            operand = null;
            return "";
        }
    }
}
