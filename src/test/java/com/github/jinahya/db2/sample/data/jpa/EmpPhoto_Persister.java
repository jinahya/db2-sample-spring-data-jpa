package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class EmpPhoto_Persister extends __MappedEntity_Persister<EmpPhoto> {

    EmpPhoto_Persister() {
        super(EmpPhoto.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    EmpPhoto persist(final EntityManager entityManager, final EmpPhoto entityInstance) {
        entityInstance.setEmployee(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}