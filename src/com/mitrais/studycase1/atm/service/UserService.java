package com.mitrais.studycase1.atm.service;



import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.WelcomeScreen;

import java.util.List;

public interface UserService {

	// Welcome Screen
	public void validate(List<Account> users, String accountNumber, String pin);

	public void validateAccountNumber(String accountNumber, List<Account> users, WelcomeScreen welcomeScreen);

	public void validatePinNumber(String pin, List<Account> users, WelcomeScreen welcomeScreen);

}
