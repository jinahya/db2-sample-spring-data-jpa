package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;

class Employee_Persister extends __MappedEntity_Persister<Employee> {

    Employee_Persister() {
        super(Employee.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    Employee persist(final EntityManager entityManager, final Employee entityInstance) {
        entityInstance.setWorkdept(null);
        return super.persist(entityManager, entityInstance);
    }
}