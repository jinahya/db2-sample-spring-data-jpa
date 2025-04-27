package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa._MappedEntity;
import com.github.jinahya.db2.sample.data.jpa._MappedEntity_Persister_Utils;
import com.github.jinahya.db2.sample.data.jpa._MappedEntity_Randomizer_Utils;
import com.github.jinahya.db2.sample.data.jpa._MappedEntity_SpringBootIT_Configuration;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import jakarta.persistence.EntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//@Transactional
@SpringBootTest
@ContextConfiguration(
        classes = {
                _MappedEntity_SpringBootIT_Configuration.class
        }
)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class _MappedEntityRepository_SpringBootIT<
        REPOSITORY extends _MappedEntityRepository<ENTITY>,
        ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntityRepository_SpringBootIT<REPOSITORY, ENTITY, Long> {

    // -----------------------------------------------------------------------------------------------------------------
    _MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass) {
        super(repositoryClass, entityClass, Long.class);
    }

    _MappedEntityRepository_SpringBootIT(final Class<REPOSITORY> repositoryClass) {
        this(repositoryClass, __MappedEntityRepositoryUtils.resolveEntiyClass(repositoryClass));
    }

    // ----------------------------------------------------------------------------------------------- super.entityClass
    @Override
    ENTITY newRandomizedEntityInstance() {
        return _MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
    }

    /**
     * Returns a new persisted instance of {@link #entityClass}.
     *
     * @return a new persisted instance of {@link #entityClass}
     * @see __MappedEntity_Persister_Utils#newPersistedInstanceOf(Class, EntityManager)
     */
    @Override
    ENTITY newPersistedEntityInstance() {
        return _MappedEntity_Persister_Utils.newPersistedInstanceOf(entityClass, entityManager());
    }
}