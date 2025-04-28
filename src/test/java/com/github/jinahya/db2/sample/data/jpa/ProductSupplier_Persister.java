package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class ProductSupplier_Persister extends __MappedEntity_Persister<ProductSupplier> {

    ProductSupplier_Persister() {
        super(ProductSupplier.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    ProductSupplier persist(final EntityManager entityManager, final ProductSupplier entityInstance) {
        entityInstance.setProduct(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Product.class, entityManager)
        );
        entityInstance.setSupplier(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Supplier.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}