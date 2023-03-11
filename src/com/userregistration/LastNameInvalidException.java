package com.userregistration;

//Custom Exception for invalid last name
public class LastNameInvalidException extends Exception {
    public LastNameInvalidException(String message) {
        super(message);
    }
}
