package com.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

       // List<Account> accountList = new ArrayList<>();
        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        savingsAccounts.add(new SavingsAccount(11));
        anotherMethod(savingsAccounts);

        List<CurrentAccount> currentAccounts = new ArrayList<>();
        addAccount(currentAccounts);

        List<Account> accounts = new ArrayList<>();
        addAccount(accounts);
    }

    private static void anotherMethod(List<? extends Account> accounts) {

        //accounts.add(new SavingsAccount(100));
        //accounts.add(new CurrentAccount(200));
        System.out.println(accounts.get(0).getBalance());
    }

    private static void addAccount(List<? super CurrentAccount> accounts) {
        accounts.add(new CurrentAccount(100));
        accounts.add(new CurrentAccount(200));
    }

}
