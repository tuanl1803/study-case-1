package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;

public interface AccountService {

    void verifyAccount(String accountNumber, String pin);

    boolean validateAccountNumber(String accountNumber);

    boolean validatePinNumber(String pin);

    Account getAccountByNumber(String accNumber);
}
