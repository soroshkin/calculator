package com.epam.online.service.validator;

import com.epam.online.exception.NotValidInputException;

public interface IValidator {
    void validate(String inputString) throws NotValidInputException;
}
