package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;

import java.util.List;
import java.util.Scanner;

public class TransactionScreen {

    public void show(List<Account> accounts) {

        WithdrawScreen withdrawScreen = new WithdrawScreen();
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        FundTransferScreen1 fundTransferScreen = new FundTransferScreen1();

        System.out.println();
        System.out.println("Transaction Screen");
        System.out.println("----------------");

        System.out.println("1. Withdraw ");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit ");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {

            case "1":
                withdrawScreen.show(accounts);
                break;
            case "2":
                fundTransferScreen.show(accounts);
                break;
            case "3":
            case "":
                welcomeScreen.show(accounts);
                break;
            default:
                show(accounts);
                break;
        }

    }

}
