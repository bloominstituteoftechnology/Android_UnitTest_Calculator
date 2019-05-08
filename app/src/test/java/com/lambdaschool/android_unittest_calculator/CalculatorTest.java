package com.lambdaschool.android_unittest_calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void initialize() {
        calculator = new Calculator();
    }

    @Test
    public void addSymbol_OneCharacter_ReturnsTrue() {
        assertEquals("1", calculator.addSymbol("1"));
    }

    @Test
    public void addSymbol_MultipleCharacters_ReturnsFalse() {
        assertEquals("1", calculator.addSymbol("123"));
    }
}