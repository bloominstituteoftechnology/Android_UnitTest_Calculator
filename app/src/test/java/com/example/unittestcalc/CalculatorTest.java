package com.example.unittestcalc;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	Calculator calculator;
	
	@Before
	public void createCalculator(){
		 calculator = new Calculator();
	}
	
	@Test
	public void hasDec_inputWithDec_ReturnTrue(){
		assertTrue(calculator.hasDec("325.32"));
	}
	
	@Test
	public void hasDec_inputWithoutDec_ReturnFalse(){
		assertFalse(calculator.hasDec("32532"));
	}
	
	@Test
	public void AddSymbol_inputOpperandWithNoNumOne_ReturnEmptyString(){
		calculator.addSymbol("*");
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void AddSymbol_inputOpperandWithNumOneValid_ReturnOpperand(){
		calculator.numOne = "5623";
		calculator.addSymbol("*");
		assertThat(calculator.operand, equalTo("*"));
	}
	
	@Test
	public void SetFlags_emptyOpperand_ReturnTrue(){
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(true));
	}
	
	@Test
	public void SetFlags_setOpperand_Returnfalse(){
		calculator.operand = "*";
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(false));
	}
	
	@Test
	public void setOpperand_NumOneEmpty_ReturnEmptyString(){
		calculator.setOperand("*");
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void setOpperand_NumOneSet_ReturnOpperand(){
		calculator.numOne = "12541";
		calculator.setOperand("*");
		assertThat(calculator.operand, equalTo("*"));
	}
	
	@Test
	public void deleteValue_NumOneSetOpperandEmpty_ReturnNumOneMinusLastValue(){
		calculator.numOne = "3533";
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo("353"));
	}
	
	
	@Test
	public void deleteValue_NumOneSetOpperandSetNumTwoBlank_ReturnNumSameValueAndOpperandBlank(){
		calculator.numOne = "3533";
		calculator.operand = "*";
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo("3533"));
		assertThat(calculator.operand, equalTo(""));
	}
	
	@Test
	public void deleteValue_NumOneSetOpperandSetNumTwoSet_ReturnNumSameValueAndSameOpperandAndNumTwoMinusLastValue(){
		calculator.numOne = "3533";
		calculator.operand = "*";
		calculator.numTwo = "3523";
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo("3533"));
		assertThat(calculator.operand, equalTo("*"));
		assertThat(calculator.numTwo, equalTo("352"));
	}
	
	@Test
	public void addNum_EmptyValues_NumOneEqualInput(){
		calculator.setFlags();
		calculator.addNum("5");
		assertThat(calculator.numOne, equalTo("5"));
	}
	
	@Test
	public void addNum_NumOneSet_NumOneAddsInput(){
		calculator.numOne = "3523";
		calculator.setFlags();
		calculator.addNum("5");
		assertThat(calculator.numOne, equalTo("35235"));
	}
	
	@Test
	public void addNum_NumOneSetOpperandSet_NumTwoEqualsInput(){
		calculator.numOne = "3523";
		calculator.operand = "*";
		calculator.setFlags();
		calculator.addNum("5");
		assertThat(calculator.numTwo, equalTo("5"));
	}
	
	@Test
	public void addNum_NumOneSetOpperandSetHasDec_NumTwoEqualsInput(){
		calculator.numOne = "3523";
		calculator.operand = "*";
		calculator.setFlags();
		calculator.addNum(".");
		calculator.addNum(".");
		assertThat(calculator.numTwo, equalTo("."));
	}
	
	@Test
	public void addNum_NumOneSetOpperandEmptyHasDec_NumTwoEqualsInput(){
		calculator.numOne = "3523";
		calculator.setFlags();
		calculator.addNum(".");
		calculator.addNum(".");
		calculator.addNum("5");
		calculator.addNum("8");
		assertThat(calculator.numOne, equalTo("3523.58"));
	}
	
	@Test
	public void addSymbol_InputStarNumOneEmpty_OpperandBlankNumOneBlank(){
		calculator.addSymbol("*");
		assertThat(calculator.numOne, equalTo(""));
		assertThat(calculator.operand, equalTo(""));
	}
	
	
	@Test
	public void addSymbol_InputMinusNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("-");
		assertThat(calculator.operand, equalTo("-"));
	}
	
	
	@Test
	public void addSymbol_InputPlusNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("+");
		assertThat(calculator.operand, equalTo("+"));
	}
	
	
	@Test
	public void addSymbol_InputDivideNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("/");
		assertThat(calculator.operand, equalTo("/"));
	}
	
	@Test
	public void addSymbol_InputStarNumOneSet_OpperandSet(){
		calculator.numOne = "3252";
		calculator.addSymbol("*");
		assertThat(calculator.operand, equalTo("*"));
	}
	
	@Test
	public void addSymbol_InputNumNumOneSetOpperandSet_NumTwoEqualsInput(){
		calculator.numOne = "3252";
		calculator.operand = "*";
		calculator.addSymbol("4");
		assertThat(calculator.numTwo, equalTo("4"));
	}
	
	@Test
	public void addSymbolMultiplyFunction_AllValuesSet_ResultEqualsNumOneTimesNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "*";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("13008.0"));
	}
	
	@Test
	public void addSymbolDivideFunction_AllValuesSet_ResultEqualsNumOneDividedByNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "/";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("813.0"));
	}
	
	@Test
	public void addSymbolSubtractFunction_AllValuesSet_ResultEqualsNumOneMinusNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "-";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("3248.0"));
	}
	
	@Test
	public void addSymbolAddFunction_AllValuesSet_ResultEqualsNumOnePlusNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "+";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("3256.0"));
	}
	
	@Test
	public void addSymbolMultiplyFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneTimesNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "*";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("52032.0"));
	}
	
	@Test
	public void addSymbolDivideFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneDividedByNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "/";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("203.25"));
	}
	
	@Test
	public void addSymbolSubtractFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOneMinusNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "-";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("3244.0"));
	}
	
	@Test
	public void addSymbolAddFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOnePlusNumTwo() {
		calculator.numOne = "3252";
		calculator.operand = "+";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		calculator.addSymbol("=");
		assertThat(calculator.numTwo, equalTo("4"));
		assertThat(calculator.result, equalTo("3260.0"));
	}
	
	@Test
	public void addSymbolSqrtFunction_AllValuesSetHasPressedEquals_ResultEqualsSqrtOfNum() {
		calculator.numOne = "3252";
		calculator.operand = "^^";
		calculator.addSymbol("=");
		calculator.addSymbol("=");
		assertThat(calculator.result, equalTo("7.5515"));
	}
	
	@Test
	public void addSymboleSqrtFunction_AllValuesSet_ResultEqualsSqrtOfNum() {
		calculator.numOne = "3252";
		calculator.operand = "^^";
		calculator.addSymbol("=");
		assertThat(calculator.result, equalTo("57.0263"));
	}
	
	@Test
	public void addSymbgolPowerOfFunction_AllValuesSetHasPressedEquals_ResultEqualsNumOnePowerOfNumTwo() {
		calculator.numOne = "2";
		calculator.operand = "^";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.result, equalTo("256.0"));
	}
	
	@Test
	public void addSymbgolPowerOfFunction_AllValuesSet_ResultEqualsNumOnePowerOfNumTwo() {
		calculator.numOne = "2";
		calculator.operand = "^";
		calculator.addSymbol("4");
		calculator.addSymbol("=");
		assertThat(calculator.result, equalTo("256.0"));
	}
	
}
