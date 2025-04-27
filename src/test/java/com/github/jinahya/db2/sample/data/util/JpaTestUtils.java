package com.github.jinahya.db2.sample.data.util;

import jakarta.persistence.EntityManager;

public final class JpaTestUtils {

    public static long count(final EntityManager entityManager, final Class<?> entityClass) {
        final var builder = entityManager.getCriteriaBuilder();
        final var query = builder.createQuery(Long.class);
        final var root = query.from(entityClass);
        query.select(builder.count(root));
        final var typed = entityManager.createQuery(query);
        return typed.getSingleResult();
    }

    private JpaTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
