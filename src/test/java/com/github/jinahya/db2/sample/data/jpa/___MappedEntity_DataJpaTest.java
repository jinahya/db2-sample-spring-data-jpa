package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class ___MappedEntity_DataJpaTest<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable> {

    ___MappedEntity_DataJpaTest(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Transactional
    @Test
    void persist() {
        final var persisted = applyEntityManager(
                em -> __MappedEntity_Persister_Utils.newPersistedInstanceOf(entityClass, em)
        );
        log.debug("persisted: {}", persisted);
        final var selected = applyEntityManager(em -> em.find(entityClass, persisted._id_()));
        log.debug("selected: {}", selected);
        assertThat(selected).isEqualTo(persisted);
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

    // --------------------------------------------------------------------------------------------------------- idClass

    // ----------------------------------------------------------------------------------------------- testEntityManager
    <R> R applyTestEntityManager(final Function<? super TestEntityManager, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(testEntityManager());
    }

    void acceptTestEntityManager(final Consumer<? super TestEntityManager> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        applyTestEntityManager(tem -> {
            consumer.accept(tem);
            return null;
        });
    }

    <R> R applyEntityManager(final Function<? super EntityManager, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return applyTestEntityManager(tem -> function.apply(tem.getEntityManager()));
    }

    void acceptEntityManager(final Consumer<? super EntityManager> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        applyEntityManager(r -> {
            consumer.accept(r);
            return null;
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;

    final Class<ID> idClass;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter
    private TestEntityManager testEntityManager;
}