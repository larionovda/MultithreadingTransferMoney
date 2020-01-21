package com.larionov.epam.controller;

import java.util.concurrent.ExecutorService;

public interface FinishThreads {
    void shutdownAndAwaitTermination(ExecutorService pool);
}
