package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class Supplier_Randomizer extends __MappedEntity_Randomizer<Supplier> {

    Supplier_Randomizer() {
        super(Supplier.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    DataProviderStrategy strategy() {
        return super.strategy();
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Supplier get() {
        return super.get();
    }
}