package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.data.util.BeanValidationTestUtils;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategyImpl;

import java.util.Objects;

abstract class ___Base_Randomizer<T> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance for generating randomized instance of specified entity class.
     *
     * @param valueClass the entity class.
     */
    ___Base_Randomizer(final Class<T> valueClass) {
        super();
        this.valueClass = Objects.requireNonNull(valueClass, "valueClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    DataProviderStrategy strategy() {
        return new RandomDataProviderStrategyImpl();
    }

    PodamFactory factory() {
        return new PodamFactoryImpl(strategy());
    }

    T get() {
        final var value = factory().manufacturePojo(valueClass);
        BeanValidationTestUtils.requireValid(value);
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<T> valueClass;
}