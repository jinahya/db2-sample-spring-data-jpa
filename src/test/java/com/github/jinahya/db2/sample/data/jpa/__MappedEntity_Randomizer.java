package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.data.util.BeanValidationTestUtils;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategyImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//abstract class __MappedEntity_Randomizer<T extends __MappedEntity<T, ?>> {
abstract class __MappedEntity_Randomizer<ENTITY extends __MappedEntity<ENTITY, ?>> extends ___Base_Randomizer<ENTITY> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance for generating randomized instance of specified entity class.
     *
     * @param entityClass the entity class.
     */
    __MappedEntity_Randomizer(final Class<ENTITY> entityClass) {
        super(entityClass);
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    DataProviderStrategy strategy() {
        return new RandomDataProviderStrategyImpl()
                ;
    }

    PodamFactory factory() {
        return new PodamFactoryImpl(strategy());
    }

    ENTITY get() {
        final var value = factory().manufacturePojo(valueClass);
//        BeanValidationTestUtils.requireValid(value);
        return value;
    }

    // ----------------------------------------------------------------------------------------------------- entityClass
    Class<? super ENTITY> superclassDeclaring(final String attributeName) {
        return declaringClasses.computeIfAbsent(attributeName, k -> {
            for (Class<? super ENTITY> c = entityClass; c != null; c = c.getSuperclass()) {
                try {
                    c.getDeclaredField(k);
                    return c;
                } catch (final NoSuchFieldException nsfe) {
                    continue;
                }
            }
            throw new IllegalArgumentException("no declaring class for '" + attributeName + "'");
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;

    private final Map<String, Class<? super ENTITY>> declaringClasses = new HashMap<>();
}