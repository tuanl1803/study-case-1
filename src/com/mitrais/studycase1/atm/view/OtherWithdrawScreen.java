package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.WithdrawServices;
import com.mitrais.studycase1.atm.service.WithdrawServicesImpl;

import java.util.List;
import java.util.Scanner;

public class OtherWithdrawScreen {

    public void show(List<Account> accounts) {
        SummaryScreen summaryScreen = new SummaryScreen();
        WithdrawScreen withdrawScreen = new WithdrawScreen();
        WithdrawServices withdrawServices = new WithdrawServicesImpl();

        System.out.println();
        System.out.println("Other Withdraw Screen");
        System.out.println("--------------------");
        System.out.print("Enter amount to withdraw: ");
        Scanner scan = new Scanner(System.in);
        String amount = scan.nextLine();

        withdrawServices.validateAndCalculateWithdrawAmount(amount, accounts, withdrawScreen, summaryScreen);
    }
}