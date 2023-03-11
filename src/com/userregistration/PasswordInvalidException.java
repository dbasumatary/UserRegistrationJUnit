package com.userregistration;

//Custom Exception for invalid password
public class PasswordInvalidException extends Exception {
    public PasswordInvalidException(String message) {
        super(message);
    }
}
