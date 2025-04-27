package com.github.jinahya.db2.sample.data.jpa;

abstract class _MappedEntity_Persister<ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntity_Persister<ENTITY> {

    _MappedEntity_Persister(final Class<ENTITY> entityClass) {
        super(entityClass);
    }
}