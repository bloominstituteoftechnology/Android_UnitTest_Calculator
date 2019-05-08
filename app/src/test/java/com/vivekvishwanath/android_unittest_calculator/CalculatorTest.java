package com.vivekvishwanath.android_unittest_calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void calculatorTest_AddSingleCharacter_WhenNothingElseAdded() {
        String singleCharacter = "1";
        assertEquals(singleCharacter, calculator.addSymbol(singleCharacter));
    }

    @Test
    public void calculatorTest_AddSingleCharacter_WhenOtherCharacterAdded() {
        String previousCharacter = "1";
        String newCharacter = "2";
        String combinedCharacters = previousCharacter + newCharacter;
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

    @Test
    public void calculatorTest_AddDecimal_WithoutPreviousDecimalAdded() {
        String previousCharacter = "1";
        String newCharacter = ".";
        String combinedCharacters = previousCharacter + newCharacter;
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

    @Test
    public void calculatorTest_AddDecimal_WithPreviousDecimalAdded() {
        String previousCharacter = "1.1";
        String newCharacter = ".";
        String combinedCharacters = "11.";
        calculator.addSymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addSymbol(newCharacter));
    }

}
