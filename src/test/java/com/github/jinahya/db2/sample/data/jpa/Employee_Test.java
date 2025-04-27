package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class Employee_Test extends __MappedEntity_Test<Employee, String> {

    Employee_Test() {
        super(Employee.class, String.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Employee> equalsVerifier() {
        return super.equalsVerifier()
//                .withPrefabValues(
//                        MappedDepartment.class,
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "1"),
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "2")
//                )
                ;
    }
}