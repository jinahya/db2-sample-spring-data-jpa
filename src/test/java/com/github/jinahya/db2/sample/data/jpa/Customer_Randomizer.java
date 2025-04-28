package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class Customer_Randomizer extends __MappedEntity_Randomizer<Customer> {

    Customer_Randomizer() {
        super(Customer.class);
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
    Customer get() {
        return super.get();
    }
}