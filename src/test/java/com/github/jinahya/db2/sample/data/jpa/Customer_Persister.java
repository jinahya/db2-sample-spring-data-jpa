package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Customer_Persister extends __MappedEntity_Persister<Customer> {

    Customer_Persister() {
        super(Customer.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Customer persist(final EntityManager entityManager, final Customer entityInstance) {
        return super.persist(entityManager, entityInstance);
    }
}