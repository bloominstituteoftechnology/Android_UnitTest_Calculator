package com.example.calculatorunittest;

import com.example.calculatorunittest.classes.Calculator;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void shouldNotReturnNull(){

    }
}
