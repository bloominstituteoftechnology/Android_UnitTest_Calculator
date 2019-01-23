package com.joshuahalvorson.android_unittest_calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shouldAddSingleCharacterWhenNothingElseAdded(){
        //setup
        String expected = "1";

        //execution
        calculator.addSymbol(expected);

        //check
        assertEquals(expected, calculator.addSymbol(expected));
    }

    @Test
    public void shouldAddSingleCharacterWhenOthersAdded(){
        //setup
        String string1 = "11" ;
        String string2 = "2" ;

        //execution
        String expected = calculator.addSymbol(string1 + string2);

        //check
        assertEquals(expected, calculator.addSymbol(string1 + string2));
    }

}