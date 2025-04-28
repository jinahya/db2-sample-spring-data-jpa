package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class Inventory_Randomizer extends __MappedEntity_Randomizer<Inventory> {

    Inventory_Randomizer() {
        super(Inventory.class);
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
    Inventory get() {
        return super.get();
    }
}