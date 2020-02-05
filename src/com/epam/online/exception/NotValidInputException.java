package com.epam.online.exception;

public class NotValidInputException extends Exception {
    public NotValidInputException() {
        super();
    }

    public NotValidInputException(String message) {
        super(message);
    }

    public NotValidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidInputException(Throwable cause) {
        super(cause);
    }
}
