package com.loan.application.system.exceptions.userManagement;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class LoanAppException extends RuntimeException{
    @Getter
    private final HttpStatus status;

    public LoanAppException(){
        this("An error occurred");
    }

    public LoanAppException(String message){
        this(message, HttpStatus.BAD_REQUEST);

    }

    public LoanAppException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

}

