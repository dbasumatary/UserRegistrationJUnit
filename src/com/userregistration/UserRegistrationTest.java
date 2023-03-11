package com.userregistration;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationTest {

    //Test case for first name
    @Test
    public void givenFirstName_IfConditionSatisfied_ShouldReturnTrue() throws FirstNameInvalidException{
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("Jace");
        boolean firstName = matcher.matches();
        if (!firstName) {
            throw new FirstNameInvalidException("Invalid first name");
        }
        Assert.assertEquals(true, firstName);
    }

    @Test
    public void givenFirstName_IfConditionNotSatisfied_ShouldThrowFirstNameInvalidException(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("jace");
        boolean firstName = matcher.matches();
        if (firstName) {
            Assert.fail("Should have thrown FirstNameInvalidException");
        }
        try {
            throw new FirstNameInvalidException("Invalid first name");
        } catch (FirstNameInvalidException e) {
            Assert.assertEquals("Invalid first name", e.getMessage());
        }
    }

    //Test case for last name
    @Test
    public void givenLastName_IfConditionSatisfied_ShouldReturnTrue() throws LastNameInvalidException {
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("Velaryon");
        boolean lastName = matcher.matches();
        if (!lastName) {
            throw new LastNameInvalidException("Invalid last name");
        }
        Assert.assertEquals(true, lastName);
    }

    @Test
    public void givenLastName_IfConditionNotSatisfied_ShouldThrowLastNameInvalidException(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("velaryon");
        boolean lastName = matcher.matches();
        if (lastName) {
            Assert.fail("Should have thrown LastNameInvalidException");
        }
        try {
            throw new LastNameInvalidException("Invalid last name");
        } catch (LastNameInvalidException e) {
            Assert.assertEquals("Invalid last name", e.getMessage());
        }
    }

    //Test case for email id
    @Test
    public void givenEmail_IfConditionSatisfied_ShouldReturnTrue() throws EmailIdInvalidException{
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");
        Matcher matcher = pattern.matcher("abc_def@gmail.com");
        boolean email = matcher.matches();
        if (!email) {
            throw new EmailIdInvalidException("Invalid email address");
        }
        Assert.assertEquals(true, email);
    }

    @Test
    public void givenEmail_IfConditionNotSatisfied_ShouldThrowEmailInvalidException(){
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");
        Matcher matcher = pattern.matcher("_abc_def@gmail.com");
        boolean email = matcher.matches();
        if (email) {
            Assert.fail("Should have thrown EmailInvalidException");
        }
        try {
            throw new EmailIdInvalidException("Invalid email address");
        } catch (EmailIdInvalidException e) {
            Assert.assertEquals("Invalid email address", e.getMessage());
        }
    }

    //Test case for mobile number
    @Test
    public void givenMobileNo_IfConditionSatisfied_ShouldReturnTrue() throws MobileInvalidException {
        Pattern pattern = Pattern.compile("^[+][0-9]{2}-[0-9]{10}$");
        Matcher matcher = pattern.matcher("+91-9876543201");
        boolean mobileNo = matcher.matches();
        Assert.assertEquals(true, mobileNo);
        if (!mobileNo) {
            throw new MobileInvalidException("Invalid mobile number");
        }
        Assert.assertEquals(true, mobileNo);
    }

    @Test
    public void givenMobileNo_IfConditionNotSatisfied_ShouldThrowMobileInvalidException(){
        Pattern pattern = Pattern.compile("^[+][0-9]{2}-[0-9]{10}$");
        Matcher matcher = pattern.matcher("+919876543201");
        boolean mobileNo = matcher.matches();
        if (mobileNo) {
            Assert.fail("Should have thrown MobileInvalidException");
        }
        try {
            throw new MobileInvalidException("Invalid mobile number");
        } catch (MobileInvalidException e) {
            Assert.assertEquals("Invalid mobile number", e.getMessage());
        }
    }

    //Test case for password
    @Test
    public void givenPassword_IfConditionSatisfied_ShouldReturnTrue() throws PasswordInvalidException {
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");
        Matcher matcher = pattern.matcher("Has732h#dlK");
        boolean password = matcher.matches();
        if (!password) {
            throw new PasswordInvalidException("Invalid password");
        }
        Assert.assertEquals(true, password);
    }

    @Test
    public void givenPassword_IfConditionNotSatisfied_ShouldThrowPasswordInvalidException(){
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");
        Matcher matcher = pattern.matcher("jaGy97Sd#gv@80s");
        boolean password = matcher.matches();
        if (password) {
            Assert.fail("Should have thrown PasswordInvalidException");
        }
        try {
            throw new PasswordInvalidException("Invalid password");
        } catch (PasswordInvalidException e) {
            Assert.assertEquals("Invalid password", e.getMessage());
        }
    }
}

