package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.data.util.HibernateTestUtils;
import com.github.jinahya.db2.sample.data.util.JdbcTestUtils;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.MappingMetamodel;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class ___MappedEntity_SpringBootIT<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable> {

    ___MappedEntity_SpringBootIT(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void doOnPostConstruct() {

    }

    // ----------------------------------------------------------------------------------------------------- entityClass
    ENTITY newRandomizedEntityInstance() {
        try {
            return __MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
        } catch (final Exception e) {
            log.error("failed to get a randomized instance of " + entityClass, e);
            return null;
        }
    }

    // ------------------------------------------------------------------------------------------------------ entityName
    String entityName() {
        if (entityName == null) {
            final var entityType = entityManager().getMetamodel().entity(entityClass);
            entityName = entityType.getName();
        }
        return entityName;
    }

    // ------------------------------------------------------------------------------------------------- entityTableName
    String jdbcTableName() {
        if (entityTableName == null) {
            final var field = ReflectionUtils.findField(entityClass, "TABLE_NAME", String.class);
            if (field != null) {
                if (!field.canAccess(null)) {
                    field.setAccessible(true);
                }
                try {
                    return entityTableName = (String) field.get(null);
                } catch (final IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return entityTableName;
    }

    // --------------------------------------------------------------------------------------------------------- idClass

    // --------------------------------------------------------------------------------------------------- entityManager
    <R> R applyEntityManager(final Function<? super EntityManager, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(entityManager());
    }

    void acceptEntityManager(final Consumer<? super EntityManager> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        applyEntityManager(tem -> {
            consumer.accept(tem);
            return null;
        });
    }

    <R> R applyUnwrappedSession(final Function<? super Session, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return applyEntityManager(em -> function.apply(em.unwrap(Session.class)));
    }

    <R> R acceptUnwrappedSession(final Consumer<? super Session> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return applyUnwrappedSession(s -> {
            consumer.accept(s);
            return null;
        });
    }

    // ------------------------------------------------------------------------------------------------------ dataSource
    <R> R applyConnection(final Function<? super Connection, ? extends R> function) throws SQLException {
        Objects.requireNonNull(function, "function is null");
        try (var connection = dataSource.getConnection()) {
            return function.apply(connection);
        }
    }

    void acceptConnection(final Consumer<? super Connection> consumer) throws SQLException {
        Objects.requireNonNull(consumer, "consumer is null");
        applyConnection(c -> {
            consumer.accept(c);
            return null;
        });
    }

    // ------------------------------------------------------------------------------------------------- jdbcColumnNames
    List<String> jdbcColumnNames() throws SQLException {
        if (jdbcColumnNames == null) {
            jdbcColumnNames = applyConnection(c -> {
                try {
                    return JdbcTestUtils.getAllColumnNames(c, jpaTableName());
                } catch (final SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
            });
        }
        assertThat(jdbcColumnNames).isNotEmpty();
        return jdbcColumnNames.stream()
                .distinct()
                .map(String::toUpperCase)
                .toList();
    }

    // -------------------------------------------------------------------------------------------------- sessionFactory
    <R> R applyMappingMetamodel(final Function<? super MappingMetamodel, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply((MappingMetamodel) sessionFactory.getMetamodel());
    }

    <R> R applyEntityPersister(final Function<? super EntityPersister, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return applyMappingMetamodel(mm -> function.apply(mm.getEntityDescriptor(entityClass)));
    }

    // ------------------------------------------------------------------------------------------------- entityTableName
    String jpaTableName() {
        if (jpaTableName == null) {
            jpaTableName = applyEntityPersister(ep -> {
                return ((AbstractEntityPersister) ep).getRootTableName();
            }).toUpperCase();
        }
        return jpaTableName;
    }

    // ----------------------------------------------------------------------------------------------- entityColumnNames
    List<String> jpaColumnNames() {
        if (jpaColumnNames == null) {
            jpaColumnNames = HibernateTestUtils.getAllColumnNames(sessionFactory, entityClass)
                    .distinct()
                    .map(String::toUpperCase)
                    .toList();
        }
        assertThat(jpaColumnNames).isNotEmpty();
        return jpaColumnNames;
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;

    final Class<ID> idClass;

    // -----------------------------------------------------------------------------------------------------------------
    private String entityName;

    private String entityTableName;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter
    private EntityManager entityManager;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter
    private DataSource dataSource;

    private List<String> jdbcColumnNames;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter
    private SessionFactory sessionFactory;

    private String jpaTableName;

    private List<String> jpaColumnNames;
}