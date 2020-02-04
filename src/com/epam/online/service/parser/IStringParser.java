package com.epam.online.service.parser;

import com.epam.online.exception.NotValidInputException;

import java.util.Deque;

public interface IStringParser {
    String OPEN_BRACKET = "(";
    String CLOSED_BRACKET = ")";

    Deque<String> parse(String inputString) throws NotValidInputException;

    boolean isMathOperation(String textToCheck);

    boolean hasHigherOrEqualPriority(String firstOperation, String secondOperation);
}
