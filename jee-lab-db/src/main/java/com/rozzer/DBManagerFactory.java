package com.rozzer;


import com.rozzer.common.Saved;
import com.rozzer.manager.Manager;
import com.rozzer.manager.ManagerFactory;

public class DBManagerFactory implements ManagerFactory {

    public void init() {

    }

    public <U extends Saved> Manager<U> getManager(Class<U> clazz) {
        return null;
    }

    public void register(Class<? extends Saved> clazz, Manager manager) {

    }
}
