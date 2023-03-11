package com.userregistration;

//Custom Exception for invalid email address
public class EmailIdInvalidException extends Exception {
    public EmailIdInvalidException(String message) {
        super(message);
    }
}