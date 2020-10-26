package com.registrationregex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {

	public static void main(String[] args) {

		System.out.println("== User Registration Form ==");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First Name :");
		String firstName = sc.next();
		validateName(firstName);

		System.out.println("Enter Last Name :");
		String lastName = sc.next();
		validateName(lastName);

		System.out.println("Enter Email id :");
		String email = sc.next();
		validateEmail(email);
		
		sc.close();
	}

	static void validateName(String name) {
		String nameRegex = "^[A-Z][a-z]{2,}$";
		if (Pattern.compile(nameRegex).matcher(name).matches())
			System.out.println("Valid");
		else
			System.out.println("Name should start with capital letter and need min 3 characters.");
	}

	static void validateEmail(String email) {
		String emailRegex = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@[0-9a-zA-Z]+.[a-zA-Z]{2,4}([.][a-zA-Z]{2})?$";

		if (Pattern.compile(emailRegex).matcher(email).matches())
			System.out.println("Valid");
		else
			System.out.println("Invalid email id");
	}
}
