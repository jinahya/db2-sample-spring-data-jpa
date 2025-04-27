package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class __MappedEntity_Persister_Utils {

    private static final Map<Class<?>, __MappedEntity_Persister<?>> PERSISTER_INSTANCES = new ConcurrentHashMap<>();

    @SuppressWarnings({
            "unchecked"
    })
    static <T extends __MappedEntity<T, ?>>
    __MappedEntity_Persister<T> getPersisterInstance(final Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        return (__MappedEntity_Persister<T>) PERSISTER_INSTANCES.computeIfAbsent(entityClass, k -> {
            final var persisterName = entityClass.getName() + "_Persister";
            final Class<?> persisterClass;
            try {
                persisterClass = Class.forName(persisterName);
            } catch (final ClassNotFoundException cnfe) {
                throw new RuntimeException("failed to find persister class for " + persisterName, cnfe);
            }
            final Constructor<?> constructor;
            try {
                constructor = persisterClass.getDeclaredConstructor();
            } catch (final NoSuchMethodException nsme) {
                throw new RuntimeException("failed to get constructor of " + persisterClass, nsme);
            }
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            final __MappedEntity_Persister<?> persister;
            try {
                persister = (__MappedEntity_Persister<?>) constructor.newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException("failed to get new instance with " + constructor, roe);
            }
            return persister;
        });
    }

    public static <T extends __MappedEntity<T, ?>>
    T newPersistedInstanceOf(final Class<T> entityClass, final EntityManager entityManager, final T entityInstance) {
        Objects.requireNonNull(entityManager, "entityManager is null");
        Objects.requireNonNull(entityInstance, "entityInstance is null");
        return getPersisterInstance(entityClass).persist(entityManager, entityInstance);
    }

    public static <T extends __MappedEntity<T, ?>>
    T newPersistedInstanceOf(final Class<T> entityClass, final EntityManager entityManager) {
        final var entityInstance = __MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
        return newPersistedInstanceOf(
                entityClass,
                entityManager,
                entityInstance
        );
    }

//    public static <T extends __MappedEntity<T, ?>>
//    T newPersistedInstanceOf(final Class<T> entityClass, final TestEntityManager testEntityManager,
//                             final T entityInstance) {
//        Objects.requireNonNull(testEntityManager, "testEntityManager is null");
//        Objects.requireNonNull(entityInstance, "entityInstance is null");
//        return getPersisterInstance(entityClass).persist(testEntityManager, entityInstance);
//    }
//
//    public static <T extends __MappedEntity<T, ?>>
//    T newPersistedInstanceOf(final Class<T> entityClass, final TestEntityManager testEntityManager) {
//        final var entityInstance = __MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
//        return newPersistedInstanceOf(
//                entityClass,
//                testEntityManager,
//                entityInstance
//        );
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private __MappedEntity_Persister_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}