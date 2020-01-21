package com.larionov.epam.repository;

import com.larionov.epam.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class InitAccounts {
    private List<Account> list = new ArrayList<>();

    public InitAccounts() {
        list.add(new Account("Andrey", 5000L));
        list.add(new Account("Pavel", 4000L));
        list.add(new Account("Ivan", 3000L));
        list.add(new Account("Oliver", 1000L));
        list.add(new Account("David", 500L));
        list.add(new Account("John", 2000L));
        list.add(new Account("Roman", 1500L));
        list.add(new Account("Bruce", 50000L));
        list.add(new Account("Nicolas", 50L));
        list.add(new Account("Maria", 100L));
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }
}
