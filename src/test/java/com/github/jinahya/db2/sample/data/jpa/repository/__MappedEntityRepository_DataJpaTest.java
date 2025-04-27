package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntity;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntityUtils;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_DataJpaTest_Configuration;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Randomizer_Utils;
import jakarta.persistence.EntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;

//@Import({
//        ValidationAutoConfiguration.class
//})
@DataJpaTest(properties = {
//        "logging.level.org.hibernate.SQL=debug",
        "logging.level.org.hibernate.orm.jdbc.bind=trace",
        "spring.jpa.properties.hibernate.format_sql=true",
        "spring.jpa.properties.hibernate.cache.use_second_level_cache=false",
        "spring.jpa.properties.hibernate.cache.use_query_cache=false"
})
@ContextConfiguration(
        classes = {
                __MappedEntity_DataJpaTest_Configuration.class
        }
)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class __MappedEntityRepository_DataJpaTest<
        REPOSITORY extends __MappedEntityRepository<ENTITY, ID>,
        ENTITY extends __MappedEntity<ENTITY, ID>,
        ID extends Serializable>
        extends ___MappedEntityRepository_DataJpaTest<REPOSITORY, ENTITY, ID> {

    // -----------------------------------------------------------------------------------------------------------------
    __MappedEntityRepository_DataJpaTest(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass,
                                         final Class<ID> idClass) {
        super(repositoryClass, entityClass, idClass);
    }

    __MappedEntityRepository_DataJpaTest(final Class<REPOSITORY> repositoryClass, final Class<ENTITY> entityClass) {
        this(repositoryClass, entityClass, __MappedEntityUtils.resolveIdClass(entityClass));
    }

    __MappedEntityRepository_DataJpaTest(final Class<REPOSITORY> repositoryClass) {
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
     * @see com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils#newPersistedInstanceOf(Class,
     * EntityManager)
     */
    @Override
    ENTITY newPersistedEntityInstance() {
        return __MappedEntity_Persister_Utils.newPersistedInstanceOf(entityClass, entityManager());
    }
}