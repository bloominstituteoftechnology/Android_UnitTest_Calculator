package com.vivekvishwanath.android_unittest_calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void calculatorTest_AddSingleCharacter_WhenNothingElseAdded() {
        calculator.clear();
        String singleCharacter = "1";
        assertEquals(singleCharacter, calculator.addSymbol(singleCharacter));
    }

    @Test
    public void calculatorTest_AddSingleCharacter_WhenOtherCharacterAdded() {
        calculator.clear();
        String previousCharacter = "1";
        String newCharacter = "2";
        String combinedCharacters = previousCharacter + newCharacter;
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

    @Test
    public void calculatorTest_AddDecimal_WithoutPreviousDecimalAdded() {
        calculator.clear();
        String previousCharacter = "1";
        String newCharacter = ".";
        String combinedCharacters = previousCharacter + newCharacter;
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

    @Test
    public void calculatorTest_AddDecimal_WithPreviousDecimalAdded() {
        calculator.clear();
        String previousCharacter = "1.1";
        String newCharacter = ".";
        String combinedCharacters = "11.";
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

    @Test
    public void calculatorTest_AddTwoNumbers_WithoutPreviousOperations() {
        calculator.clear();
        String entry = "1+2";
        String sum = "3.0";
        calculator.addSymbol(entry);
        assertEquals(sum, calculator.add());
    }

    @Test
    public void calculatorTest_SubtractTwoNumbers_WithoutPreviousOperations() {
        calculator.clear();
        String entry = "2-1";
        String difference = "1.0";
        calculator.addSymbol(entry);
        assertEquals(difference, calculator.subtract());
    }

    @Test
    public void calculatorTest_MultiplyTwoNumbers_WithoutPreviousOperations() {
        String entry = "1*2";
        String product = "2.0";
        calculator.addSymbol(entry);
        assertEquals(product, calculator.multiply());
    }

    @Test
    public void calculatorTest_DivideTwoNumbers_WithoutPreviousOperations() {
        String entry = "10/2";
        String quotient = "5.0";
        calculator.addSymbol(entry);
        assertEquals(quotient, calculator.divide());
    }


}