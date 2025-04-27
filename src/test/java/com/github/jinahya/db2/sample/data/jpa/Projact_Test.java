package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Id;
import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

public class Projact_Test extends __MappedEntity_Test<Projact, ProjactId> {

    Projact_Test() {
        super(Projact.class, ProjactId.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Projact> equalsVerifier() {
        return super.equalsVerifier()
                .withIgnoredAnnotations(Id.class)
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