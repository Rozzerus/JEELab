package com.rozzer.controller.common;

import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Film;

public class ControllerHelper {

    public static  <T extends Film> Manager<T> manager(Class<T> clazz){
        return CoreObjectManager.getInstance().getManager(clazz);
    }
}
