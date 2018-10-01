package com.rozzer.manager;

import com.rozzer.common.Saved;

public interface ServiceFactory {
    <U extends Saved> Service getManager(Class<U> clazz);
    void register(Class<? extends Saved> clazz, Service manager);
}
