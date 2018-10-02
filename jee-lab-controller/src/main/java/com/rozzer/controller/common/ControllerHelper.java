package com.rozzer.controller.common;

import com.rozzer.manager.CoreServices;
import com.rozzer.manager.EntityService;
import com.rozzer.model.Book;

public class ControllerHelper {

    public static  <T extends Book> EntityService<T> manager(Class<T> clazz){
        return CoreServices.getInstance().getManager(clazz);
    }
}
