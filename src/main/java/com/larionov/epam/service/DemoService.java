package com.larionov.epam.service;

import java.util.concurrent.ExecutionException;

public interface DemoService {
    void service() throws ExecutionException, InterruptedException;
}
