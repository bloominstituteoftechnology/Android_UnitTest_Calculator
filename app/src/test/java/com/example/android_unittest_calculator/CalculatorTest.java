package com.example.android_unittest_calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator("");
    }

/*
    @Test
    public void shouldReturnSingleCharacterWhenSingleCharacterAdded() {
        //Setup
        String singleChar = "1";
        //Execution
        String checkString = calculator.addSymbol(singleChar);
        //Check
        assertEquals(singleChar, checkString);
    }

    @Test
    public void shouldReturnConcatenatedStringWhenMulitpleStringsAdded() {
        //Setup
        String string0 = "0";
        String string1 = ".";
        String string2 = "7";
        String string3 = "1";
        String string4 = "46";
        String concatenatedString = string0 + string1 + string2 + string3 + string4;

        //Execution
        calculator.addSymbol(string0);
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        String checkString = calculator.addSymbol(string4);

        //Check
        assertEquals(concatenatedString, checkString);
    }
*/

    @Test
    public void shouldReturnSingleDecimalIfMultipleAdded() {
        //Setup
        String initialString = "12345";
        String expectedString = "12345.";
        //Execution
        calculator.addDigit(initialString);
        String checkString = calculator.addDecimal();
        checkString = calculator.addDecimal();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnWithLastItemRemoved() {
        //Setup
        String initialString = "12345";
        String backspacedString = "1234";
        //Execution
        calculator.addDigit(initialString);
        String checkString = calculator.removeLast();
        //Check
        assertEquals(backspacedString, checkString);
    }

    @Test
    public void shouldReturnStringWithAddedDigits() {
        //Setup
        String digitsToAdd = "12345";
        //Execution
        String checkString = calculator.addDigit(digitsToAdd);
        //Check
        assertEquals(digitsToAdd, checkString);
    }

    @Test
    public void shouldNotReturnStringWithAddedLetters() {
        //Setup
        String digitsToAdd = "abcde";
        //Execution
        String checkString = calculator.addDigit(digitsToAdd);
        //Check
        assertNotEquals(digitsToAdd, checkString);
    }

    @Test
    public void shouldReturnStringWithAddedSymbol() {
        //Setup
        String initialString = "12345";
        String expectedString = "12345+";
        //Execution
        calculator.addDigit(initialString);
        String checkString = calculator.addSymbol("+");
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnStringWithLeading0IfSymbolFirst() {
        //Setup
        String expectedString = "0+";
        //Execution
        String checkString = calculator.addSymbol("+");
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnWithLastSymbolChangedRatherThanAddedIfLastCharacterIsAlreadyASymbol() {
        //Setup
        String initialString = "12345";
        String expectedString = "12345-";
        //Execution
        calculator.addDigit(initialString);
        calculator.addSymbol("+");
        String checkString = calculator.addSymbol("-");
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnAdditionCalculation() {
        //Setup
        String string1 = "1";
        String operator = "+";
        String string2 = "2";
        String expectedString = "3";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnSubtractionCalculation() {
        //Setup
        String string1 = "3";
        String operator = "-";
        String string2 = "2";
        String expectedString = "1";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnMultiplicationCalculation() {
        //Setup
        String string1 = "4";
        String operator = "*";
        String string2 = "2";
        String expectedString = "8";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnDivisionCalculation() {
        //Setup
        String string1 = "8";
        String operator = "/";
        String string2 = "2";
        String expectedString = "4";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnCalculationWhenLastItemIsASymbol() {
        //Setup
        String string1 = "2";
        String operator = "+";
        String expectedString = "4";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnCorrectlyWhenInputInAddDigitsIsNegative() {
        //Setup
        String string1 = "-4";
        String expectedString = "-4";
        //Execution
        String checkString = calculator.addDigit(string1);
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnCalculationCorrectlyWhenNegative() {
        //Setup
        String string1 = "-8";
        String operator = "/";
        String string2 = "2";
        String expectedString = "-4";
        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        String checkString = calculator.calculate();
        //Check
        assertEquals(expectedString, checkString);
    }

    @Test
    public void shouldReturnContinuedCalculationIfCaclulationCalledMultipleTimes () {
        //Setup
        String string1 = "5";
        String operator = "+";
        String string2 = "1";
        String expectedString = "8";

        //Execution
        calculator.addDigit(string1);
        calculator.addSymbol(operator);
        calculator.addDigit(string2);
        calculator.calculate();
        calculator.calculate();
        String checkString = calculator.calculate();

        //Check
        assertEquals(expectedString, checkString);
    }


}