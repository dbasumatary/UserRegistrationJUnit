package com.userregistration;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationTest {

    //Test case for first name
    @Test
    public void givenFirstName_IfConditionSatisfied_ShouldReturnTrue(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("Jace");
        boolean firstName = matcher.matches();
        Assert.assertEquals(true, firstName);
    }
    @Test
    public void givenFirstName_IfConditionNotSatisfied_ShouldReturnFalse(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("jace");
        boolean firstName = matcher.matches();
        Assert.assertEquals(false, firstName);
    }

    //Test case for last name
    @Test
    public void givenLastName_IfConditionSatisfied_ShouldReturnTrue(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("Velaryon");
        boolean lastName = matcher.matches();
        Assert.assertEquals(true, lastName);
    }
    @Test
    public void givenLastName_IfConditionNotSatisfied_ShouldReturnFalse(){
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher("velaryon");
        boolean lastName = matcher.matches();
        Assert.assertEquals(false, lastName);
    }

    //Test case for email id
    @Test
    public void givenEmail_IfConditionSatisfied_ShouldReturnTrue(){
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");
        Matcher matcher = pattern.matcher("abc_def@gmail.com");
        boolean email = matcher.matches();
        Assert.assertEquals(true, email);
    }
    @Test
    public void givenEmail_IfConditionNotSatisfied_ShouldReturnFalse(){
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");
        Matcher matcher = pattern.matcher("_abc_def@gmail.com");
        boolean email = matcher.matches();
        Assert.assertEquals(false, email);
    }

    //Test case for mobile number
    @Test
    public void givenMobileNo_IfConditionSatisfied_ShouldReturnTrue(){
        Pattern pattern = Pattern.compile("^[+][0-9]{2}-[0-9]{10}$");
        Matcher matcher = pattern.matcher("+91-9876543201");
        boolean mobileNo = matcher.matches();
        Assert.assertEquals(true, mobileNo);
    }
    @Test
    public void givenMobileNo_IfConditionNotSatisfied_ShouldReturnFalse(){
        Pattern pattern = Pattern.compile("^[+][0-9]{2}-[0-9]{10}$");
        Matcher matcher = pattern.matcher("+919876543201");
        boolean mobileNo = matcher.matches();
        Assert.assertEquals(false, mobileNo);
    }

    //Test case for password
    @Test
    public void givenPassword_IfConditionSatisfied_ShouldReturnTrue(){
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");
        Matcher matcher = pattern.matcher("Has732h#dlK");
        boolean password = matcher.matches();
        Assert.assertEquals(true, password);
    }
    @Test
    public void givenPassword_IfConditionNotSatisfied_ShouldReturnFalse(){
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");
        Matcher matcher = pattern.matcher("jaGy97Sd#gv@80s");
        boolean password = matcher.matches();
        Assert.assertEquals(false, password);
    }
}

