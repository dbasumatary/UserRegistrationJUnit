package com.userregistration;

//Custom Exception for invalid first name
public class FirstNameInvalidException extends Exception {
    public FirstNameInvalidException(String message) {
        super(message);
    }
}
