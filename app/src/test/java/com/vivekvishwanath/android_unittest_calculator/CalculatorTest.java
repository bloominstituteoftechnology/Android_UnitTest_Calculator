package com.vivekvishwanath.android_unittest_calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void calculatorTest_AddSingleCharacter_WhenNothingElseAdded() {
        String singleCharacter = "1";
        assertEquals(singleCharacter, calculator.addAymbol(singleCharacter));
    }

    @Test
    public void calculatorTest_AddSingleCharacter_WhenOtherCharacterAdded() {
        String previousCharacter = "1";
        String newCharacter = "2";
        String combinedCharacters = previousCharacter + newCharacter;
        calculator.addAymbol(previousCharacter);
        assertEquals(combinedCharacters, calculator.addAymbol(newCharacter));
    }

}
