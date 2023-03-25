package com.speech.text.domain.exception;

public class RetryException extends RuntimeException{
    public RetryException(String message){
        super(message);
    }
}
