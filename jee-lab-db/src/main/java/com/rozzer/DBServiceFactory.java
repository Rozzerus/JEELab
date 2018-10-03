package com.rozzer;


import com.google.common.collect.Maps;
import com.rozzer.common.Saved;
import com.rozzer.manager.EntityService;
import com.rozzer.manager.ServiceFactory;

import java.util.Map;

public class DBServiceFactory implements ServiceFactory {

    private Map<Class<? extends Saved>, EntityService> managers = Maps.newHashMap();

    public <U extends Saved> EntityService<U> service(Class<U> clazz) {
        return managers.get(clazz);
    }

    public void register(Class<? extends Saved> clazz, EntityService manager) {
        managers.put(clazz, manager);
    }
}
