package com.github.jinahya.db2.sample.data.jpa;

import java.io.Serial;

public class ProjactId extends MappedProjactId<ProjactId> {

    @Serial
    private static final long serialVersionUID = 5024223928247904040L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    protected static ProjactId from(final Projact entity) {
        return from(entity, ProjactId::new);
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected ProjactId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
}