package com.larionov.epam;

import com.larionov.epam.service.DemoService;
import com.larionov.epam.service.impl.DemoServiceImpl;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DemoService service = new DemoServiceImpl();
        service.service();
    }
}
