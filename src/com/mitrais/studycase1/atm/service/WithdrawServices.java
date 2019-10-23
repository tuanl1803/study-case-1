package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.SummaryScreen;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WithdrawScreen;

import java.util.List;

public interface WithdrawServices {

    // Withdraw Screen
    void caculateWithdrawAmount(List<Account> accounts, String accountNumber, String pin,
                                SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount);
    // Other Withdraw Screen

    void validateAndCalculateWithdrawAmount(String amount, List<Account> accounts,
                                            WithdrawScreen withdrawScreen, SummaryScreen summaryScreen);
}
