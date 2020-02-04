package com.epam.online;

import com.epam.online.exception.NotValidInputException;
import com.epam.online.service.calculation.Calculation;
import com.epam.online.service.validator.MathExpressionsValidator;
import com.epam.online.service.parser.StringParser;
import com.epam.online.util.ConsoleHelper;


public class Calculator {
    // Command used to exit the application
    private static final String exitApplicationCommand = "quit";

    public static void main(String[] args) {
        while (true) {
            ConsoleHelper.enterExpression(exitApplicationCommand);
            String inputString;
            if (!(inputString = ConsoleHelper.readInputString()).equalsIgnoreCase(exitApplicationCommand)) {
                try {
                    new MathExpressionsValidator().validate(inputString);
                    ConsoleHelper.printResult(new Calculation().calculate(new StringParser().parse(inputString)));
                } catch (NotValidInputException e) {
                    System.err.printf("%s: %s\n", e.getClass().getSimpleName(), e.getMessage());
                }
            } else {
                break;
            }
        }
    }
}
