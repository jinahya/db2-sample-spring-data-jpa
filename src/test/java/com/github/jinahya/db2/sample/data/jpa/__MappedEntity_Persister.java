package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

import java.util.Objects;

abstract class __MappedEntity_Persister<ENTITY extends __MappedEntity<ENTITY, ?>> {

    __MappedEntity_Persister(final Class<ENTITY> entityClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
    }

    ENTITY persist(final EntityManager entityManager, final ENTITY entityInstance) {
        entityManager.persist(entityInstance);
//        entityManager.flush();
        return entityInstance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;
}