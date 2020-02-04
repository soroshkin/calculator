package com.epam.online.service.parser;

import com.epam.online.exception.IncorrectBracketsException;

import java.util.*;
import java.util.regex.Matcher;

import static com.epam.online.enums.RegularExpressionPatterns.*;
import static com.epam.online.enums.MathOperator.*;
import static com.epam.online.enums.Messages.INCORRECT_BRACKETS;

public class StringParser implements IStringParser {

    /**
     * Parses given String to expression in Reverse Polish notation (RPN) form
     *
     * @param inputString - String to be parsed
     * @return Deque of strings, which represent expression in RPN form
     * @throws IncorrectBracketsException if brackets put incorrectly
     */
    public Deque<String> parse(String inputString) throws IncorrectBracketsException {

        Deque<String> expressionToCalculate = new LinkedList<>();
        Deque<String> mathOperationsStack = new LinkedList<>();

        while (inputString.length() > 0) {
            Matcher matcher = DIGIT_PATTERN.getPattern().matcher(inputString);
            if (matcher.find()) {
                inputString = inputString.substring(matcher.end());
                expressionToCalculate.push(matcher.group());
                continue;
            }

            if (matcher.usePattern(UNARY_MINUS_PATTERN.getPattern()).find()) {
                inputString = inputString.substring(matcher.end());
                mathOperationsStack.push(OPEN_BRACKET);
                expressionToCalculate.push(String.valueOf(0));
                mathOperationsStack.push(MINUS.getOperator());
                continue;
            }

            String currentSymbol = inputString.substring(0, 1);
            inputString = inputString.substring(1);

            if (currentSymbol.equals(OPEN_BRACKET)) {
                mathOperationsStack.push(currentSymbol);
                continue;
            }

            if (currentSymbol.equals(CLOSED_BRACKET)) {
                String lastOperatorInStack;
                try {
                    while (!(lastOperatorInStack = mathOperationsStack.pop()).equals(OPEN_BRACKET)) {
                        expressionToCalculate.push(lastOperatorInStack);
                    }
                } catch (NoSuchElementException e) {
                    throw new IncorrectBracketsException(INCORRECT_BRACKETS.toString());
                }
                continue;
            }

            if (isMathOperation(currentSymbol)) {
                String lastOperatorInStack;
                while ((lastOperatorInStack = mathOperationsStack.peek()) != null
                        && isMathOperation(lastOperatorInStack)
                        && hasHigherOrEqualPriority(lastOperatorInStack, currentSymbol)) {
                    expressionToCalculate.push(mathOperationsStack.pop());
                }
                mathOperationsStack.push(currentSymbol);
            }
        }

        if (mathOperationsStack.contains(OPEN_BRACKET)) {
            throw new IncorrectBracketsException(INCORRECT_BRACKETS.toString());
        } else {
            mathOperationsStack.forEach(expressionToCalculate::push);
            return expressionToCalculate;
        }
    }

    /**
     * Checks whether String is arithmetical operation
     *
     * @param textToCheck the text which has to be checked whether it is math operator or not
     * @return {@code true} String is arithmetical operation
     */
    public boolean isMathOperation(String textToCheck) {
        return contains(textToCheck);
    }

    /**
     * @param firstOperation  arithmetical operation represented by String
     * @param secondOperation arithmetical operation represented by String
     * @return {@code true} if first argument has higher priority
     */
    public boolean hasHigherOrEqualPriority(String firstOperation, String secondOperation) {
        return Objects.requireNonNull(findByOperator(firstOperation)).getPriority()
                .compareTo(Objects.requireNonNull(findByOperator(secondOperation)).getPriority()) >= 0;
    }
}
