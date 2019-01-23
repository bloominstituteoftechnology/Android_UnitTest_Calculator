package com.example.calculatorunittest.classes;

import android.text.TextUtils;

public class Calculator {

    public enum Operator{ADD, SUBTRACT, DIVISION, MULTIPLICATION}

    private String calculations;

    public Calculator() {
    }

    public static String addSymbol(String string){
        String result = null;
        if (string == "" || string == null ){
            result = "a";
        }else {
            result = string;
        }
        return result;
    }

    public  String getCalculations(String number){
        calculations = number;
        return calculations;
    }

    public String addDecimal(){
        if (calculations.contains(".")){
            return calculations;
        }else {
            return calculations += ".";
        }
    }
}
