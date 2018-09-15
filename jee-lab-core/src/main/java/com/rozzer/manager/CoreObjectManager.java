package com.rozzer.manager;

import com.rozzer.model.Book;

public class CoreObjectManager {

    private static CoreObjectManager instance = new CoreObjectManager();

    public static CoreObjectManager getInstance() {
        return instance;
    }

    private ManagerFactory managerFactory;

    private CoreObjectManager() {
    }

    public <T extends Book> Manager<T>  getManager(Class<T> clazz){
        return managerFactory.getManager(clazz);
    }
}
