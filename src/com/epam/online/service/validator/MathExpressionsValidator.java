package com.epam.online.service.validator;

import com.epam.online.exception.EmptyExpressionException;
import com.epam.online.exception.IllegalCharacterException;
import com.epam.online.exception.IncorrectBracketsException;
import com.epam.online.exception.NotValidInputException;

import java.util.regex.Matcher;

import static com.epam.online.enums.RegularExpressionPatterns.INCORRECT_BRACKETS_PATTERN;
import static com.epam.online.enums.RegularExpressionPatterns.MATH_SYMBOLS_PATTERN;
import static com.epam.online.enums.Messages.*;

public class MathExpressionsValidator implements IValidator {
    public void validate(String inputString) throws NotValidInputException {
        if (inputString == null || inputString.isEmpty()) {
            throw new EmptyExpressionException(EMPTY_STRING.toString());
        }
        if (INCORRECT_BRACKETS_PATTERN.getPattern().matcher(inputString).find()) {
            throw new IncorrectBracketsException(ILLEGAL_BRACKETS.toString());
        }
        checkExpressionForIllegalCharacters(inputString);
    }

    /**
     * Method tries to check {@code inputString} for illegal characters,
     * double operators or invalid operators' sequence.
     * If {@code inputString} doesn't match regular expression, then exception will contain
     * message, which points to illegal character
     *
     * @param inputString math expression to be calculated without whitespaces between symbols
     * @throws IllegalCharacterException if given {@code inputString} is not valid mathematical expression
     */
    public void checkExpressionForIllegalCharacters(String inputString) throws IllegalCharacterException {
        Matcher matcher = MATH_SYMBOLS_PATTERN.getPattern().matcher(inputString);
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        if (matcher.find()) {
            stringBuilder.append(matcher.group());
            index = matcher.end();
        }

        if (index != inputString.length()) {
            stringBuilder.insert(0, "\n" + " ");
            stringBuilder.append(String.format(inputString.substring(index) + "\n"
                    + "%" + (++index) + "s%s%d \n", " ", ILLEGAL_CHARACTER, index));
            throw new IllegalCharacterException(stringBuilder.toString());
        }
    }
}
