package com.lambdaschool.android_unittest_calculator;

public class Calculator {

    public Calculator() {
    }

    public static String addSymbol(String symbol) {
        String firstChar = symbol.substring(0, 1);
        return firstChar;
    }
}
