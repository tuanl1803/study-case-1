package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.FundTransferScreen1;
import com.mitrais.studycase1.atm.view.TransactionScreen;

import java.util.List;

public interface FundTransferServices {

    // Fund Transfer Screen

    void inputDestinationAccount(List<Account> accounts);

    void inputAmountScreen(List<Account> accounts);

    void inputReferenceNumberScreen(List<Account> accounts);

    void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, List<Account> accounts);

    //Fund Transfer Summary Screen

    void transaction(TransactionScreen transactionScreen);

    boolean isExists(List<Account> accounts);

    void addAmountToDestination(List<Account> accounts);
}
