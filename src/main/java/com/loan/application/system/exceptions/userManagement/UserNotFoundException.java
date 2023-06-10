package com.loan.application.system.exceptions.userManagement;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends LoanAppException{
    public UserNotFoundException() {
        this("User not found");
    }
    public UserNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);}
}


