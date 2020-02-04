package com.epam.online.util;

import com.epam.online.enums.Messages;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Class is used to work with console
 */
public class ConsoleHelper {
    /**
     * Reads string from console
     *
     * @return input {@link java.lang.String}
     */
    public static String readInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().replaceAll("\\s", "");
    }

    public static void printResult(BigDecimal result) {
        System.out.println(Messages.RESULT_OF_EXPRESSION.toString() + result);
    }

    public static void enterExpression(String exitApplicationCommand) {
        System.out.println(Messages.INPUT_EXPRESSION.toString() + exitApplicationCommand);
    }
}
