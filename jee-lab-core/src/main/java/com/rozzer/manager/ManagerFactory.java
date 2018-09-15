package com.rozzer.manager;

import com.rozzer.model.Book;

public interface ManagerFactory {
    <U extends Book> Manager<U> getManager(Class<U> clazz);
    void init();
    void register(Class<? extends Book> clazz, Manager manager);
}
