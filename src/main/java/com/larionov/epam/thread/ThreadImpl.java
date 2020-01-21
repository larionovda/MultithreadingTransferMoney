package com.larionov.epam.thread;

import com.larionov.epam.controller.impl.RandomNumbersImpl;
import com.larionov.epam.entity.Account;
import com.larionov.epam.controller.RandomNumbers;

import java.util.concurrent.TimeUnit;

public class ThreadImpl implements Runnable {

    private static final long MAX_VALUE_FOR_TRANSFER = 500L;
    private Account account;
    private Account account2;
    private RandomNumbers randomNumbers;

    public ThreadImpl(Account account, Account account2) {
        this.account = account;
        this.account2 = account2;
        this.randomNumbers = new RandomNumbersImpl();
    }

    @Override
    public void run() {
        if (account2 != account) {
            account.getReentrantLock().lock();
            account2.getReentrantLock().lock();
            long randomBalanceForWithdraw = randomNumbers.getRandomNumberForBalance(MAX_VALUE_FOR_TRANSFER);
            long randomBalanceForWithdraw2 = randomNumbers.getRandomNumberForBalance(MAX_VALUE_FOR_TRANSFER);
            if (account.getBalance() > randomBalanceForWithdraw && account2.getBalance() > randomBalanceForWithdraw2) {
                account.setBalance(account.getBalance() + randomBalanceForWithdraw2 - randomBalanceForWithdraw);
                account2.setBalance(account2.getBalance() + randomBalanceForWithdraw - randomBalanceForWithdraw2);
                System.out.println(Thread.currentThread().getName() + ": " + account.getName() + " , " + account.getBalance() + " <--> " + account2.getName() + " , " + account2.getBalance());
            } else {
                System.out.println("insufficient funds");
            }
            account.getReentrantLock().unlock();
            account2.getReentrantLock().unlock();
        }
    }
}
