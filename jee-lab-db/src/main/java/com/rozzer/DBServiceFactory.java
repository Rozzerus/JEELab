package com.rozzer;


import com.google.common.collect.Maps;
import com.rozzer.common.Saved;
import com.rozzer.manager.Service;
import com.rozzer.manager.ServiceFactory;

import java.util.Map;

public class DBServiceFactory implements ServiceFactory {

    private Map<Class<? extends Saved>, Service> managers = Maps.newHashMap();

    public <U extends Saved> Service<U> getManager(Class<U> clazz) {
        return managers.get(clazz);
    }

    public void register(Class<? extends Saved> clazz, Service manager) {
        managers.put(clazz, manager);
    }
}
