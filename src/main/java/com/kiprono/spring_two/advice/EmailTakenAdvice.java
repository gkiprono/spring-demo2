package com.kiprono.spring_two.advice;


import com.kiprono.spring_two.exceptions.EmailTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailTakenAdvice {

    @ResponseBody
    @ExceptionHandler(EmailTakenException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String emailNotFound(EmailTakenException exception){
        return exception.getMessage();
    }

}
