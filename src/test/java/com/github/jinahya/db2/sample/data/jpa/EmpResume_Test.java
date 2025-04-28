package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class EmpResume_Test extends __MappedEntity_Test<EmpResume, EmpResumeId> {

    EmpResume_Test() {
        super(EmpResume.class, EmpResumeId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    protected SingleTypeEqualsVerifierApi<EmpResume> equalsVerifier() {
        return super.equalsVerifier()
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
                );
    }
}