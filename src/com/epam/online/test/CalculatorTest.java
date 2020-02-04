package com.epam.online.test;

import com.epam.online.exception.NotValidInputException;
import com.epam.online.service.calculation.Calculation;
import com.epam.online.service.calculation.ICalculation;
import com.epam.online.service.parser.StringParser;
import com.epam.online.service.validator.MathExpressionsValidator;
import com.epam.online.util.ConsoleHelper;

import java.util.LinkedList;

public class CalculatorTest {
    public static void main(String[] args) {
        ICalculation calculation = new Calculation();
        LinkedList<String> expression = new LinkedList<>();
        expression.add("1*5.00(4)");
        expression.add("(-3) + 5 * ((-8) - 1)^2"); //402
        expression.add("(-(5.6565))");
        expression.add("(-((-5)))");
        expression.add(" (-1)+5*898^1+(-1)*(5)-(-(5.6565))"); //4489.65
        expression.add("0+1"); //1
        expression.add("((-2)+4)-(-6) - ((-4) * 3.5)");//22
        expression.add("4-(2)");//2
        expression.add("(-2) - ((-4) * 3.5)");//12
        expression.add("4^6.9809");//15955.8
        expression.add("534-");
        expression.add("(5246+)565*");
        expression.add("0.333333333333333333336");
        expression.add("(4.2 + 2^3)) * 3 / 3 - 6.1"); //несогласованные скобки
        expression.add("(4.2 + 2^3) + 3 / 3");
        expression.add("4.2 + 2 * 3 / 3 - 6.1");
        expression.add("4.2");
        expression.add("4");
        expression.add("4/0");
        expression.add("4.+6-4");
        expression.add("");
        expression.add("4.24523423424+6-4");
        expression.add("!4.+6-4");
        expression.add("4+6-4!");
        expression.add("4+6-4)");
        expression.add("(4.2 + 2) * 3 / 3 - 6.1");
        expression.add("(4.2 + 2^3) * 3 / 3 - 6.1");
        expression.add("(4,2 + 2^3) * 3 / 3 - 6.1");
        expression.add("1+5.5(3)");

        expression.forEach((element) -> {
            try {
                element = element.replaceAll("\\s", "");
                MathExpressionsValidator mathExpressionsValidator = new MathExpressionsValidator();
                mathExpressionsValidator.validate(element);
                ConsoleHelper.printResult(calculation.calculate(new StringParser().parse(element)));
            } catch (NotValidInputException | ArithmeticException e) {
                System.err.printf("%s: %s\n", e.getClass().getSimpleName(), e.getMessage());
            }
        });

    }
}
