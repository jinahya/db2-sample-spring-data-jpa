package com.github.jinahya.db2.sample.data.jpa;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class __MappedEntity_Randomizer_Utils {

    private static final Map<Class<?>, __MappedEntity_Randomizer<?>> RANDOMIZER_INSTANCES = new ConcurrentHashMap<>();

    @SuppressWarnings({
            "unchecked"
    })
    static <T extends __MappedEntity<T, ?>>
    __MappedEntity_Randomizer<T> getRandomizerInstance(final Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        return (__MappedEntity_Randomizer<T>) RANDOMIZER_INSTANCES.computeIfAbsent(entityClass, k -> {
            final var randomizerName = entityClass.getName() + "_Randomizer";
            final Class<?> randomizerClass;
            try {
                randomizerClass = Class.forName(randomizerName);
            } catch (final ClassNotFoundException cnfe) {
                throw new RuntimeException("failed to find randomizer class for " + randomizerName, cnfe);
            }
            final Constructor<?> constructor;
            try {
                constructor = randomizerClass.getDeclaredConstructor();
            } catch (final NoSuchMethodException nsme) {
                throw new RuntimeException("failed to get constructor of " + randomizerClass, nsme);
            }
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            final __MappedEntity_Randomizer<?> randomizer;
            try {
                randomizer = (__MappedEntity_Randomizer<?>) constructor.newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException("failed to get new instance with " + constructor, roe);
            }
            return randomizer;
        });
    }

    public static <T extends __MappedEntity<T, ?>> T newRandomizedInstanceOf(final Class<T> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        final T instance = getRandomizerInstance(entityClass).get();
//        BeanValidationTestUtils.requireValid(instance);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private __MappedEntity_Randomizer_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}