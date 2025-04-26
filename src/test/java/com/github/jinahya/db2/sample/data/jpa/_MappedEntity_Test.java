package com.github.jinahya.db2.sample.data.jpa;

public abstract class _MappedEntity_Test<ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntity_Test<ENTITY, Long> {

    protected _MappedEntity_Test(final Class<ENTITY> entityClass) {
        super(entityClass, Long.class);
    }
}