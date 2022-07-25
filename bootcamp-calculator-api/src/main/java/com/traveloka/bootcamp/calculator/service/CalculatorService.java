package com.traveloka.bootcamp.calculator.service;

import com.traveloka.bootcamp.calculator.model.CalculatorAddRequest;
import com.traveloka.bootcamp.calculator.model.CalculatorAddResponse;
import com.traveloka.bootcamp.calculator.model.CalculatorSubtractRequest;
import com.traveloka.bootcamp.calculator.model.CalculatorSubtractResponse;

public interface CalculatorService {
    int add(int a, int b);

    CalculatorAddResponse add(CalculatorAddRequest calculatorAddRequest);

    int subtract(int a, int b);

    CalculatorSubtractResponse subtract(CalculatorSubtractRequest calculatorSubtractRequest);
}