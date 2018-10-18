package com.rozzer.manager;

import com.rozzer.common.Saved;
import org.springframework.beans.factory.annotation.Autowired;

public class CoreServices {

    private static CoreServices instance = new CoreServices();

    public static CoreServices getInstance() {
        return instance;
    }

    private ServiceFactory serviceFactory;

    @Autowired
    public static void setServiceFactory(ServiceFactory factory) {
        instance.serviceFactory = factory;
    }

    public static ServiceFactory getServiceFactory() {
        return instance.serviceFactory;
    }

    public static <T extends Saved> EntityService<T> serviceFor(Class<T> clazz){
        return instance.service(clazz);
    }

    private CoreServices() {
    }

    public <T extends Saved> EntityService<T> service(Class<T> clazz){
        return serviceFactory.service(clazz);
    }
}
