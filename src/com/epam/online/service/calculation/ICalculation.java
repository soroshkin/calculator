package com.epam.online.service.calculation;

import com.epam.online.exception.NotValidInputException;

import java.math.BigDecimal;
import java.util.Deque;

public interface ICalculation {
    BigDecimal calculate(Deque<String> expression) throws NotValidInputException, ArithmeticException;
}
