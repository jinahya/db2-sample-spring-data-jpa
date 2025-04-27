package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;
import org.junit.jupiter.api.Disabled;

@Disabled
class Project_Test extends __MappedEntity_Test<Project, String> {

    Project_Test() {
        super(Project.class, String.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Project> equalsVerifier() {
        return super.equalsVerifier()
//                .withIgnoredFields("dept", "respemp")
//                .withPrefabValues(
//                        MappedDepartment.class,
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "1"),
//                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "2")
//                )
////                .withPrefabValues(
////                        Department.class,
////                        (Department) __MappedEntity.of_id_(Department::new, "1"),
////                        (Department) __MappedEntity.of_id_(Department::new, "2")
////                )
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
                )
                ;
    }
}