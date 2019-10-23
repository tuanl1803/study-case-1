package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferServices;
import com.mitrais.studycase1.atm.service.FundTransferServicesImpl;

import java.util.List;
import java.util.Scanner;

public class FundTransferSummaryScreen {

	public void show(List<Account> accounts) {
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		FundTransferServices fundTransferServices = new FundTransferServicesImpl();
		TransactionScreen transactionScreen = new TransactionScreen();
		System.out.println();
		System.out.println("Fund Transfer Summary Screen");
		System.out.println("----------------------");
		
		System.out.println("Destination Account: " + FundTransferScreen1.destinationAcc);
		System.out.println("Transfer Amount: $" + FundTransferScreen1.tranferAmt);
		System.out.println("Reference Number: " + FundTransferScreen1.referenceNum);
		System.out.println("Balance: $" + WelcomeScreen.balance);
		
		System.out.println("1. Transaction");
		System.out.println("2. Exit");
		
		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {
		case "1":
			fundTransferServices.transaction(transactionScreen);
			break;
		case "2":
		case "":
			welcomeScreen.show(accounts);
			break;
		default:
			show(accounts);
			break;
		}
	}
}
