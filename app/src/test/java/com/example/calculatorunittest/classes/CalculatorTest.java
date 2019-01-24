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

        String result = "1";
        calculator.addSymbol(result);
        assertEquals(result, calculator.getCalculations());

    }

    @Test
    public void shouldAddCharacter() {
        String result = "125";
        calculator.addSymbol("12");
        calculator.addSymbol("5");
        assertEquals(result, calculator.getCalculations());

    }

    @Test
    public void shouldAddOneDecimal() {
        String result = "123.";
        String test = "123";
        String test1 = ".";

        calculator.addSymbol(test);
        calculator.addSymbol(test1);

        assertEquals(result, calculator.getCalculations());

    }

    @Test
    public void shouldNotAddDecimal() {
        String result = "1.2";
        String test = "1.2";

        calculator.addSymbol(test);
        calculator.addDecimal();

        assertEquals(result, calculator.getCalculations());

    }

    @Test
    public void shouldRemoveLastCharacter(){
        String result = "125";
        String test = "1257";

        calculator.addSymbol(test);
        calculator.removeLastCharacter();

        assertEquals(result, calculator.getCalculations());
    }

    @Test
    public void shouldNotRemoveLastCharacter(){
        String result = "";
        String test = "1";
        String test1 = "2";
        String test2 = "3";

        calculator.addSymbol(test);
        calculator.addSymbol(test1);
        calculator.addSymbol(test2);
        calculator.removeLastCharacter();
        calculator.removeLastCharacter();
        calculator.removeLastCharacter();
        calculator.removeLastCharacter();

        assertEquals(result, calculator.getCalculations());
    }

    @Test
    public void shouldAddTwoNumbers(){
        String result = "7.0";

        String test = "3";
        String test2 = "+";
        String test1 = "4";

        calculator.addSymbol(test);
        calculator.addSymbol(test2);
        calculator.addSymbol(test1);
        calculator.add();

        assertEquals(result, calculator.getCalculations());
    }
}