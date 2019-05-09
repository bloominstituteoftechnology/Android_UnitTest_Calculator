package com.lambdaschool.android_unittest_calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void initialize() {
        calculator = new Calculator();
    }

    @Test
    public void addSymbol_One() {
        calculator.setExpression("");
        String testSymbolToAdd = "1";
        assertEquals(testSymbolToAdd, calculator.addSymbol(testSymbolToAdd));
    }

    @Test
    public void addSymbol_Multiple() {
        calculator.setExpression("123");
        String testSymbolToAdd = "4";
        assertEquals(calculator.getExpression() + testSymbolToAdd, calculator.addSymbol(testSymbolToAdd));
    }

    @Test
    public void addDecimal_One() {
        calculator.setExpression("");
        assertEquals(".", calculator.addDecimal());
    }

    @Test
    public void addDecimal_Multiple() {
        calculator.setExpression("123.4");
        assertEquals(calculator.getExpression(), calculator.addDecimal());
    }

    @Test
    public void backspace_None() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.backspace());
    }

    @Test
    public void backspace_One() {
        calculator.setExpression("1");
        assertEquals("", calculator.backspace());
    }

    @Test
    public void backspace_Multiple() {
        calculator.setExpression("123.4");
        assertEquals(calculator.getExpression().substring(0, calculator.getExpression().length() - 1), calculator.backspace());
    }

    @Test
    public void addition_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.addition());
    }

    @Test
    public void addition_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "+", calculator.addition());
    }

    @Test
    public void addition_Multiple() {
        calculator.setExpression("123+");
        assertEquals(calculator.getExpression(), calculator.addition());
    }

    @Test
    public void subtraction_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.subtraction());
    }

    @Test
    public void subtraction_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "-", calculator.subtraction());
    }

    @Test
    public void subtraction_Multiple() {
        calculator.setExpression("123-");
        assertEquals(calculator.getExpression(), calculator.subtraction());
    }

    @Test
    public void multiplication_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.multiplication());
    }

    @Test
    public void multiplication_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "x", calculator.multiplication());
    }

    @Test
    public void multiplication_Multiple() {
        calculator.setExpression("123x");
        assertEquals(calculator.getExpression(), calculator.multiplication());
    }

    @Test
    public void division_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.division());
    }

    @Test
    public void division_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "÷", calculator.division());
    }

    @Test
    public void division_Multiple() {
        calculator.setExpression("123÷");
        assertEquals(calculator.getExpression(), calculator.division());
    }

    @Test
    public void square_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.square());
    }

    @Test
    public void square_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "²", calculator.square());
    }

    @Test
    public void square_Multiple() {
        calculator.setExpression("123²");
        assertEquals(calculator.getExpression(), calculator.square());
    }

    @Test
    public void squareRoot_First() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.squareRoot());
    }

    @Test
    public void squareRoot_One() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression() + "√", calculator.squareRoot());
    }

    @Test
    public void squareRoot_Multiple() {
        calculator.setExpression("123√");
        assertEquals(calculator.getExpression(), calculator.squareRoot());
    }

    @Test
    public void pi_One() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression() + "π", calculator.pi());
    }

    @Test
    public void pi_Multiple() {
        calculator.setExpression("π");
        assertEquals(calculator.getExpression(), calculator.pi());
    }

    @Test
    public void calculate_Blank() {
        calculator.setExpression("");
        assertEquals(calculator.getExpression(), calculator.calculate());
    }

    @Test
    public void calculate_OneOperand() {
        calculator.setExpression("123");
        assertEquals(calculator.getExpression(), calculator.calculate());
    }

    @Test
    public void calculate_Addition_Integer() {
        //calculator.setExpression("123+123");
        calculator.setExpression("123+123");
        assertEquals("246", calculator.calculate());
    }
    @Test
    public void calculate_Addition_Decimal() {
        //calculator.setExpression("123+123");
        calculator.setExpression("123.5+123.5");
        assertEquals("247", calculator.calculate());
    }

    @Test
    public void calculate_Subtraction_Integer() {
        calculator.setExpression("123-123");
        assertEquals("0", calculator.calculate());
    }

    @Test
    public void calculate_Subtraction_Decimal() {
        calculator.setExpression("123.5-123.5");
        assertEquals("0", calculator.calculate());
    }

    @Test
    public void calculate_Multiplication_Integer() {
        calculator.setExpression("123x123");
        assertEquals("15129", calculator.calculate());
    }

    @Test
    public void calculate_Multiplication_Decimal() {
        calculator.setExpression("123.5x123.5");
        assertEquals("15252.25", calculator.calculate());
    }

    @Test
    public void calculate_Division_Integer() {
        calculator.setExpression("123÷123");
        assertEquals("1", calculator.calculate());
    }

    @Test
    public void calculate_Division_Decimal() {
        calculator.setExpression("123.5÷123.5");
        assertEquals("1", calculator.calculate());
    }

    @Test
    public void reset() {
        assertThat(calculator.reset(), equalTo(""));
    }
}