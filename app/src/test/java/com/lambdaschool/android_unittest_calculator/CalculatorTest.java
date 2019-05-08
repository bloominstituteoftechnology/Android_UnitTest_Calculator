package com.lambdaschool.android_unittest_calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void addSymbol_OneCharacter_ReturnsTrue() {
        assertEquals("1", "1");
    }

    @Test
    public void addSymbol_MultipleCharacters_ReturnsFalse() {
        assertEquals("1", "123");
    }
}