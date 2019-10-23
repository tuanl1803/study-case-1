package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferServices;
import com.mitrais.studycase1.atm.service.FundTransferServicesImpl;
import java.util.List;

public class FundTransferScreen2 {

	public void show(List<Account> accounts) {
		FundTransferServices fundTransferServices = new FundTransferServicesImpl();
		
		System.out.println();
		System.out.print("Please enter transfer amount and \r\n" + 
			         	 "Press enter to continue or \r\n" + 
				         "Press cancel (Esc) to go back to Transaction: ");
		
		fundTransferServices.inputAmountScreen(accounts);
		
	}
}
