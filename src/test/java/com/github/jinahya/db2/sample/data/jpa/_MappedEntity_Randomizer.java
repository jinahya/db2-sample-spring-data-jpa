package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategyImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class _MappedEntity_Randomizer<ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntity_Randomizer<ENTITY> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance for generating randomized instance of specified entity class.
     *
     * @param entityClass the entity class.
     */
    _MappedEntity_Randomizer(final Class<ENTITY> entityClass) {
        super(entityClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    DataProviderStrategy strategy() {
        return new RandomDataProviderStrategyImpl()
                .addOrReplaceAttributeStrategy(_MappedEntity.class, "id", (t, a) -> null)
                ;
    }

    @Override
    PodamFactory factory() {
        return new PodamFactoryImpl(strategy());
    }

    @Override
    ENTITY get() {
        final var value = factory().manufacturePojo(entityClass);
        assertThat(value.getId()).isNull();
        return value;
    }
}