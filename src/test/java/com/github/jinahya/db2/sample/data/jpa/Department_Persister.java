package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Department_Persister extends __MappedEntity_Persister<Department> {

    Department_Persister() {
        super(Department.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Department persist(EntityManager entityManager, Department entityInstance) {
        entityInstance.setMgr(null);
        entityInstance.setAdmrdept(null);
        final var persisted = super.persist(entityManager, entityInstance);
        persisted.setAdmrdept(persisted);
        entityManager.merge(persisted);
        return persisted;
    }
}