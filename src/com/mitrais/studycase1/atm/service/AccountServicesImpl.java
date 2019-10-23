package com.mitrais.studycase1.atm.service;



import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WelcomeScreen;

import java.util.List;

public class AccountServicesImpl implements AccountServices {

	@Override
	// Get balance for calculate and validate accNumber and PIN
	public void validate(List<Account> accounts, String accountNumber, String pin) {
		int temp = 0;
		for (int i = 0; i < accounts.size(); i++) {
			if (accountNumber.equals(accounts.get(i).getAccountNumber()) && pin.equals(accounts.get(i).getPIN())) {
				WelcomeScreen.balance = accounts.get(i).getBalance();
				TransactionScreen transactionScreen = new TransactionScreen();
				temp = 0;
				transactionScreen.show(accounts);
			} else {
				temp = 1;
			}
		}
		if (temp == 1) {
			System.out.println("Invalid Account Number or PIN");
		}
	}

	@Override
	public void validateAccountNumber(String accountNumber, List<Account> accounts, WelcomeScreen welcomeScreen) {
		String regex = "[0-9]+";
		int accLength = accountNumber.length();
		if (accLength != 6) {
			System.out.println("Account Number should have 6 digits length");
			welcomeScreen.show(accounts);
		}
		if (!accountNumber.matches(regex)) {
			System.out.println("Account Number should only contains numbers");
			welcomeScreen.show(accounts);
		}
	}

	@Override
	public void validatePinNumber(String pin, List<Account> accounts, WelcomeScreen welcomeScreen) {
		String regex = "[0-9]+";
		int pinLength = pin.length();
		if (pinLength != 6) {
			System.out.println("PIN should have 6 digits length");
			welcomeScreen.show(accounts);
		}
		if (!(pin.matches(regex))) {
			System.out.println("PIN should only contains numbers");
			welcomeScreen.show(accounts);
		}
	}

}
