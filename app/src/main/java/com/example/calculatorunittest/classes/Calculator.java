package com.example.calculatorunittest.classes;

import android.text.TextUtils;

public class Calculator {

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
}
