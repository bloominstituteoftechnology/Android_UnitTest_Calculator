package com.example.unittestcalc;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	Calculator calculator;
	public static String NUM_LARGE = "3342";
	public static String NUM_MED = "500";
	public static String NUM_SMALL = "30";
	public static String NUM_SINGLE_DIGIT = "2";
	public static String NUM_LARGE_DEC = "3342.2";
	public static String NUM_MED_DEC = "500.2";
	public static String NUM_SMALL_DEC = "30.2";
	public static String NUM_XSMALL_DEC = "2.2";
	public static String OPERAND_TIMES = "*";
	public static String OPERAND_SQRT = "√";
	public static String OPERAND_PLUS = "+";
	public static String OPERAND_MINUS = "-";
	public static String OPERAND_POWER = "^";
	public static String OPERAND_DIVIDE = "/";
	public static String OPERAND_EQUALS = "=";
	public static String DOT = ".";
	
	public double StrToDoub(String input) {
		return Double.parseDouble(input);
	}
	
	@Before
	public void createCalculator() {
		calculator = new Calculator();
	}
	
	@Test
	public void hasDec_inputWithDec_ReturnTrue() {
		assertTrue(calculator.hasDec(NUM_LARGE_DEC));
	}
	
	@Test
	public void hasDec_inputWithoutDec_ReturnFalse() {
		assertFalse(calculator.hasDec(NUM_LARGE));
	}
	
	@Test
	public void AddSymbol_inputOpperandWithNoNumOne_ReturnEmptyString() {
		calculator.addSymbol(OPERAND_TIMES);
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void AddSymbol_inputOpperandWithNumOneValid_ReturnOpperand() {
		calculator.numOne = NUM_LARGE;
		calculator.addSymbol(OPERAND_TIMES);
		assertThat(calculator.operand, equalTo(OPERAND_TIMES));
	}
	
	@Test
	public void SetFlags_emptyOpperand_ReturnTrue() {
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(true));
	}
	
	@Test
	public void SetFlags_setOpperand_Returnfalse() {
		calculator.operand = OPERAND_TIMES;
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(false));
	}
	
	@Test
	public void setOpperand_NumOneEmpty_ReturnEmptyString() {
		calculator.setOperand(OPERAND_TIMES);
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void setOpperand_NumOneSet_ReturnOpperand() {
		calculator.numOne = NUM_LARGE;
		calculator.setOperand(OPERAND_TIMES);
		assertThat(calculator.operand, equalTo(OPERAND_TIMES));
	}
	
	@Test
	public void deleteValue_NumOneSetOpperandEmpty_ReturnNumOneMinusLastValue() {
		calculator.numOne = NUM_LARGE;
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo(NUM_LARGE.substring(0, NUM_LARGE.length() - 1)));
	}
	
	
	@Test
	public void deleteValue_NumOneSetOpperandSetNumTwoBlank_ReturnNumSameValueAndOpperandBlank() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo(NUM_LARGE));
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void deleteValue_NumOneSetOpperandSetNumTwoSet_ReturnNumSameValueAndSameOpperandAndNumTwoMinusLastValue() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.numTwo = NUM_LARGE;
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo(NUM_LARGE));
		assertThat(calculator.operand, equalTo(OPERAND_TIMES));
		assertThat(calculator.numTwo, equalTo(NUM_LARGE.substring(0, NUM_LARGE.length() - 1)));
	}
	
	@Test
	public void addNum_EmptyValues_NumOneEqualInput() {
		calculator.setFlags();
		calculator.addNum(NUM_SINGLE_DIGIT);
		assertThat(calculator.numOne, equalTo(NUM_SINGLE_DIGIT));
	}
	
	@Test
	public void addNum_NumOneSet_NumOneAddsInput() {
		calculator.numOne = NUM_LARGE;
		calculator.setFlags();
		calculator.addNum(NUM_SINGLE_DIGIT);
		assertThat(calculator.numOne, equalTo(NUM_LARGE + NUM_SINGLE_DIGIT));
	}
	
	@Test
	public void addNum_NumOneSetOpperandSet_NumTwoEqualsInput() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.setFlags();
		calculator.addNum(NUM_SINGLE_DIGIT);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
	}
	
	@Test
	public void addNum_NumOneSetOpperandSetHasDec_NumTwoEqualsInput() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.setFlags();
		calculator.addNum(DOT);
		calculator.addNum(DOT);
		assertThat(calculator.numTwo, equalTo(DOT));
	}
	
	@Test
	public void addNum_NumOneSetOpperandEmptyHasDec_NumTwoEqualsInput() {
		calculator.numOne = NUM_LARGE;
		calculator.setFlags();
		calculator.addNum(DOT);
		calculator.addNum(DOT);
		calculator.addNum(NUM_SINGLE_DIGIT);
		calculator.addNum(NUM_SINGLE_DIGIT);
		assertThat(calculator.numOne, equalTo(NUM_LARGE + DOT + NUM_SINGLE_DIGIT + NUM_SINGLE_DIGIT));
	}
	
	@Test
	public void addSymbol_InputStarNumOneEmpty_OpperandBlankNumOneBlank() {
		calculator.addSymbol(OPERAND_TIMES);
		assertThat(calculator.numOne, equalTo(""));
		assertThat(calculator.operand, equalTo(""));
	}
	
	
	@Test
	public void addSymbol_InputMinusNumOneEmpty_OpperandBlankNumOneSet() {
		calculator.numOne = NUM_SINGLE_DIGIT;
		calculator.addSymbol(OPERAND_MINUS);
		assertThat(calculator.operand, equalTo(OPERAND_MINUS));
	}
	
	
	@Test
	public void addSymbol_InputPlusNumOneEmpty_OpperandBlankNumOneSet() {
		calculator.numOne = NUM_SINGLE_DIGIT;
		calculator.addSymbol(OPERAND_PLUS);
		assertThat(calculator.operand, equalTo(OPERAND_PLUS));
	}
	
	
	@Test
	public void addSymbol_InputDivideNumOneEmpty_OpperandBlankNumOneSet() {
		calculator.numOne = NUM_SINGLE_DIGIT;
		calculator.addSymbol(OPERAND_DIVIDE);
		assertThat(calculator.operand, equalTo(OPERAND_DIVIDE));
	}
	
	@Test
	public void addSymbol_InputStarNumOneSet_OpperandSet() {
		calculator.numOne = NUM_LARGE;
		calculator.addSymbol(OPERAND_TIMES);
		assertThat(calculator.operand, equalTo(OPERAND_TIMES));
	}
	
	@Test
	public void addSymbol_InputNumNumOneSetOpperandSet_NumTwoEqualsInput() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
	}
	
	@Test
	public void addSymbolMultiplyFunction_AllValuesSet_ResultEqualsNumOneTimesNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) * StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	
	@Test
	public void addSymbolDivideFunction_AllValuesSet_ResultEqualsNumOneDividedByNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_DIVIDE;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) / StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolSubtractFunction_AllValuesSet_ResultEqualsNumOneMinusNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_MINUS;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) - StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolAddFunction_AllValuesSet_ResultEqualsNumOnePlusNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_PLUS;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) + StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolMultiplyFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneTimesNumTwoTimesNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_TIMES;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) * StrToDoub(NUM_SINGLE_DIGIT) * StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolDivideFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneDividedByNumTwoDividedByNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_DIVIDE;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) / StrToDoub(NUM_SINGLE_DIGIT) / StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolSubtractFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneMinusNumTwoMinusNumOne() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_MINUS;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) - StrToDoub(NUM_SINGLE_DIGIT) - StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolAddFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOnePlusNumTwoPlusNumTwo() {
		calculator.numOne = NUM_LARGE;
		calculator.operand = OPERAND_PLUS;
		calculator.addSymbol(NUM_SINGLE_DIGIT);
		calculator.addSymbol(OPERAND_EQUALS);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.numTwo, equalTo(NUM_SINGLE_DIGIT));
		assertThat(calculator.result, equalTo(String.valueOf(StrToDoub(NUM_LARGE) + StrToDoub(NUM_SINGLE_DIGIT) + StrToDoub(NUM_SINGLE_DIGIT))));
	}
	
	@Test
	public void addSymbolSqrtFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneQuadRt() {
		calculator.numOne = "3232";
		calculator.operand = OPERAND_SQRT;
		calculator.addSymbol(OPERAND_EQUALS);
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.result, equalTo("7.5399"));
	}
	
	@Test
	public void addSymbolSqrtFunction_AllValuesSet_ResultEqualsSqrtOfNum() {
		calculator.numOne = "3232";
		calculator.operand = OPERAND_SQRT;
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.result, equalTo("56.8506"));
	}
	
	@Test
	public void addSymbolPowerOfFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOnePowerOfNumTwo() {
		calculator.numOne = "2";
		calculator.operand = OPERAND_POWER;
		calculator.addSymbol("4");
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.result, equalTo("256.0"));
	}
	
	@Test
	public void addSymbolPowerOfFunction_AllValuesSet_ResultEqualsNumOnePowerOfNumTwo() {
		calculator.numOne = "2";
		calculator.operand = OPERAND_POWER;
		calculator.addSymbol("4");
		calculator.addSymbol(OPERAND_EQUALS);
		assertThat(calculator.result, equalTo("256.0"));
	}
	
}
