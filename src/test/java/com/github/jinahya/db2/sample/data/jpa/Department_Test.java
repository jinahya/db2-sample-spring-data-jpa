package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class Department_Test extends __MappedEntity_Test<Department, String> {

    Department_Test() {
        super(Department.class, String.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Department> equalsVerifier() {
        return super.equalsVerifier()
//                .withPrefabValues(
//                        MappedEmployee.class,
//                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
//                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
//                )
//                .withPrefabValues(
//                        MappedDepartment.class,
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "1"),
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "2")
//                )
        ;
    }
}