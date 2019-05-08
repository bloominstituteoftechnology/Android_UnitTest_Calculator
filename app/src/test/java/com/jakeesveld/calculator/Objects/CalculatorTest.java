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
        assertThat(calculator.addSymbol("1"), equalTo("1"));
    }

    @Test
    public void addSymbolMultipleCharactersFirstNumber() {
        String returnedString;
        calculator.addSymbol("1");
        returnedString = calculator.addSymbol("1");
        assertThat(returnedString, equalTo("11"));
    }

    @Test
    public void addIncorrectSymbol(){
        String returnedString;
        returnedString = calculator.addSymbol("d");
        assertThat(returnedString, equalTo(Calculator.INVALID));
    }

    @Test
    public void removeSymbolFirstNumber(){
        String returnedString;
        calculator.addSymbol("1");
        calculator.addSymbol("1");
        returnedString = calculator.removeLastSymbol();

        assertThat(returnedString, equalTo("1"));
    }

    @Test
    public void setOperand(){
        String returnedString;
        calculator.addSymbol("1");
        returnedString = calculator.setOperand(Calculator.ADD);

        assertThat(returnedString, equalTo(Calculator.ADD));
    }

    @Test
    public void setSymbolSingleCharacterSecondNumber(){
        String returnedString;
        calculator.addSymbol("1");
        calculator.setOperand(Calculator.ADD);
        returnedString = calculator.addSymbol("2");

        assertThat(returnedString, equalTo("2"));
    }

    @Test
    public void setSymbolMultipleCharactersSecondNumber(){
        String returnedString;
        calculator.addSymbol("1");
        calculator.setOperand(Calculator.ADD);
        calculator.addSymbol("2");
        returnedString = calculator.addSymbol("2");

        assertThat(returnedString, equalTo("22"));
    }

    @Test
    public void removeSymbolSecondNumber(){
        String returnedString;
        calculator.addSymbol("1");
        calculator.setOperand(Calculator.ADD);
        calculator.addSymbol("2");
        calculator.addSymbol("2");
        returnedString = calculator.removeLastSymbol();

        assertThat(returnedString, equalTo("2"));
    }

}