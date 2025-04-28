package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Supplier_Persister extends __MappedEntity_Persister<Supplier> {

    Supplier_Persister() {
        super(Supplier.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    Supplier persist(final EntityManager entityManager, final Supplier entityInstance) {
        return super.persist(entityManager, entityInstance);
    }
}