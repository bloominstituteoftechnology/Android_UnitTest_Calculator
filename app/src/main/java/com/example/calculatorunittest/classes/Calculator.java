package com.example.calculatorunittest.classes;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public enum Operator{ADD, SUBTRACT, DIVISION, MULTIPLICATION}

    private String calculations;

    public Calculator() {
    }

    public String addSymbol(String string){

        if (calculations == "" || calculations == null ){
            calculations = string;
        }else {
            calculations += string;
        }
        return calculations;
    }

    public  String getCalculations(){
        return calculations;
    }

    public String addDecimal(){
        if (calculations.contains(".")){
            return calculations;
        }else {
            return calculations += ".";
        }
    }

    public String removeLastCharacter(){
        if (!calculations.isEmpty()){
            calculations = calculations.substring(0, calculations.length() - 1);
        }else {
            calculations = "";
        }
        return calculations;

    }

    public String add(){
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("\\+")));

        Double num1 = Double.parseDouble(values.get(0));
        Double num2 = Double.parseDouble(values.get(1));
        Double sum = num1 + num2;

        return sum.toString();
    }

    public String sub(){
        //todo figure out how how I want to get data
        ArrayList<String> values = new ArrayList<>(Arrays.asList(calculations.split("-")));
        Double sum = Double.valueOf(values.get(0));
        for (int i = 1; i < calculations.length(); i++) {
            if (Character.isDigit(calculations.charAt(i))){
                sum -= Character.getNumericValue(calculations.charAt(i));
            }

        }
        return sum.toString();

    }

    public String div(){
        //todo figure out how how I want to get data
        return null;

    }

    public String mult(){
        //todo figure out how how I want to get data
        return null;

    }

    public void clear(){
        calculations = "";
    }
}
