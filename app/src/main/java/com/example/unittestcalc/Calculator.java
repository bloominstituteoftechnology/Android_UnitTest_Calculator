package com.example.unittestcalc;

public class Calculator {
	public boolean isFirstNum;
	public boolean hasPressedEquals;
	public String numOne;
	public String numTwo;
	public String operand;
	public String result;
	
	public Calculator() {
		isFirstNum = true;
		hasPressedEquals = false;
		numOne = "";
		numTwo = "";
		operand = "";
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
				setOperand(input);
				break;
			case "^":
				hasPressedEquals = false;
				setOperand(input);
				break;
			case "^^":
				hasPressedEquals = false;
				setOperand(input);
				break;
			case "+":
				hasPressedEquals = false;
				setOperand(input);
				break;
			case "/":
				hasPressedEquals = false;
				setOperand(input);
				break;
			case "*":
				hasPressedEquals = false;
				setOperand(input);
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
			operand = "";
			return;
		}
		
		if (!isFirstNum && !numTwo.equals("")) {
			numTwo = numTwo.substring(0, numTwo.length() - 1);
			return;
		}
	}
	
	public void setOperand(String input) {
		if (!numOne.equals("") && numTwo.equals("")) {
			operand = input;
		}
	}
	
	public void setFlags() {
		if (operand.equals("")) {
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
		if (hasPressedEquals) {
			passedNumOne = result;
		} else {
			passedNumOne = numOne;
		}
		if (!numOne.equals("") &&
				!operand.equals("")) {
			
			if (numTwo.equals("") && operand.equals("^^")) {
				setResult(sqrt(passedNumOne));
			}
		 else if (!numTwo.equals("")) {
			switch (operand) {
				case "-":
					setResult(subtract(passedNumOne, numTwo));
					break;
				case "+":
					setResult(add(passedNumOne, numTwo));
					break;
				case "/":
					setResult(divide(passedNumOne, numTwo));
					break;
				case "*":
					setResult(multiply(passedNumOne, numTwo));
					break;
				case "^":
					powerOf(strToDoub(passedNumOne), strToDoub(numTwo), 0);
					break;
			}}
		}
	}
	
	
	public String multiply(String numOne, String numTwo) {
		return String.valueOf(strToDoub(numOne) * strToDoub(numTwo));
	}
	
	public String add(String numOne, String numTwo) {
		return String.valueOf(strToDoub(numOne) + strToDoub(numTwo));
	}
	
	public String subtract(String numOne, String numTwo) {
		return String.valueOf(strToDoub(numOne) - strToDoub(numTwo));
	}
	
	public String divide(String numOne, String numTwo) {
		return String.valueOf(strToDoub(numOne) / strToDoub(numTwo));
	}
	
	public String sqrt(String num) {
		return String.valueOf(Math.sqrt(strToDoub(num)));
	}
	
	public void powerOf(double numOne, double numTwo, double runningTotal) {
		if (runningTotal == 0 && numTwo > 0) {
			runningTotal = numOne * numOne;
			numTwo--;
		}
		
		if (numTwo > 0) {
			runningTotal *= numOne;
			powerOf(numOne, numTwo - 1, runningTotal * numOne);
		} else {
			setResult(String.valueOf(runningTotal));
		}
	}
	
	public double strToDoub(String input) {
		return Double.parseDouble(input);
	}
	
	public void setResult(String result) {
		if (hasDec(result)) {
			String firstPart = result.substring(0, result.lastIndexOf("."));
			String lastPart = result.substring(result.lastIndexOf("."));
			if (lastPart.length() > 5) {
				this.result = firstPart + lastPart.substring(0, 5);
			} else {
				this.result = firstPart + lastPart;
			}
		} else this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	public String getDisplayText() {
		return numOne + "   " + operand + "   " + numTwo;
	}
}
