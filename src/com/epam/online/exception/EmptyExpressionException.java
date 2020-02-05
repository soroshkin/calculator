package com.epam.online.exception;

public class EmptyExpressionException extends NotValidInputException {
    public EmptyExpressionException() {
        super();
    }

    public EmptyExpressionException(String message) {
        super(message);
    }

    public EmptyExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyExpressionException(Throwable cause) {
        super(cause);
    }
}
