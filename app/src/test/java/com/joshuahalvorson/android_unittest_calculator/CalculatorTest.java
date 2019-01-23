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
        assertEquals(expected, calculator.getEnteredString());
    }

    @Test
    public void shouldAddSingleCharacterWhenOthersAdded(){
        //setup
        String string1 = "11" ;
        String string2 = "2" ;

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);

        //check
        assertEquals("112", calculator.getEnteredString());
    }

    @Test
    public void shouldAddDecimalToEnteredString(){
        //setup
        String string1 = ".";
        String string2 = "5";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);


        //check
        assertEquals(".5", calculator.getEnteredString());
    }

    @Test
    public void shouldNotAddDecimalToStringWithDecimalInIt(){
        //setup
        String string1 = ".";
        String string2 = "5";
        String string3 = ".";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);


        //check
        assertEquals(".5", calculator.getEnteredString());
    }

    @Test
    public void shouldRemoveLastAddedCharacter(){
        //setup
        String string1 = "1";
        String string2 = "+";
        String string3 = "1";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.removeLastAddedCharacter();

        //check
        assertEquals("1+", calculator.getEnteredString());
    }

    @Test
    public void shouldNotRemoveCharacterWhenStringIsEmpty(){
        //setup
        String string1 = "1";
        String string2 = "+";
        String string3 = "1";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.removeLastAddedCharacter();
        calculator.removeLastAddedCharacter();
        calculator.removeLastAddedCharacter();
        calculator.removeLastAddedCharacter();

        //check
        assertEquals("", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformAddition(){
        //setup
        String string1 = "103";
        String string2 = "+";
        String string3 = "13";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performAddition();

        //check
        assertEquals("116.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformMultipleAdditions(){
        //setup
        String string1 = "103";
        String string2 = "+";
        String string3 = "13";
        String string4 = "+";
        String string5 = "17";
        String string6 = "+";
        String string7 = "18";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.addSymbol(string4);
        calculator.addSymbol(string5);
        calculator.addSymbol(string6);
        calculator.addSymbol(string7);
        calculator.performAddition();

        //check
        assertEquals("151.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformSubtraction(){
        //setup
        String string1 = "113";
        String string2 = "-";
        String string3 = "13";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performSubtraction();

        //check
        assertEquals("100.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformMultipleSubtractions(){
        //setup
        String string1 = "113";
        String string2 = "-";
        String string3 = "13";
        String string4 = "-";
        String string5 = "11";
        String string6 = "-";
        String string7 = "15";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.addSymbol(string4);
        calculator.addSymbol(string5);
        calculator.addSymbol(string6);
        calculator.addSymbol(string7);
        calculator.performSubtraction();

        //check
        assertEquals("74.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformMultiplication(){
        //setup
        String string1 = "10";
        String string2 = "*";
        String string3 = "13";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performMultiplication();

        //check
        assertEquals("130.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformMultipleMultiplications(){
        //setup
        String string1 = "10";
        String string2 = "*";
        String string3 = "13";
        String string4 = "*";
        String string5 = "11";
        String string6 = "*";
        String string7 = "16";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.addSymbol(string4);
        calculator.addSymbol(string5);
        calculator.addSymbol(string6);
        calculator.addSymbol(string7);
        calculator.performMultiplication();

        //check
        assertEquals("22880.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformDivision(){
        //setup
        String string1 = "100";
        String string2 = "/";
        String string3 = "2";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performDivision();

        //check
        assertEquals("50.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformMultipleDivisions(){
        //setup
        String string1 = "10000";
        String string2 = "/";
        String string3 = "2";
        String string4 = "/";
        String string5 = "2";
        String string6 = "/";
        String string7 = "2";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.addSymbol(string4);
        calculator.addSymbol(string5);
        calculator.addSymbol(string6);
        calculator.addSymbol(string7);
        calculator.performDivision();

        //check
        assertEquals("1250.0", calculator.getEnteredString());
    }

    @Test
    public void shouldPerformRepeatedCalculations(){
        //setup
        String string1 = "5";
        String string2 = "*";
        String string3 = "10";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performMultiplication();
        calculator.repeatLastCalculation();

        //check
        assertEquals("500.0", calculator.getEnteredString());
    }

    @Test
    public void shouldClearAllValues(){
        //setup
        String string1 = "100";
        String string2 = "/";
        String string3 = "2";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.addSymbol(string3);
        calculator.performDivision();
        calculator.clearValues();

        //check
        assertEquals("", calculator.getEnteredString());
    }

    @Test
    public void shouldReturnSquareRoot(){
        //setup
        String string1 = "144";
        String string2 = "sqrt";

        //execution
        calculator.addSymbol(string1);
        calculator.addSymbol(string2);
        calculator.findSquareRoot();

        //check
        assertEquals("12.0", calculator.getEnteredString());
    }
}