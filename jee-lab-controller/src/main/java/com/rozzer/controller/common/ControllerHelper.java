package com.rozzer.controller.common;

import com.rozzer.common.AbstractSaved;
import com.rozzer.manager.CoreServices;
import com.rozzer.manager.EntityService;

public class ControllerHelper {

    public static  <T extends AbstractSaved> EntityService<T> service(Class<T> clazz){
        return CoreServices.getInstance().service(clazz);
    }
}
