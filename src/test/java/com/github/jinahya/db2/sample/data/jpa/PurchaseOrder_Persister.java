package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class PurchaseOrder_Persister extends __MappedEntity_Persister<PurchaseOrder> {

    PurchaseOrder_Persister() {
        super(PurchaseOrder.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    PurchaseOrder persist(EntityManager entityManager, PurchaseOrder entityInstance) {
        entityInstance.setCustomer(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Customer.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}