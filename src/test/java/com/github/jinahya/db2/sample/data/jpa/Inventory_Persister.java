package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Inventory_Persister extends __MappedEntity_Persister<Inventory> {

    Inventory_Persister() {
        super(Inventory.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Inventory persist(final EntityManager entityManager, final Inventory entityInstance) {
        entityInstance.setProduct(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Product.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}