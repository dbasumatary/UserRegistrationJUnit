package com.userregistration;

//UC-11: JUnit Parameterised test to validate multiple entry of email address

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//The @RunWith annotation is used to indicate that the test should be executed with a parameterized test runner,
// and to provide the test data.
@RunWith(Parameterized.class)
public class UserJUnitParameterizedTest {

    private String email;
    private boolean expectedResult;

    //constructor
    public UserJUnitParameterizedTest(String email, boolean expectedResult) {
        this.email = email;
        this.expectedResult = expectedResult;
    }

    //The @Parameters annotation is used to indicate that the test should be executed with a parameterized test runner,
    // and to provide the test data.
    @Parameters

    //This method returns an array of objects, where each object contains an email address and a boolean value
    // indicating whether the email address is valid or not.
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "abc@bridgelabz.co.in", true }, { "abc@gmail.com.com", true },
                { "abc@yahoo.com", true }, { "abc@1.com", true }, { "abc-100@yahoo.com", true },
                { "abc.100@yahoo.com", true }, { "abc111@abc.com", true }, { "abc-100@abc.net", true },
                { "abc.100@abc.com.au", true }, { "abc+100@gmail.com", true },

                { ".abc@abc.com", false }, { "abc", false }, { "abc@.com.my", false }, { "abc@abc@gmail.com", false },
                { "abc()*@gmail.com", false }, { "abc..2002@gmail.com", false }, { "abc.@gmail.com", false },
                { "abc123@.com", false }, { "abc123@.com.com", false }, { "abc123@gmail.a", false },
                { "abc@%*.com", false }, { "abc@gmail.com.1a", false }, { ".abc@gmail.com.aa.au", false }
        };
        return Arrays.asList(data);
    }

    @Test
    //Test method
    public void testEmailValidator() throws EmailIdInvalidException{
        assertEquals(expectedResult, EmailValidator.isValid(email));
    }

    //This method contains email validation logic
    private static class EmailValidator {
        public static boolean isValid(String email) {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            return email.matches(regex);
        }
    }
}
