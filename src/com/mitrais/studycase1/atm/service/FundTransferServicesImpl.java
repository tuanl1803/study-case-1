package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FundTransferServicesImpl implements FundTransferServices {

	@Override
	public void inputDestinationAccount(List<Account> accounts) {
		
		String regex = "[0-9]+";
		FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
		FundTransferScreen1 transferScreen1 = new FundTransferScreen1();
		Scanner scan = new Scanner(System.in);
		FundTransferScreen1.destinationAcc = scan.nextLine();

		if (!FundTransferScreen1.destinationAcc.matches(regex)) {
			System.out.println("Invalid account");
			transferScreen1.show(accounts);
		}

		if (isExists(accounts)) {
			transferScreen2.show(accounts);
		} else {
			System.out.println("Invalid account");
			transferScreen1.show(accounts);
		}
	}

	@Override
	public void inputAmountScreen(List<Account> accounts) {
		
		String regex = "\\d+";
		Scanner scan = new Scanner(System.in);
		FundTransferScreen3 transferScreen3 = new FundTransferScreen3();
		FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
		FundTransferScreen1.tranferAmt = scan.nextLine();

		if (!FundTransferScreen1.tranferAmt.matches(regex)) {
			System.out.println("Invalid ammount");
			transferScreen2.show(accounts);
		} else if (Integer.parseInt(FundTransferScreen1.tranferAmt) > 1000) {
			System.out.println("Maximum amount to transfer is $1000");
			transferScreen2.show(accounts);
		} else if (WelcomeScreen.balance - Integer.parseInt(FundTransferScreen1.tranferAmt) < 0) {
			System.out.println("Insufficient balance $" + FundTransferScreen1.tranferAmt);
			transferScreen2.show(accounts);
		} else if (Integer.parseInt(FundTransferScreen1.tranferAmt) < 1) {
			System.out.println("Minimum amount to transfer is $1");
		} else {
			transferScreen3.show(accounts);
		}
	}

	@Override
		
	public void inputReferenceNumberScreen(List<Account> accounts) {
		
		FundTransferScreen4 fundTransferScreen4 = new FundTransferScreen4();
		FundTransferScreen3 fundTransferScreen3 = new FundTransferScreen3();
		String regex = "[0-9]+";
		Scanner scan = new Scanner(System.in);
		FundTransferScreen1.referenceNum = scan.nextLine();

		if (!FundTransferScreen1.referenceNum.matches(regex) && !FundTransferScreen1.referenceNum.isEmpty()) {
			System.out.println("Invalid Reference Number");
			fundTransferScreen3.show(accounts);
		} else {
			fundTransferScreen4.show(accounts);
		}

	}

	@Override
	public void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, List<Account> accounts) {

		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {
		case "1":
			FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
			WelcomeScreen.balance -= Integer.parseInt(FundTransferScreen1.tranferAmt);
			addAmountToDestination(accounts);
			fundTransferSummaryScreen.show(accounts);
			break;
		case "2":
			TransactionScreen transactionScreen = new TransactionScreen();
			transactionScreen.show(accounts);
			break;
		case "":
			fundTransferScreen.show(accounts);
			break;
		default:
			break;
		}
	}

	@Override
	public void transaction(TransactionScreen transactionScreen) {
		List<Account> accounts = new ArrayList<>();

		for (int i = 0; i < accounts.size(); i++) {
			if (WelcomeScreen.accountNumber.equals(accounts.get(i).getAccountNumber())
					&& WelcomeScreen.pin.equals(accounts.get(i).getPIN())) {
				accounts.get(i).setBalance(WelcomeScreen.balance);
			}
		}
		System.out.println("Transaction Succeed");
		transactionScreen.show(accounts);
		
	}

	@Override
	public boolean isExists(List<Account> accounts) {
		boolean isExists = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (FundTransferScreen1.destinationAcc.equals(accounts.get(i).getAccountNumber())) {
				isExists = true;
				break;
			} else {
				isExists = false;
			}
		}
		return isExists;
	}

	@Override
	public void addAmountToDestination(List<Account> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (FundTransferScreen1.destinationAcc.equals(accounts.get(i).getAccountNumber())){
				int temp = accounts.get(i).getBalance() + Integer.parseInt(FundTransferScreen1.tranferAmt);
				accounts.get(i).setBalance(temp);
				break;
			}
		}
	}

}
