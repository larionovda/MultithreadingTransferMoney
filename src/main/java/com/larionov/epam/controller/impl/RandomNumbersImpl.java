package com.larionov.epam.controller.impl;

import com.larionov.epam.controller.RandomNumbers;
import static java.lang.Math.random;

public class RandomNumbersImpl implements RandomNumbers {

    @Override
    public int getRandomNumberForAccount(int max) {
        return (int) (random() * max);
    }

    @Override
    public Long getRandomNumberForBalance(Long max) {
        return (long) (random() * ++max);
    }
}
