package com.registrationregex;

import java.util.Scanner;
import java.util.regex.Pattern;
@FunctionalInterface
interface Validator {
	public void validate(String regex, String input);
}
public class UserRegistration {

	public static void main(String[] args) {
		Validator validateDetail = (regex,input) ->	{
			if (Pattern.compile(regex).matcher(input).matches())
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		};
		Validator validatePassword = (regex,input) ->	{
			if (Pattern.compile(regex).matcher(input).matches() &&
					Pattern.compile(".*[A-Z].*").matcher(input).matches() &&
					Pattern.compile(".*[0-9].*").matcher(input).matches() &&
					input.length()-input.replaceAll("\\W", "").length() == 1)
					System.out.println("Valid");
			else
					System.out.println("Invalid");	
		};
		System.out.println("== User Registration Form ==");
		Scanner sc = new Scanner(System.in);
		Scanner scline = new Scanner(System.in);

		System.out.println("Enter First Name :");
		String firstName = sc.next();
		validateDetail.validate("^[A-Z][a-z]{2,}$",firstName);  

		System.out.println("Enter Last Name :");
		String lastName = sc.next();
		validateDetail.validate("^[A-Z][a-z]{2,}$",lastName);  

		System.out.println("Enter Email id :");
		String email = sc.next();
		validateDetail.validate("^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@[0-9a-zA-Z]+.[a-zA-Z]{2,4}([.][a-zA-Z]{2})?$",email);  

		System.out.println("Enter Mobile Number :");
		String mobNo = scline.nextLine();
		validateDetail.validate("^[1-9]{2,3}\\s[7-9]{1}[0-9]{9}$",mobNo);  
		
		System.out.println("Enter Password :");
		String password = sc.next();
		validatePassword.validate("[\\w\\W]{8,}", password);
		
		sc.close();
		scline.close();

	}

}
