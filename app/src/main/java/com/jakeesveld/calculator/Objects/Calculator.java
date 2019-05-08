package com.jakeesveld.calculator.Objects;

public class Calculator {
    public static final String INVALID = "Invalid";
    private String firstNumber, secondNumber, operand, keptOperand, keptSecondNumber;

    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String ADD = "add";
    public static final String SUBTRACT = "subtract";

    public Calculator() {
        firstNumber = "";
        secondNumber = "";
        operand = null;
        keptOperand = null;
        keptSecondNumber = null;
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
        if(!operand.equals(ADD) && !operand.equals(SUBTRACT) && !operand.equals(DIVIDE) && !operand.equals(MULTIPLY)){
            return INVALID;
        }
        this.operand = operand;
        return this.operand;
    }

    public String calculate(){
        Float result = null;
        switch (operand){
            case ADD:
                result = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
                break;
            case SUBTRACT:
                result = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
                break;
            case MULTIPLY:
                result = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
                break;
            case DIVIDE:
                if(secondNumber.equals("0")){
                    return INVALID;
                }
                result = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
                break;
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
                return String.valueOf(resultInt);
            }

            return String.valueOf(result);
        }

        return INVALID;
    }
}
