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
        calculator.addSymbol(result);
        assertEquals(result, calculator.addSymbol(null));

    }

    @Test
    public void shouldAddWord() {
        String result = "a";
        calculator.addSymbol(result);
        assertEquals(result, calculator.addSymbol("happy"));

    }

    @Test
    public void shouldAddOneDecimal() {
        String result = "123.";
        String test = "123";

        calculator.getCalculations(test);
        calculator.addDecimal();

        assertEquals(result, calculator.addDecimal());

    }

    @Test
    public void shouldNotAddDecimal() {
        String result = "1.23";
        String test = "1.2.";

        calculator.getCalculations(test);
        calculator.addDecimal();

        assertEquals(result, calculator.addDecimal());

    }

    @Test
    public void shouldRemoveLastCharacter(){
        String result = "125";
        String test = "1257";

        calculator.getCalculations(test);

        assertEquals(result, calculator.removeLastCharacter());
    }
}