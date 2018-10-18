package com.rozzer.manager;

import com.rozzer.common.Saved;

public interface ServiceFactory {
    <U extends Saved> EntityService service(Class<U> clazz);
    void register(Class<? extends Saved> clazz, EntityService manager);
}
