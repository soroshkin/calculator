package com.epam.online.exception;

public class IncorrectBracketsException extends NotValidInputException {
    public IncorrectBracketsException() {
    }

    public IncorrectBracketsException(String message) {
        super(message);
    }

    public IncorrectBracketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectBracketsException(Throwable cause) {
        super(cause);
    }
}
