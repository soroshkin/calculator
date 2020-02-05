package com.epam.online;

import com.epam.online.exception.NotValidInputException;
import com.epam.online.service.calculation.Calculation;
import com.epam.online.service.calculation.ICalculation;
import com.epam.online.service.parser.IStringParser;
import com.epam.online.service.validator.IValidator;
import com.epam.online.service.validator.MathExpressionsValidator;
import com.epam.online.service.parser.StringParser;
import com.epam.online.util.ConsoleHelper;


public class Calculator {
    // Command used to exit the application
    private static final String EXIT_APPLICATION_COMMAND = "quit";

    public static void main(String[] args) {
        IValidator mathExpressionsValidator = new MathExpressionsValidator();
        IStringParser stringParser = new StringParser();
        ICalculation calculation = new Calculation();
        String inputString;

        while (!(inputString = ConsoleHelper.enterAndReadExpression(EXIT_APPLICATION_COMMAND)).equalsIgnoreCase(EXIT_APPLICATION_COMMAND)) {
            try {
                mathExpressionsValidator.validate(inputString);
                ConsoleHelper.printResult(calculation.calculate(stringParser.parse(inputString)));
            } catch (NotValidInputException | ArithmeticException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
