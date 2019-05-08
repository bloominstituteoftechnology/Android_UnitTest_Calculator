package com.example.israel.android_unittest_calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void addSymbol_SingleCharacter() {
        Calculator calculator = new Calculator();

        assertEquals("1", calculator.addSymbol("1"));
    }

    @Test
    public void addSymbol_ConsecutiveCharacters() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("2");
        calculator.addSymbol("3");

        assertEquals("1234", calculator.addSymbol("4"));
    }

    @Test
    public void addSymbol_CannotHaveDoubleDecimal() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol(".");
        calculator.addSymbol("2");

        assertEquals("1.2", calculator.addSymbol("."));
    }

    @Test
    public void addSymbol_AddZeroFirstIfFirstSymbolIsDecimal() {
        Calculator calculator = new Calculator();

        assertEquals("0.", calculator.addSymbol("."));
    }

    @Test
    public void removeLast_NoSymbol() {
        Calculator calculator = new Calculator();

        calculator.removeLast();
    }

    @Test
    public void removeLast_HasSymbol() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("2");

        assertEquals("1", calculator.removeLast());
    }

    @Test
    public void addSymbol_OperatorsCannotBeAddedFirst() {
        for (int i = 0; i < Calculator.OPERATORS.length(); ++i) {
            Calculator calculator = new Calculator();

            String operatorStr = Character.toString(Calculator.OPERATORS.charAt(i));
            assertEquals("", calculator.addSymbol(operatorStr));
        }

    }

    @Test
    public void addSymbol_CannotHaveConsecutiveOperators() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("2");
        calculator.addSymbol("+");
        assertEquals("2+", calculator.addSymbol("-"));

    }

    @Test
    public void calculate_TwoNumbersAdd() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("1");
        calculator.addSymbol("+");
        calculator.addSymbol("1");
        calculator.addSymbol("1");

        assertEquals("22", calculator.calculate());
    }

    @Test
    public void calculate_ThreeNumbersAdd() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("0");
        calculator.addSymbol("+");
        calculator.addSymbol("2");
        calculator.addSymbol("0");
        calculator.addSymbol("+");
        calculator.addSymbol("3");
        calculator.addSymbol("0");

        assertEquals("60", calculator.calculate());

    }

    @Test
    public void calculate_AddThenSubtract() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("2");
        calculator.addSymbol("+");
        calculator.addSymbol("2");
        calculator.addSymbol("-");
        calculator.addSymbol("1");

        assertEquals("3", calculator.calculate());
    }

    @Test
    public void calculate_LastCharacterCannotBeAnOperator() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("+");

        assertEquals("", calculator.calculate());
    }

    @Test
    public void calculate_CannotBeASingleNumber() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");

        assertEquals("", calculator.calculate());
    }

    @Test
    public void clear() {
        Calculator calculator = new Calculator();

        calculator.addSymbol("1");
        calculator.addSymbol("+");
        calculator.addSymbol("2");

        calculator.clear();

        assertEquals("", calculator.getSymbols());
    }

}