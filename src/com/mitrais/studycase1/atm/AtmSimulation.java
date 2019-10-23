package com.mitrais.studycase1.atm;

import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.WelcomeScreen;

import java.util.ArrayList;
import java.util.List;

public class AtmSimulation {

    public static void main(String[] args) {
	// write your code here
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John Doe", "012108", 100, "112233"));
        accounts.add(new Account("Jane Doe", "932012", 30, "112244"));

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        while (true) {
            welcomeScreen.show(accounts);
        }
    }
}
