package com.rozzer.manager;

import com.rozzer.common.Saved;

import java.util.List;

public interface EntityService<T extends Saved> {
    List<T> getAll();
    void save(T saved);
    void delete(T saved);
    T getById(Long id);
    T create();
}
