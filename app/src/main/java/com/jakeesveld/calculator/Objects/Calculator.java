package com.jakeesveld.calculator.Objects;

public class Calculator {
    public static final String INVALID = "Invalid";
    private String firstNumber;
    private String secondNumber;
    private String operand;

    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String ADD = "add";
    public static final String SUBTRACT = "subtract";

    public Calculator() {
        firstNumber = "";
        secondNumber = "";
        operand = null;
    }

    public String addSymbol(String symbol){
        StringBuilder builder = new StringBuilder();
        try{
            Integer.valueOf(symbol);
        } catch (Exception e){
            if(symbol.equals(".") && operand == null){
                builder.append(firstNumber).append(symbol);
                firstNumber = builder.toString();
                return firstNumber;
            }else if (symbol.equals(".")){
                builder.append(secondNumber).append(symbol);
                secondNumber = builder.toString();
                return secondNumber;
            }else{
                return INVALID;
            }
        }

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

    public String setOperand(String operand){
        this.operand = operand;
        return this.operand;
    }
}
