package com.rozzer.controller.common;

import com.rozzer.manager.CoreServices;
import com.rozzer.manager.Service;
import com.rozzer.model.Book;

public class ControllerHelper {

    public static  <T extends Book> Service<T> manager(Class<T> clazz){
        return CoreServices.getInstance().getManager(clazz);
    }
}
