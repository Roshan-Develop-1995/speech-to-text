package com.speech.text.domain.exception;

public class ServiceException extends InternalServerException{

    public ServiceException(String message) {
        super(message);
    }
}
