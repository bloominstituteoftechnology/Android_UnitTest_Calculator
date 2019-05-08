package com.jakeesveld.calculator.Objects;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void addSymbolSingleCharacter() {
        assertThat(Calculator.addSymbol("d"), equalTo("d"));
    }

    @Test
    public void addSymbolMultipleCharacters() {
        String returnedString = Calculator.addSymbol("d");
        returnedString = Calculator.addSymbol("d");
        assertThat(returnedString, equalTo("dd"));
    }

}