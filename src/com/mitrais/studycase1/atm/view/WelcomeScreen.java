package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.AccountServices;
import com.mitrais.studycase1.atm.service.AccountServicesImpl;

import java.util.List;
import java.util.Scanner;

public class WelcomeScreen {

	public static int balance;
	public static String accountNumber;
	public static String pin;

	public void show(List<Account> accounts) {

		AccountServices userService = new AccountServicesImpl();
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("Welcome Screen");
		System.out.println("---------------");

		System.out.print("Enter Account Number: ");

		accountNumber = scan.nextLine();


		userService.validateAccountNumber(accountNumber, accounts, welcomeScreen);

		System.out.print("Enter PIN: ");
		pin = scan.nextLine();

		userService.validatePinNumber(pin, accounts, welcomeScreen);

		userService.validate(accounts, accountNumber, pin);

	}

}
