package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class Customer_Test extends __MappedEntity_Test<Customer, Long> {

    Customer_Test() {
        super(Customer.class, Long.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected SingleTypeEqualsVerifierApi<Customer> equalsVerifier() {
        return super.equalsVerifier();
    }
}