package com.larionov.epam.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Serializable {
    private String name;
    private long balance;
    private ReentrantLock reentrantLock;

    private final Lock lock = new ReentrantLock();

    public Account(String name, Long balance) {
        this.name = name;
        this.balance = balance;
        this.reentrantLock = new ReentrantLock();
    }

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }

    public void setReentrantLock(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public String getName() {
        return name;
    }

    public Long getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Account account = (Account) o;
//        return balance == account.balance &&
//                Objects.equals(name, account.name) &&
//                Objects.equals(reentrantLock, account.reentrantLock) &&
//                Objects.equals(lock, account.lock);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, balance, reentrantLock, lock);
//    }
}
