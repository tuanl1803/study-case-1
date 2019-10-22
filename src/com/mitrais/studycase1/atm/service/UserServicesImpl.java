package com.mitrais.studycase1.atm.service;



import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WelcomeScreen;

import java.util.List;

public class UserServicesImpl implements UserService {

	@Override
	// Get balance for calculate and validate accNumber and PIN
	public void validate(List<Account> users, String accountNumber, String pin) {
		int temp = 0;
		for (int i = 0; i < users.size(); i++) {
			if (accountNumber.equals(users.get(i).getAccountNumber()) && pin.equals(users.get(i).getPIN())) {
				WelcomeScreen.balance = users.get(i).getBalance();
				TransactionScreen transactionScreen = new TransactionScreen();
				temp = 0;
				transactionScreen.show();
			} else {
				temp = 1;
			}
		}
		if (temp == 1) {
			System.out.println("Invalid Account Number or PIN");
		}
	}

	@Override
	public void validateAccountNumber(String accountNumber, List<Account> users, WelcomeScreen welcomeScreen) {
		String regex = "[0-9]+";
		int accLength = accountNumber.length();
		if (accLength != 6) {
			System.out.println("Account Number should have 6 digits length");
			welcomeScreen.show();
		}
		if (!accountNumber.matches(regex)) {
			System.out.println("Account Number should only contains numbers");
			welcomeScreen.show();
		}
	}

	@Override
	public void validatePinNumber(String pin, List<Account> users, WelcomeScreen welcomeScreen) {
		String regex = "[0-9]+";
		int pinLength = pin.length();
		if (pinLength != 6) {
			System.out.println("PIN should have 6 digits length");
			welcomeScreen.show();
		}
		if (!(pin.matches(regex))) {
			System.out.println("PIN should only contains numbers");
			welcomeScreen.show();
		}
	}

}
