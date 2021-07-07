package com.example.patrickjmartin.androidunittestcalculator;

import android.support.v4.view.PagerTabStrip;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;

public class Calculator {

//    private String currentTotal;
//    private String finalTotal;
    private Stack<Double> numberStack;
    private Stack<String> operatorStack;
    NumberFormat stringFormat = new DecimalFormat("#.####");



    public Calculator() {
        numberStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public void numberStack(String inputNumber) {
        double number = Double.parseDouble(inputNumber);
        numberStack.push(number);
    }

    public void operationStack(String operator) {
        operatorStack.push(operator);
    }

    public String addOperation(String input) {
        String result = "";
        //TODO
        return result;
    }

    public String addOperation(String input1, String input2) {
        Double in1Double = Double.parseDouble(input1);
        Double in2Double = Double.parseDouble(input2);

        Double doubleResult = in1Double + in2Double;

        return stringFormat.format(doubleResult);
    }

    public String subtractOperation(String input) {
        String result = "";
        //TODO

        return result;
    }

    public String subtractOperation(String input1, String input2) {


        Double in1Double = Double.parseDouble(input1);
        Double in2Double = Double.parseDouble(input2);

        Double doubleResult = in1Double - in2Double;

        return stringFormat.format(doubleResult);
    }

    public String multiplyOperation(String input) {
        String result = "";
        //TODO
        return result;
    }

    public String multiplyOperation(String input1, String input2) {
        Double in1Double = Double.parseDouble(input1);
        Double in2Double = Double.parseDouble(input2);

        Double doubleResult = in1Double * in2Double;

        return stringFormat.format(doubleResult);
    }

    public String divideOperation(String input) {
        String result = "";
        //TODO
        return result;
    }

    public String divideOperation(String input1, String input2) {
        Double in1Double = Double.parseDouble(input1);
        Double in2Double = Double.parseDouble(input2);

        if(in2Double == 0) {
            return "DNE";
        } else {
            Double doubleResult = in1Double / in2Double;
            return stringFormat.format(doubleResult);
        }
    }





}
