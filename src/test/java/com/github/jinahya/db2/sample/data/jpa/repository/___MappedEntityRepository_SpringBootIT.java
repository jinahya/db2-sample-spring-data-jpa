package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntity;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

abstract class ___MappedEntityRepository_SpringBootIT<
        REPOSITORY extends __MappedEntityRepository<ENTITY, ID>,
        ENTITY extends __MappedEntity<ENTITY, ID>,
        ID extends Serializable> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    ___MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass,
                                           final Class<ID> idClass) {
        super();
        this.repositoryClass = Objects.requireNonNull(repositoryClass, "repositoryClass is null");
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("dont' bother; just for the initial checking...")
    @Test
    final void dont_bother() {
        // empty
    }

    // ------------------------------------------------------------------------------------------------- repositoryClass

    // ----------------------------------------------------------------------------------------------------- entityClass
    abstract ENTITY newRandomizedEntityInstance();

    abstract ENTITY newPersistedEntityInstance();

    // --------------------------------------------------------------------------------------------------------- idClass

    // ---------------------------------------------------------------------------------------------- repositoryInstance
    <R> R applyRepositoryInstance(final Function<? super REPOSITORY, ? extends R> function) {
        return Objects.requireNonNull(function, "function is null").apply(repositoryInstance());
    }

    void acceptRepositoryInstance(final Consumer<? super REPOSITORY> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        applyRepositoryInstance(r -> {
            consumer.accept(r);
            return null;
        });
    }

    // ----------------------------------------------------------------------------------------------- testEntityManager
    <R> R applyEntityManager(final Function<? super EntityManager, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(entityManager());
    }

    void acceptEntityManager(final Consumer<? super EntityManager> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        applyEntityManager(r -> {
            consumer.accept(r);
            return null;
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<REPOSITORY> repositoryClass;

    final Class<ENTITY> entityClass;

    final Class<ID> idClass;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PACKAGE)
    private REPOSITORY repositoryInstance;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PACKAGE)
    private EntityManager entityManager;
}