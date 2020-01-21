package com.larionov.epam.controller;

import java.util.List;

public interface Serialization<T> {
    void serialObjectsToFiles (List<T> list);
}
