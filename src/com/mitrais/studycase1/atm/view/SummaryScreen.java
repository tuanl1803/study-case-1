package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class SummaryScreen {

    public void show(List<Account> accounts) {

        TransactionScreen ts = new TransactionScreen();
        WelcomeScreen ws = new WelcomeScreen();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Summary Screen");
        System.out.println("----------------");
        System.out.println("Date : " + dtf.format(now));
        System.out.println("Withdraw: " + WithdrawScreen.withdrawAmount);
        System.out.println("Balance: $" + ws.balance);

        System.out.println("1. Transaction");
        System.out.println("2. Exit");

        int opt = scan.nextInt();
        switch (opt) {
            case 1:
                ts.show(accounts);
                break;
            case 2:
                ws.show(accounts);
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
