package com.larionov.epam.controller.impl;

import com.larionov.epam.entity.Account;
import com.larionov.epam.controller.Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationImpl implements Serialization<Account> {

    @Override
    public void serialObjectsToFiles(List<Account> list) {
        for (int i = 0; i < 10; i++) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserAccounts/DataAccount" + i))) {
                oos.writeObject(list.get(i));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
