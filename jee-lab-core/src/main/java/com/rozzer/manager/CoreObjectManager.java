package com.rozzer.manager;

import com.rozzer.common.Saved;

public class CoreObjectManager {

    private static CoreObjectManager instance = new CoreObjectManager();

    public static CoreObjectManager getInstance() {
        return instance;
    }

    private ManagerFactory managerFactory;

    private CoreObjectManager() {
    }

    public <T extends Saved> Manager<T>  getManager(Class<T> clazz){
        return managerFactory.getManager(clazz);
    }
}
