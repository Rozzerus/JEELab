package com.rozzer.manager;

import com.rozzer.common.Saved;
import org.springframework.beans.factory.annotation.Autowired;

public class CoreServices {

    private static CoreServices instance = new CoreServices();

    public static CoreServices getInstance() {
        return instance;
    }

    private ServiceFactory managerFactory;

    @Autowired
    public static void setServiceFactory(ServiceFactory factory) {
        instance.managerFactory = factory;
    }

    public static ServiceFactory getServiceFactory() {
        return instance.managerFactory;
    }

    private CoreServices() {
    }

    public void setManagerFactory(ServiceFactory factory) {
        this.managerFactory = factory;
    }

    public ServiceFactory getManagerFactory() {
        return managerFactory;
    }

    public <T extends Saved> EntityService<T> getManager(Class<T> clazz){
        return managerFactory.getManager(clazz);
    }
}
