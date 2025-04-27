package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Id;
import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class Empprojact_Test extends __MappedEntity_Test<Empprojact, EmpprojactId> {

    Empprojact_Test() {
        super(Empprojact.class, EmpprojactId.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Empprojact> equalsVerifier() {
        return super.equalsVerifier()
                .withIgnoredAnnotations(Id.class)
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
                )
                .withPrefabValues(
                        MappedProject.class,
                        (MappedProject<?, ?, ?>) __MappedEntity.of_id_(Project::new, "1"),
                        (MappedProject<?, ?, ?>) __MappedEntity.of_id_(Project::new, "2")
                )
                .withPrefabValues(
                        MappedAct.class,
                        (MappedAct<?>) __MappedEntity.of_id_(Act::new, 1),
                        (MappedAct<?>) __MappedEntity.of_id_(Act::new, 2)
                )
                ;
    }
}