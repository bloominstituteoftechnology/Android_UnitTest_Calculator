package com.lambdaschool.android_unittest_calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String expression;
    private String reCalculate;

    public Calculator() {
        this.expression = "";
        this.reCalculate = "";
    }

    public String addSymbol(String symbol) {
        this.expression += symbol;
        return this.expression;
    }

    public String addDecimal() {
        if (!this.expression.contains("."))
            this.expression += ".";

        return this.expression;
    }

    public String backspace() {
        if (this.expression.length() > 0)
            this.expression = this.expression.substring(0, this.expression.length() - 1);

        return this.expression;
    }

    public String addition() {
        if (this.expression.length() > 0 && !this.expression.contains("+"))
            this.expression += "+";

        return this.expression;
    }

    public String subtraction() {
        if (this.expression.length() > 0 && !this.expression.contains("-"))
            this.expression += "-";

        return this.expression;
    }

    public String multiplication() {
        if (this.expression.length() > 0 && !this.expression.contains("x"))
            this.expression += "x";

        return this.expression;
    }

    public String division() { // ALT 0247
        if (this.expression.length() > 0 && !this.expression.contains("÷"))
            this.expression += "÷";

        return this.expression;
    }

    public String square() { // ALT 0178
        if (this.expression.length() > 0 && !this.expression.contains("²"))
            this.expression += "²";

        return this.expression;
    }

    public String squareRoot() { // ALT 251
        if (this.expression.length() > 0 && !this.expression.contains("√"))
            this.expression += "√";

        return this.expression;
    }

    public String pi() { // ALT 227
        if (!this.expression.contains("π"))
            this.expression += "π";

        return this.expression;
    }

    public String calculate() {
        if (this.expression.length() > 0) {
            if (this.reCalculate.equals("")) {
                Pattern deconstructedPattern = Pattern.compile("([\\dπ.]+)([+\\-x÷²√π])?([\\dπ.]+)?");
                Matcher deconstructedMatcher = deconstructedPattern.matcher(this.expression);

                ArrayList<String> separatedGroups = new ArrayList<>();
                if (deconstructedMatcher.find()) {
                    for (int i = 1; i <= deconstructedMatcher.groupCount(); ++i) {
                        separatedGroups.add(deconstructedMatcher.group(i));
                    }
                    separatedGroups.removeAll(Collections.singleton(null));
                }

                if (separatedGroups.size() == 1) {
                    if (separatedGroups.get(0).equals("π")) {
                        this.expression = String.valueOf(Math.PI);
                    }
                } else if (separatedGroups.size() == 3) {

                    switch (separatedGroups.get(1)) {
                        case "+":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) + Double.parseDouble(separatedGroups.get(2)));
                            this.reCalculate = "+" + separatedGroups.get(2);
                            break;
                        case "-":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) - Double.parseDouble(separatedGroups.get(2)));
                            this.reCalculate = "-" + separatedGroups.get(2);
                            break;
                        case "x":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) * Double.parseDouble(separatedGroups.get(2)));
                            this.reCalculate = "x" + separatedGroups.get(2);
                            break;
                        case "÷":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) / Double.parseDouble(separatedGroups.get(2)));
                            this.reCalculate = "÷" + separatedGroups.get(2);
                            break;
                        case "²":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) * Double.parseDouble(separatedGroups.get(0)));
                            this.reCalculate = "²" + this.expression;
                            break;
                        case "√":
                            this.expression = String.valueOf(Math.sqrt(Double.parseDouble(separatedGroups.get(0))));
                            this.reCalculate = "√" + this.expression;
                            break;
                        case "π":
                            this.expression = String.valueOf(Double.parseDouble(separatedGroups.get(0)) * Math.PI);
                            this.reCalculate = "π" + this.expression;
                            break;
                    }
                }
            } else {
                switch (this.reCalculate.charAt(0)) {
                    case '+':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) + Double.parseDouble(this.reCalculate.substring(1)));
                        break;
                    case '-':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) - Double.parseDouble(this.reCalculate.substring(1)));
                        break;
                    case 'x':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) * Double.parseDouble(this.reCalculate.substring(1)));
                        break;
                    case '÷':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) / Double.parseDouble(this.reCalculate.substring(1)));
                        break;
                    case '²':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) * Double.parseDouble(this.expression));
                        break;
                    case '√':
                        this.expression = String.valueOf(Math.sqrt(Double.parseDouble(this.expression)));
                        break;
                    case 'π':
                        this.expression = String.valueOf(Double.parseDouble(this.expression) * Math.PI);
                        break;
                }
            }

            if (this.expression.endsWith(".0")) {
                this.expression = this.expression.replace(".0", "");
            }
        }

        return this.expression;
    }

    public String reset() {
        this.reCalculate = "";
        return this.expression = "";
    }

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
