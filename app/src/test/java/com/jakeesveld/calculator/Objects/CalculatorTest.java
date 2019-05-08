package com.jakeesveld.calculator.Objects;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void addSymbolSingleCharacterFirstNumber() {
        assertThat(calculator.addSymbol("d"), equalTo("d"));
    }

    @Test
    public void addSymbolMultipleCharactersFirstNumber() {
        String returnedString;
        calculator.addSymbol("d");
        returnedString = calculator.addSymbol("d");
        assertThat(returnedString, equalTo("dd"));
    }

    @Test
    public void removeSymbolFirstNumber(){
        String returnedString;
        calculator.addSymbol("d");
        calculator.addSymbol("d");
        returnedString = calculator.removeLastSymbol();

        assertThat(returnedString, equalTo("d"));
    }

}