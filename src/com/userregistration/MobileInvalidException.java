package com.userregistration;

//Custom Exception for invalid mobile number
public class MobileInvalidException extends Exception {
    public MobileInvalidException(String message) {
        super(message);
    }
}
