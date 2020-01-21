package com.larionov.epam.dao;

import com.larionov.epam.entity.Account;

import java.util.List;

public interface AccountsDAO {
    Account getAccount(int index);
    List<Account> getListAccounts();
}
