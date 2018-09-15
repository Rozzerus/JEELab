package com.rozzer;


import com.rozzer.manager.Manager;
import com.rozzer.manager.ManagerFactory;
import com.rozzer.model.Book;

public class DBManagerFactory implements ManagerFactory {

    public <U extends Book> Manager<U> getManager(Class<U> clazz) {
        return null;
    }

    public void init() {

    }

    public void register(Class<? extends Book> clazz, Manager manager) {

    }
}
