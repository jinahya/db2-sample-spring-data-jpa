package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.data.util.BeanValidationTestUtils;
import com.github.jinahya.db2.sample.data.util.JpaTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

//@Transactional
@ContextConfiguration(classes = {
        __MappedEntity_SpringBootIT_Configuration.class
})
@SpringBootTest
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class __MappedEntity_SpringBootIT<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable>
        extends ___MappedEntity_SpringBootIT<ENTITY, ID> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    __MappedEntity_SpringBootIT(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super(entityClass, idClass);
    }

    __MappedEntity_SpringBootIT(final Class<ENTITY> entityClass) {
        super(entityClass, __MappedEntityUtils.resolveIdClass(entityClass));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void unmappedJdbcColumns() throws Exception {
        final var jdbcColumnNames = new ArrayList<>(jdbcColumnNames());
        log.debug("jdbcColumnNames: {}", jdbcColumnNames);
        final var jpaColumnNames = jpaColumnNames();
        log.debug("jpaColumnNames: {}", jpaColumnNames);
        jdbcColumnNames.removeAll(jpaColumnNames());
        // -----------------------------------------------------------------------------------------------------------------
        assertThat(jdbcColumnNames)
                .as("JDBC column names that all JPA column names are removed")
                .isEmpty();
    }

    @Test
    void unmappedJpaColumns() throws SQLException {
        // -------------------------------------------------------------------------------------------------------------
        final var jpaColumnNames = new ArrayList<>(jpaColumnNames());
        log.debug("jpaColumnNames: {}", jpaColumnNames);
        final var jdbcColumnNames = jdbcColumnNames();
        log.debug("jdbcColumnNames: {}", jdbcColumnNames);
        // -------------------------------------------------------------------------------------------------------------
        jpaColumnNames.removeAll(jdbcColumnNames);
        // -------------------------------------------------------------------------------------------------------------
        assertThat(jpaColumnNames)
                .as("JPA column names that all JDBC column names are removed")
                .isEmpty();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void persistRandom__() {
        final var persistedInstance =
                __MappedEntity_Persister_Utils.newPersistedInstanceOf(entityClass, entityManager());
        log.debug("e: {}", persistedInstance);
        BeanValidationTestUtils.requireValid(persistedInstance);
    }

    @Test
//    @RepeatedTest(128)
    void selectRandom__() {
        final var query = entityManager().createQuery("SELECT e FROM %s AS e".formatted(entityName()), entityClass);
        final long offset;
        {
            final var count = JpaTestUtils.count(entityManager(), entityClass);
            log.debug("count: {}", count);
            assumeThat(count).isPositive();
            offset = ThreadLocalRandom.current().nextLong(count);
            log.debug("offset: {}", offset);
        }
        query.setFirstResult(Math.toIntExact(offset));
        query.setMaxResults(1);
        final var list = query.getResultList();
        list.forEach(e -> {
            log.debug("e: {}", e);
            BeanValidationTestUtils.requireValid(e);
        });
    }
}