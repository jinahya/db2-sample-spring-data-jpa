package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class ProductSupplier_Randomizer extends __MappedEntity_Randomizer<ProductSupplier> {

    ProductSupplier_Randomizer() {
        super(ProductSupplier.class);
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
    ProductSupplier get() {
        return super.get();
    }
}