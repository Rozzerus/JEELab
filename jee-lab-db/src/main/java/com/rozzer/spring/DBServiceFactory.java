package com.rozzer.spring;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.rozzer.common.Saved;
import com.rozzer.manager.Service;
import com.rozzer.manager.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DBServiceFactory implements ServiceFactory {

    private List<Service<? extends Saved>> objectManagersBeans;
    private HashMap<Type, Service> objectManagers = Maps.newHashMapWithExpectedSize(9);



    @Autowired
    public void setObjectManagersBeans(List<Service<? extends Saved>> objectManagersBeans) {
        this.objectManagersBeans = objectManagersBeans;
    }

    public <U extends Saved> Service<U> getManager(Class<U> clazz) {
        Service manager = objectManagers.get(clazz);
        if (manager == null) {
            manager = findManager(Lists.newArrayList(new ObjManTypesafeGarant(clazz), new ObjManTypesafeGarant2(clazz)).iterator());
            objectManagers.put(clazz, manager);
        }
        return manager;
    }

    public void register(Class<? extends Saved> clazz, Service manager) {
        objectManagers.put(clazz, manager);
    }

    /**
     * finds manager by predicate
     *
     * @param typesafeGarants should check if manager can be casted to ObjectManager<T>
     * @param <T>
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    private <T extends Saved> Service<T> findManager(@Nonnull Iterator<Predicate<Service>> typesafeGarants) {
        Set<Service<? extends Saved>> candidates = null;
        Predicate<Service> typesafeGarant = null;
        while (CollectionUtils.isEmpty(candidates) && typesafeGarants.hasNext()) {
            typesafeGarant = typesafeGarants.next();
            candidates = objectManagersBeans.stream().filter(typesafeGarant).collect(Collectors.toSet());
        }
        if (CollectionUtils.isEmpty(candidates))
            throw new RuntimeException(String.format("Object manager '%s' not found. Available managers: %s", typesafeGarant, objectManagersBeans));
        if (candidates.size() > 1)
            throw new RuntimeException(String.format("Got multiple candidates for '%s'. Candidates are: %s", typesafeGarant, candidates));
        Service<? extends Saved> found = candidates.iterator().next();
        try {
            return (Service<T>) found;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Typesafe garant '%s' assumes that '%s' has proper type. But it has not", typesafeGarant, found), e);
        }
    }


    private static class ObjManTypesafeGarant implements Predicate<Service> {

        private final Type storableType;

        private ObjManTypesafeGarant(Type type) {
            this.storableType = type;
        }

        @Override
        public boolean test(Service input) {
            Type managersGenericType = TypeToken.of(input.getClass())
                    .resolveType(Service.class.getTypeParameters()[0]).getType();
            return storableType.equals(managersGenericType);
        }

        @Override
        public String toString() {
            return String.format("%s<%s>", Service.class.getSimpleName(), storableType);
        }
    }

    private static class ObjManTypesafeGarant2 implements Predicate<Service> {

        private final Type storableType;

        private ObjManTypesafeGarant2(Type type) {
            this.storableType = type;
        }

        @Override
        public boolean test(Service input) {
            return TypeToken.of(input.getClass())
                    .resolveType(Service.class.getTypeParameters()[0]).isSupertypeOf(storableType);
        }

        @Override
        public String toString() {
            return String.format("%s<? extends %s>", Service.class.getSimpleName(), storableType);
        }
    }
}
