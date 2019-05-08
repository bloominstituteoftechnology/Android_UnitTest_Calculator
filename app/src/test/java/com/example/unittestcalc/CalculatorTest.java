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
		assertThat(calculator.opperand, equalTo(""));
	}
	
	@Test
	public void AddSymbol_inputOpperandWithNumOneValid_ReturnOpperand(){
		calculator.numOne = "5623";
		calculator.addSymbol("*");
		assertThat(calculator.opperand, equalTo("*"));
	}
	
	@Test
	public void SetFlags_emptyOpperand_ReturnTrue(){
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(true));
	}
	
	@Test
	public void SetFlags_setOpperand_Returnfalse(){
		calculator.opperand = "*";
		calculator.setFlags();
		assertThat(calculator.isFirstNum, equalTo(false));
	}
	
	@Test
	public void setOpperand_NumOneEmpty_ReturnEmptyString(){
		calculator.setOpperand("*");
		assertThat(calculator.opperand, equalTo(""));
	}
	
	@Test
	public void setOpperand_NumOneSet_ReturnOpperand(){
		calculator.numOne = "12541";
		calculator.setOpperand("*");
		assertThat(calculator.opperand, equalTo("*"));
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
		calculator.opperand = "*";
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo("3533"));
		assertThat(calculator.opperand, equalTo(""));
	}
	
	@Test
	public void deleteValue_NumOneSetOpperandSetNumTwoSet_ReturnNumSameValueAndSameOpperandAndNumTwoMinusLastValue(){
		calculator.numOne = "3533";
		calculator.opperand = "*";
		calculator.numTwo = "3523";
		calculator.deleteValue();
		assertThat(calculator.numOne, equalTo("3533"));
		assertThat(calculator.opperand, equalTo("*"));
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
		calculator.opperand = "*";
		calculator.setFlags();
		calculator.addNum("5");
		assertThat(calculator.numTwo, equalTo("5"));
	}
	
	@Test
	public void addNum_NumOneSetOpperandSetHasDec_NumTwoEqualsInput(){
		calculator.numOne = "3523";
		calculator.opperand = "*";
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
		assertThat(calculator.opperand, equalTo(""));
	}
	
	
	@Test
	public void addSymbol_InputMinusNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("-");
		assertThat(calculator.opperand, equalTo("-"));
	}
	
	
	@Test
	public void addSymbol_InputPlusNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("+");
		assertThat(calculator.opperand, equalTo("+"));
	}
	
	
	@Test
	public void addSymbol_InputDivideNumOneEmpty_OpperandBlankNumOneSet(){
		calculator.numOne = "5";
		calculator.addSymbol("/");
		assertThat(calculator.opperand, equalTo("/"));
	}
	
	@Test
	public void addSymbol_InputStarNumOneSet_OpperandSet(){
		calculator.numOne = "3252";
		calculator.addSymbol("*");
		assertThat(calculator.opperand, equalTo("*"));
	}
	
	@Test
	public void addSymbol_InputNumNumOneSetOpperandSet_NumTwoEqualsInput(){
		calculator.numOne = "3252";
		calculator.opperand = "*";
		calculator.addSymbol("4");
		assertThat(calculator.numTwo, equalTo("4"));
	}
	
	
}
