package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class EmpPhoto_Test extends __MappedEntity_Test<EmpPhoto, EmpPhotoId> {

    EmpPhoto_Test() {
        super(EmpPhoto.class, EmpPhotoId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    protected SingleTypeEqualsVerifierApi<EmpPhoto> equalsVerifier() {
        return super.equalsVerifier()
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
                );
    }
}