package com.jakeesveld.calculator.Objects;

public class Calculator {
    public static final String INVALID = "Invalid";
    public static final String CLEAR = "clear";
    private String firstNumber, secondNumber, operand, keptOperand, keptSecondNumber, keptResult;

    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String ADD = "add";
    public static final String SUBTRACT = "subtract";
    public static final String SQUARE = "square";
    public static final String SQUARE_ROOT = "square_root";

    public Calculator() {
        firstNumber = "";
        secondNumber = "";
        operand = null;
        keptOperand = null;
        keptSecondNumber = null;
    }

    public String clear(){
        firstNumber = "";
        secondNumber = "";
        operand = null;
        keptResult = null;
        keptOperand = null;
        keptSecondNumber = null;

        return CLEAR;
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
        if(firstNumber.equals("")){
            return INVALID;
        }
        if(operand.equals(SQUARE)){
            secondNumber = firstNumber;
            this.operand = MULTIPLY;
            return calculate();
        }
        if (operand.equals(SQUARE_ROOT)) {
            this.operand = SQUARE_ROOT;
            return calculate();
        }

        if(!operand.equals(ADD) && !operand.equals(SUBTRACT) && !operand.equals(DIVIDE) && !operand.equals(MULTIPLY)){
            return INVALID;
        }
        this.operand = operand;
        return this.operand;
    }

    public String calculate(){
        Double result = null;

        if(firstNumber.equals("") && secondNumber.equals("") && keptSecondNumber != null && keptOperand != null){
            firstNumber = keptResult;
            secondNumber = keptSecondNumber;
            operand = keptOperand;
        }
        switch (operand){
            case ADD:
                result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
            case SUBTRACT:
                result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case MULTIPLY:
                result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case DIVIDE:
                if(secondNumber.equals("0") || Double.valueOf(secondNumber) == 0.0){
                    return INVALID;
                }
                result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;
            case SQUARE_ROOT:
                result = Math.sqrt(Double.parseDouble(firstNumber));
                default:
                    break;
        }
        if(result != null){
            keptOperand = operand;
            keptSecondNumber = secondNumber;
            firstNumber = "";
            secondNumber = "";
            operand = null;

            if(result % 1.0 == 0) {
                int resultInt = (int) (result / 1);
                keptResult = String.valueOf(resultInt);
                return String.valueOf(resultInt);
            }
            keptResult = String.valueOf(result);
            return String.valueOf(result);
        }

        return INVALID;
    }
}
