package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class PurchaseOrder_Randomizer extends __MappedEntity_Randomizer<PurchaseOrder> {

    PurchaseOrder_Randomizer() {
        super(PurchaseOrder.class);
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
    PurchaseOrder get() {
        return super.get();
    }
}