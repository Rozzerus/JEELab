package com.rozzer.manager;

import com.rozzer.common.Saved;

import java.math.BigInteger;
import java.util.List;

public interface Manager<T extends Saved> {
    List<T> getAll();
    void save(T book);
    void delete(T book);
    T getById(BigInteger id);
    T create();
}
