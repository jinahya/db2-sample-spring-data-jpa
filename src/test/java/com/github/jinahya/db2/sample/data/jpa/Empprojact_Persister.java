package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Empprojact_Persister extends __MappedEntity_Persister<Empprojact> {

    Empprojact_Persister() {
        super(Empprojact.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Empprojact persist(final EntityManager entityManager, final Empprojact entityInstance) {
        entityInstance.setEmp(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager)
        );
        entityInstance.setProj(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Project.class, entityManager)
        );
        entityInstance.setAct(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Act.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}