package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntity;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntityUtils;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Randomizer_Utils;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_SpringBootIT_Configuration;
import jakarta.persistence.EntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
@SpringBootTest
@ContextConfiguration(
        classes = {
                __MappedEntity_SpringBootIT_Configuration.class
        }
)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class __MappedEntityRepository_SpringBootIT<
        REPOSITORY extends __MappedEntityRepository<ENTITY, ID>,
        ENTITY extends __MappedEntity<ENTITY, ID>,
        ID extends Serializable>
        extends ___MappedEntityRepository_SpringBootIT<REPOSITORY, ENTITY, ID> {

    // -----------------------------------------------------------------------------------------------------------------
    __MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass,
                                          final Class<ID> idClass) {
        super(repositoryClass, entityClass, idClass);
    }

    __MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass) {
        this(repositoryClass, entityClass, __MappedEntityUtils.resolveIdClass(entityClass));
    }

    __MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass) {
        this(repositoryClass, __MappedEntityRepositoryUtils.resolveEntiyClass(repositoryClass));
    }

    // ----------------------------------------------------------------------------------------------- super.entityClass
    @Override
    ENTITY newRandomizedEntityInstance() {
        return __MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
    }

    /**
     * Returns a new persisted instance of {@link #entityClass}.
     *
     * @return a new persisted instance of {@link #entityClass}
     * @see __MappedEntity_Persister_Utils#newPersistedInstanceOf(Class, EntityManager)
     */
    @Override
    ENTITY newPersistedEntityInstance() {
        return __MappedEntity_Persister_Utils.newPersistedInstanceOf(entityClass, entityManager());
    }
}