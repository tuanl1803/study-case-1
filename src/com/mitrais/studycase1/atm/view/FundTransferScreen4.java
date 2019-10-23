package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferServices;
import com.mitrais.studycase1.atm.service.FundTransferServicesImpl;

import java.util.ArrayList;
import java.util.List;

public class FundTransferScreen4 {

    public void show(List<Account> accounts) {

        FundTransferServices fundTransferServices = new FundTransferServicesImpl();
        FundTransferScreen1 fundTransferScreen = new FundTransferScreen1();

        System.out.println();
        System.out.println("Transfer Confirmation");
        System.out.println("Destination Account: " + FundTransferScreen1.destinationAcc);
        System.out.println("Transfer Amount: $" + FundTransferScreen1.tranferAmt);
        System.out.println("Reference Number: " + FundTransferScreen1.referenceNum);

        System.out.println("1. Confirm Trx");
        System.out.println("2. Cancel Trx");

        fundTransferServices.transferConfirmScreen(fundTransferScreen, accounts);
    }

}
