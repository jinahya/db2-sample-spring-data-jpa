package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class Project_Test extends __MappedEntity_Test<Project, String> {

    Project_Test() {
        super(Project.class, String.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Project> equalsVerifier() {
        return super.equalsVerifier()
                .withPrefabValues(
                        MappedDepartment.class,
                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "11"),
                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "12")
                )
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "11"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "12")
                )
                .withPrefabValues(
                        MappedProject.class,
                        (MappedProject<?, ?, ?>) __MappedEntity.of_id_(Project::new, "11"),
                        (MappedProject<?, ?, ?>) __MappedEntity.of_id_(Project::new, "12")
                )
                ;
    }
}