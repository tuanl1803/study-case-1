package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.WelcomeScreen;

import java.util.List;

public interface AccountServices {

    // Welcome Screen
    void validate(List<Account> accounts, String accountNumber, String pin);

    void validateAccountNumber(String accountNumber, List<Account> accounts, WelcomeScreen welcomeScreen);

    void validatePinNumber(String pin, List<Account> accounts, WelcomeScreen welcomeScreen);

}
