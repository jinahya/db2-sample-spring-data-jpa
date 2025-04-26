package com.github.jinahya.db2.sample.data.jpa;

public final class _MappedEntity_Test_Utils {

    public static <ENTITY extends _MappedEntity<ENTITY>>
    ENTITY newEntityInstanceOf(final Class<ENTITY> entityClass) {
        return __MappedEntity_Test_Utils.newEntityInstanceOf(entityClass);
    }

    private _MappedEntity_Test_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}