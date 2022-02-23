package com.kiprono.spring_two.exceptions;

public class EmailTakenException extends RuntimeException{

    public EmailTakenException(String message) {
        super(message);
    }
}
