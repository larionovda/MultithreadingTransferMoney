package com.larionov.epam.service.impl;

import com.larionov.epam.controller.FinishThreads;
import com.larionov.epam.controller.impl.DeserializationImpl;
import com.larionov.epam.controller.impl.FinishThreadsImpl;
import com.larionov.epam.controller.impl.RandomNumbersImpl;
import com.larionov.epam.controller.impl.SerializationImpl;
import com.larionov.epam.dao.AccountsDAO;
import com.larionov.epam.dao.impl.AccountsDAOImpl;
import com.larionov.epam.service.DemoService;
import com.larionov.epam.controller.Deserialization;
import com.larionov.epam.controller.RandomNumbers;
import com.larionov.epam.controller.Serialization;
import com.larionov.epam.thread.ThreadImpl;

import java.util.concurrent.*;

public class DemoServiceImpl implements DemoService {
    private static final int THREAD_POOL = 20;
    private static final int MAX_ACCOUNTS = 10;

    @Override
    public void service() throws ExecutionException, InterruptedException {
        FinishThreads finishThreads = new FinishThreadsImpl();
        RandomNumbers randomNumbers = new RandomNumbersImpl();
        System.out.println("starting data");
        AccountsDAO accountsDAO = new AccountsDAOImpl();
        Deserialization deserialization = new DeserializationImpl();
        Serialization<com.larionov.epam.entity.Account> serialization = new SerializationImpl();
        serialization.serialObjectsToFiles(accountsDAO.getListAccounts());
        deserialization.deSerialObjectFromFile();
        System.out.println("===================================================");

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new ThreadImpl(accountsDAO.getAccount(randomNumbers.getRandomNumberForAccount(MAX_ACCOUNTS)),
                    accountsDAO.getAccount(randomNumbers.getRandomNumberForAccount(MAX_ACCOUNTS))));
        }

       finishThreads.shutdownAndAwaitTermination(executorService);
    }
}
