package com.example.unittestcalc;

public class Calculator {
	public boolean isFirstNum;
	public boolean hasPressedEquals;
	public String numOne;
	public String numTwo;
	public String opperand;
	public String result;
	
	public Calculator() {
		isFirstNum = true;
		hasPressedEquals = false;
		numOne = "";
		numTwo = "";
		opperand = "";
	}
	
	public void addSymbol(String input) {
		setFlags();
		switch (input) {
			case "=":
				performOperation();
				hasPressedEquals = true;
				break;
			case "-":
				hasPressedEquals = false;
				setOpperand(input);
				break;
			case "+":
				hasPressedEquals = false;
				setOpperand(input);
				break;
			case "/":
				hasPressedEquals = false;
				setOpperand(input);
				break;
			case "*":
				hasPressedEquals = false;
				setOpperand(input);
				break;
			case "del":
				hasPressedEquals = false;
				deleteValue();
				break;
			default:
				hasPressedEquals = false;
				addNum(input);
		}
	}
	
	public void deleteValue() {
		setFlags();
		if (isFirstNum && !numOne.equals("")) {
			numOne = numOne.substring(0, numOne.length() - 1);
			return;
		}
		
		if (!isFirstNum && numTwo.equals("")) {
			opperand = "";
			return;
		}
		
		if (!isFirstNum && !numTwo.equals("")) {
			numTwo = numTwo.substring(0, numTwo.length() - 1);
			return;
		}
	}
	
	public void setOpperand(String input) {
		if (!numOne.equals("") && numTwo.equals("")) {
			opperand = input;
		}
	}
	
	public void setFlags() {
		if (opperand.equals("")) {
			isFirstNum = true;
		} else {
			isFirstNum = false;
		}
		
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
	
	public void performOperation() {
		String passedNumOne;
		if(hasPressedEquals){
			passedNumOne = result;
		} else { passedNumOne = numOne;}
		if (!numOne.equals("") &&
				!opperand.equals("") &&
				!numTwo.equals("")) {
			switch (opperand) {
				case "-":
					result = subtract(passedNumOne,numTwo);
					break;
				case "+":
					result = add(passedNumOne,numTwo);
					break;
				case "/":
					result = divide(passedNumOne,numTwo);
					break;
				case "*":
					result = multiply(passedNumOne,numTwo);
					break;
			}
			
		}
	}
	
	public String multiply(String numOne, String numTwo){
		return String.valueOf(strToDoub(numOne) * strToDoub(numTwo));
	}
	
	public String add(String numOne, String numTwo){
		return String.valueOf(strToDoub(numOne) + strToDoub(numTwo));
	}
	
	public String subtract(String numOne, String numTwo){
		return String.valueOf(strToDoub(numOne) - strToDoub(numTwo));
	}
	public String divide(String numOne, String numTwo){
		return String.valueOf(strToDoub(numOne) / strToDoub(numTwo));
	}
	
	public double strToDoub(String input){
		return Double.parseDouble(input);
	}
	
	public void setResult(String result){
		this.result = result;
	}
	
	public String getResult(){
		return result;
	}
	
	public String getDisplayText() {
		return numOne + "   " + opperand + "   " + numTwo;
	}
}
