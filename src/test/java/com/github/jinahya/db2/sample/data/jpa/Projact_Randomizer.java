package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

public class Projact_Randomizer extends __MappedEntity_Randomizer<Projact> {

    Projact_Randomizer() {
        super(Projact.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    DataProviderStrategy strategy() {
        return super.strategy()
//                .addOrReplaceAttributeStrategy(
//                        entityClass, "acstaff", (t, a) -> null
//                )
//                .addOrReplaceAttributeStrategy(
//                        BigInteger.class, "acstaff", (t, a) -> null
//                )
                ;
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Projact get() {
        final var value = super.get();
        value.setAcstaff(null);
        return value;
    }
}