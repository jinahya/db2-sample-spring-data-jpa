package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class _MappedEntity_Persister_Utils {

    private static final Map<Class<?>, _MappedEntity_Persister<?>> PERSISTER_INSTANCES = new ConcurrentHashMap<>();

    @SuppressWarnings({
            "unchecked"
    })
    static <T extends _MappedEntity<T>>
    _MappedEntity_Persister<T> getPersisterInstance(final Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        return (_MappedEntity_Persister<T>) PERSISTER_INSTANCES.computeIfAbsent(entityClass, k -> {
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
            final _MappedEntity_Persister<?> persister;
            try {
                persister = (_MappedEntity_Persister<?>) constructor.newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException("failed to get new instance with " + constructor, roe);
            }
            return persister;
        });
    }

    public static <T extends _MappedEntity<T>>
    T newPersistedInstanceOf(final Class<T> entityClass, final EntityManager entityManager, final T entityInstance) {
        Objects.requireNonNull(entityManager, "entityManager is null");
        Objects.requireNonNull(entityInstance, "entityInstance is null");
        return getPersisterInstance(entityClass).persist(entityManager, entityInstance);
    }

    public static <T extends _MappedEntity<T>>
    T newPersistedInstanceOf(final Class<T> entityClass, final EntityManager entityManager) {
        final var entityInstance = _MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
//        BeanValidationTestUtils.requireValid(entityInstance);
        return newPersistedInstanceOf(
                entityClass,
                entityManager,
                entityInstance
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _MappedEntity_Persister_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}