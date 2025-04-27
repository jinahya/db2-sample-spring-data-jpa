package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Project_Persister extends __MappedEntity_Persister<Project> {

    Project_Persister() {
        super(Project.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    Project persist(final EntityManager entityManager, final Project entityInstance) {
        entityInstance.setDept(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager)
        );
        entityInstance.setRespemp(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager)
        );
        entityInstance.setMajproj(null);
        return super.persist(entityManager, entityInstance);
    }
}