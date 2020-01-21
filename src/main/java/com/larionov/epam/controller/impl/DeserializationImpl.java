package com.larionov.epam.controller.impl;

import com.larionov.epam.entity.Account;
import com.larionov.epam.controller.Deserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationImpl implements Deserialization {
    @Override
    public void deSerialObjectFromFile() {
        for (int i = 0; i < 10; i++){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserAccounts/DataAccount" + i))) {
                Account p = (Account) ois.readObject();
                System.out.printf("Name: %s, balance: %d \n", p.getName(), p.getBalance());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
