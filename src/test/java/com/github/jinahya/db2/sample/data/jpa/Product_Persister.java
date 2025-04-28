package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Product_Persister extends __MappedEntity_Persister<Product> {

    Product_Persister() {
        super(Product.class);
    }

    @Override
    Product persist(final EntityManager entityManager, final Product entityInstance) {
        return super.persist(entityManager, entityInstance);
    }
}