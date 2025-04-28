package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class EmpResume_Persister extends __MappedEntity_Persister<EmpResume> {

    EmpResume_Persister() {
        super(EmpResume.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    EmpResume persist(final EntityManager entityManager, final EmpResume entityInstance) {
        entityInstance.setEmployee(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}