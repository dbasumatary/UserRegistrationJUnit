package com.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    //UC1: User need to input valid first name
    //The first name starts with capital letter and has minimum three characters
    public void checkUserFirstName() throws FirstNameInvalidException{

        System.out.print("Enter your First Name: ");
        userDetails.setFirstName(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.getFirstName());

        //the matches() method tries to match the whole string against the pattern.
        boolean isFirstName =  matcher.matches();

        if(isFirstName)
            System.out.println(userDetails.firstName + " is a valid First Name.\n");
        else
            System.err.println(userDetails.firstName + " is an invalid First Name.");
    }

    //UC2: User need to input valid last name
    //The last name starts with capital letter and has minimum three characters
    public void checkUserLastName() throws LastNameInvalidException{

        System.out.print("Enter your last Name: ");
        userDetails.setLastName(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,}");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.getLastName());

        //the matches() method tries to match the whole string against the pattern.
        boolean isLastName =  matcher.matches();

        if(isLastName)
            System.out.println(userDetails.lastName + " is a valid last Name.\n");
        else
            System.err.println(userDetails.lastName + " is an invalid last Name.");
    }

    //UC3: User need to input valid email address
    public void checkEmailAddress() throws EmailIdInvalidException{
        System.out.print("Enter your email address: ");
        userDetails.setEmailAddress(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("^(?=.{3,20}@)[a-zA-Z]+[A-Za-z0-9]+[- + . _]?[a-zA-Z0-9]+.@[^-_.][a-zA-Z0-9]+(\\.[a-z]+)(\\.[a-z]+)*$");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.getEmailAddress());

        //the matches() method tries to match the whole string against the pattern.
        boolean isEmail =  matcher.matches();

        if(isEmail) {
            System.out.println(userDetails.emailAddress + " is a valid email address.\n");
        }
        else {
            System.err.println("Please enter a valid email address.");
        }
    }

    //UC4: Valid Mobile No (country code followed by space and 10-digit number)
    public void checkValidMobileNumber() throws MobileInvalidException{
        System.out.print("Enter your mobile number: ");

        //Setting the input as mobile number
        userDetails.setMobileNumber(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine.
        Pattern pattern = Pattern.compile("^[+][0-9]{2}-[0-9]{10}$");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcher = pattern.matcher(userDetails.getMobileNumber());

        //the matches() method tries to match the whole string against the pattern.
        boolean isMobileNumber =  matcher.matches();

        if(isMobileNumber)
            System.out.println(userDetails.mobileNumber + " is a valid mobile number.\n");
        else
            System.err.println(userDetails.mobileNumber + " is an invalid mobile number.");
    }

    //UC8: Valid Password (Exactly 1 special character)
    public void checkValidPassword() throws PasswordInvalidException{
        System.out.print("Enter your password: ");

        //Setting the input as password
        userDetails.setPassword(scanner.next());

        //The Pattern class is used to define a pattern for the regex engine. Look up
        Pattern pattern = Pattern.compile("^((?=.*[A-Z])(?=.*[0-9])(?=[^!@#$%&]*[!@#$%&][^!@#$%&]*$)[A-Za-z0-9!@#$%&]{8,})$");

        // The Matcher class is used to perform match operations on a character sequence.
        Matcher matcherObject = pattern.matcher(userDetails.getPassword());

        //the matches() method tries to match the whole string against the pattern.
        boolean isPassword =  matcherObject.matches();

        if(isPassword) {
            System.out.println(userDetails.password + " is a valid password.\n");
        }
        else {
            System.err.println(userDetails.password + " is an invalid password.\n");
            System.err.println("Password should not contain less than 8 characters");
            System.err.println("Password should contain at least one upper case");
            System.err.println("Password should contain at least one number");
            System.err.println("Password should contain exactly one special character");
        }
    }

    public static void main(String[] args) throws Throwable {
        System.out.println("---------- User Registration ----------\n");
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.checkUserFirstName();
        userRegistration.checkUserLastName();
        userRegistration.checkEmailAddress();
        userRegistration.checkValidMobileNumber();
        userRegistration.checkValidPassword();
    }
}
