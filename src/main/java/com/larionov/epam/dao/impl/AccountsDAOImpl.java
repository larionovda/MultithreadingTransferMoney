package com.larionov.epam.dao.impl;

import com.larionov.epam.dao.AccountsDAO;
import com.larionov.epam.entity.Account;
import com.larionov.epam.repository.InitAccounts;

import java.util.List;

public class AccountsDAOImpl implements AccountsDAO {
    InitAccounts initAccounts = new InitAccounts();

    @Override
    public Account getAccount(int inex) {
        return initAccounts.getList().get(inex);
    }

    @Override
    public List<Account> getListAccounts() {
        return initAccounts.getList();
    }
}
