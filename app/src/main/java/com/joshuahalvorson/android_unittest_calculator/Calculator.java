package com.joshuahalvorson.android_unittest_calculator;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String TAG = "Calculator";

    String enteredString;
    String lastEnteredString;

    public Calculator() {
        this.enteredString = "";
        this.lastEnteredString = "";
    }

    public String addSymbol(String symbol){
        if(symbol.equals(".")){
            if(!enteredString.contains(".")){
                enteredString += symbol;
            }else{
                //Log.i(TAG, "Number can only have one decimal");
            }
        }else{
            enteredString += symbol;
        }
        lastEnteredString = enteredString;
        return enteredString;
    }

    public void removeLastAddedCharacter(){
        if(!enteredString.equals("")){
            enteredString = enteredString.substring(0, enteredString.length() - 1);
        }
    }

    public String performAddition(){
        lastEnteredString = enteredString;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(enteredString.split("\\+")));
        Double doubleResult = Double.parseDouble(strings.get(0));
        for(int i = 1; i < strings.size(); i++){
            doubleResult += Double.parseDouble(strings.get(i));
        }
        enteredString = doubleResult.toString();
        return enteredString;
    }

    public String performSubtraction(){
        lastEnteredString = enteredString;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(enteredString.split("-")));
        Double doubleResult = Double.parseDouble(strings.get(0));
        for(int i = 1; i < strings.size(); i++){
            doubleResult -= Double.parseDouble(strings.get(i));
        }
        enteredString = doubleResult.toString();
        return enteredString;
    }

    public String performMultiplication(){
        lastEnteredString = enteredString;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(enteredString.split("\\*")));
        Double doubleResult = Double.parseDouble(strings.get(0));
        for(int i = 1; i < strings.size(); i++){
            doubleResult *= Double.parseDouble(strings.get(i));
        }
        enteredString = doubleResult.toString();
        return enteredString;
    }

    public String performDivision(){
        lastEnteredString = enteredString;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(enteredString.split("/")));
        Double doubleResult = Double.parseDouble(strings.get(0));
        for(int i = 1; i < strings.size(); i++){
            doubleResult /= Double.parseDouble(strings.get(i));
        }
        enteredString = doubleResult.toString();
        return enteredString;
    }

    public String repeatLastCalculation(){
        if(lastEnteredString.contains("+")){
            enteredString = getResultFromRepeatedCalculation("+");
            performAddition();
            return enteredString;
        }else if(lastEnteredString.contains("-")){
            enteredString = getResultFromRepeatedCalculation("-");
            performSubtraction();
            return enteredString;
        }else if(lastEnteredString.contains("*")){
            enteredString = getResultFromRepeatedCalculation("*");
            performMultiplication();
            return enteredString;
        }else if(lastEnteredString.contains("/")){
            enteredString = getResultFromRepeatedCalculation("/");
            performDivision();
            return enteredString;
        }
        return "";
    }

    public void clearValues(){
        enteredString = "";
        lastEnteredString = "";
    }

    private String getResultFromRepeatedCalculation(String operator) {
        ArrayList<String> strings = new ArrayList<>();
        if(operator.equals("+")){
            strings = new ArrayList<>(Arrays.asList(lastEnteredString.split("\\+")));
        }else if(operator.equals("-")){
            strings = new ArrayList<>(Arrays.asList(lastEnteredString.split("-")));
        }else if(operator.equals("*")){
            strings = new ArrayList<>(Arrays.asList(lastEnteredString.split("\\*")));
        }else if(operator.equals("/")){
            strings = new ArrayList<>(Arrays.asList(lastEnteredString.split("/")));
        }
        if(strings.size() != 0){
            strings.set(0, enteredString);
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < strings.size(); i++){
                builder.append(strings.get(i)).append(operator);
            }
            String builderString = builder.toString();
            builderString = builderString.substring(0, builderString.length() - 1);
            return builderString;
        }
        return "";
    }

    public String getEnteredString() {
        return enteredString;
    }

}
