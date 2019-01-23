package com.example.calculatorunittest.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
         calculator = new Calculator();
    }

    @Test
    public void shouldAddSymbol() {
        String result = "a";
        calculator.addSymbol("");
        assertEquals("a", calculator.addSymbol(null));

    }
}