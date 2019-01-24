package com.example.calculatorunittest.classes;

import android.text.TextUtils;

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
        return null;
    }

    public String sub(){
        //todo figure out how how I want to get data
        return null;

    }

    public String div(){
        //todo figure out how how I want to get data
        return null;

    }

    public String mult(){
        //todo figure out how how I want to get data
        return null;

    }
}
