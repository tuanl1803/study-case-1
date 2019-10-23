package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferServices;
import com.mitrais.studycase1.atm.service.FundTransferServicesImpl;

import java.util.List;

public class FundTransferScreen1 {
	public static String destinationAcc;
	public static String tranferAmt;
	public static String referenceNum;

	FundTransferServices fundTransferServices = new FundTransferServicesImpl();

	public void show(List<Account> accounts) {

		System.out.println();
		System.out.println("Fund Transfer Screen");
		System.out.println("----------------");
		System.out.println();
		System.out.print("Please enter destination account and \r\n" + 
				         "Press enter to continue or \r\n" + 
				         "Press cancel (Esc) to go back to Transaction: ");

		fundTransferServices.inputDestinationAccount(accounts);
		
	}

}
