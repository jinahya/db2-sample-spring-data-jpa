package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

public class Projact_Persister extends __MappedEntity_Persister<Projact> {

    Projact_Persister() {
        super(Projact.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Projact persist(final EntityManager entityManager, final Projact entityInstance) {
        entityInstance.setProj(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Project.class, entityManager)
        );
        entityInstance.setAct(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Act.class, entityManager)
        );
        return super.persist(entityManager, entityInstance);
    }
}