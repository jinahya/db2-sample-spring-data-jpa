package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Department_Persister extends __MappedEntity_Persister<Department> {

    Department_Persister() {
        super(Department.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Department persist(EntityManager entityManager, Department entityInstance) {
        entityInstance.setMgr(
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager)
        );
//        entityInstance.setAdmrdept(
//                ThreadLocalRandom.current().nextBoolean() ? entityInstance :
//                __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager)
//        );
        entityInstance.setAdmrdept(null);
        return super.persist(entityManager, entityInstance);
    }
}