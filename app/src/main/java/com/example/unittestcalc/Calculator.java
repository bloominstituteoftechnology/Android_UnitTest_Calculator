package com.example.unittestcalc;

public class Calculator {
	public boolean isFirstNum;
	public String numOne;
	public String numTwo;
	public String opperand;
	
	public Calculator() {
		isFirstNum = true;
		numOne = "";
		numTwo = "";
		opperand = "";
	}
	
	public void addSymbol(String input) {
		setFlags();
		switch (input) {
			case "-":
				setOpperand(input);
				break;
			case "+":
				setOpperand(input);
				break;
			case "/":
				setOpperand(input);
				break;
			case "*":
				setOpperand(input);
				break;
			case "del":
				deleteValue();
				break;
			default:
				addNum(input);
		}
	}
	
	public void deleteValue(){
		setFlags();
		if(isFirstNum && !numOne.equals("")){
			numOne = numOne.substring(0,numOne.length()-1);
			return;
		}
		
		if(!isFirstNum && numTwo.equals("")){
			opperand = "";
			return;
		}
		
		if(!isFirstNum && !numTwo.equals("")){
			numTwo = numTwo.substring(0,numTwo.length()-1);
			return;
		}
	}
	
	public void setOpperand(String input){
		if(!numOne.equals("") && numTwo.equals("")) {
			opperand = input;
		}
	}
	
	public void setFlags(){
		if(opperand.equals("")){
			isFirstNum = true;
		}else isFirstNum = false;
		
	}
	
	public void addNum(String input) {
		if (isFirstNum) {
			if (input.equals(".")) {
				if (!hasDec(numOne)) {
					numOne += input;
				}
			} else {
				numOne += input;
			}
		} else {
			if (input.equals(".")) {
				if (!hasDec(numTwo)) {
					numTwo += input;
				}
			} else {
				numTwo += input;
			}
		}
	}
	
	public Boolean hasDec(String input) {
		if (input.contains(".")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String getDisplayText() {
		return numOne + "   " + opperand + "   " + numTwo;
	}
}
