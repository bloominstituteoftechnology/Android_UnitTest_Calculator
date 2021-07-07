package com.example.patrickjmartin.androidunittestcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void addingTwoWholeNumber() {
        //Setup
        String expected = "5";

        //Execution
        String actual = calculator.addOperation("3","2");

        //Check
        assertEquals(expected, actual);
    }

    @Test
    public void addingTwoDecimals() {
        //Setup
        String expected = "5.2";

        //Execution
        String actual = calculator.addOperation("3","2.2");

        //Check
        assertEquals(expected, actual);
    }

    @Test
    public void subtractingTwoWholeNumber() {
        //Setup
        String expected = "1";

        //Execution
        String actual = calculator.subtractOperation("3","2");

        //Check
        assertEquals(expected, actual);
    }

    @Test
    public void subtractingTwoDecimals() {
        //Setup
        String expected = "0.8";

        //Execution
        String actual = calculator.subtractOperation("3","2.2");

        //Check
        assertEquals(expected, actual);
    }

    @Test
    public void dividingTwoWholeNumber() {
        //Setup
        String expected = "4";

        //Execution
        String actual = calculator.divideOperation("8","2");

        //Check
        assertEquals(expected, actual);
    }

    @Test
    public void dividingTwoDecimals() {
        //Setup
        String expected = "1.5";

        //Execution
        String actual = calculator.divideOperation("3","2");

        //Check
        assertEquals(expected, actual);
    }

}






//    Old Test
//    @Test
//    public void addSymbolreturnsSameStringInitially() {
//        //Setup
//        String expected = "+";
//
//        //Execution
//        String actual = calculator.addSymbol("+");
//
//        //Check
//        //Success
//        assertEquals("+", calculator.addSymbol("+"));
//    }

//    Old Test
//    @Test
//    public void addSymbolshouldReturnMultipleStringsWhenMoreSymbolsAdded() {
//        String multipleStringsCombined = "5.92";
//
//        Calculator.addSymbol("5");
//        Calculator.addSymbol(".");
//        Calculator.addSymbol("9");
//
//        //Failure
//        assertEquals(multipleStringsCombined, calculator.addSymbol("2"));
//    }
