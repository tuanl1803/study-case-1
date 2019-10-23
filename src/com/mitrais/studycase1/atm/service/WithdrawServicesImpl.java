package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.SummaryScreen;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WelcomeScreen;
import com.mitrais.studycase1.atm.view.WithdrawScreen;

import java.util.List;

public class WithdrawServicesImpl implements WithdrawServices {

    @Override
    public void caculateWithdrawAmount(List<Account> accounts, String accountNumber, String pin,
                                       SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (WelcomeScreen.accountNumber.equals(accounts.get(i).getAccountNumber())
                    && WelcomeScreen.pin.equals(accounts.get(i).getPIN()) && accounts.get(i).getBalance() >= amount) {
                int temp = accounts.get(i).getBalance();
                accounts.get(i).setBalance(temp - amount);
                WelcomeScreen.balance = accounts.get(i).getBalance();
                summaryScreen.show(accounts);
            } else if (accounts.get(i).getBalance() < amount) {
                System.out.println("Insufficient balance $" + amount);
                transactionScreen.show(accounts);
            }
        }

    }

    @Override
    public void validateAndCalculateWithdrawAmount(String amount, List<Account> accounts,
                                                   WithdrawScreen withdrawScreen, SummaryScreen summaryScreen) {
        String regex = "[0-9]+";
        if (!amount.matches(regex)) {
            System.out.println("Only Number Allowed");
            withdrawScreen.show(accounts);
        } else if (Integer.parseInt(amount) % 10 != 0) {
            System.out.println("Invalid ammount");
            withdrawScreen.show(accounts);
        } else if (Integer.parseInt(amount) > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            withdrawScreen.show(accounts);
        } else if (WelcomeScreen.balance - Integer.parseInt(amount) < 0) {
            System.out.println("Insufficient balance $" + amount);
            withdrawScreen.show(accounts);
        } else {
            // calculate and set balance
            for (int i = 0; i < accounts.size(); i++) {
                if (WelcomeScreen.accountNumber.equals(accounts.get(i).getAccountNumber())
                        && WelcomeScreen.pin.equals(accounts.get(i).getPIN())) {
                    accounts.get(i).setBalance(WelcomeScreen.balance - Integer.parseInt(amount));
                    WelcomeScreen.balance -= Integer.parseInt(amount);
                    WithdrawScreen.withdrawAmount = "$" + amount;
                    summaryScreen.show(accounts);
                }
            }
        }

    }
}
