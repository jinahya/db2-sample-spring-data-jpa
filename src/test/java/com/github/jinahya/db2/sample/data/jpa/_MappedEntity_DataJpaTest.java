package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
@DataJpaTest(properties = {
//        "logging.level.org.hibernate.SQL=debug",
        "logging.level.org.hibernate.orm.jdbc.bind=trace",
        "spring.jpa.properties.hibernate.format_sql=true"
})
@ContextConfiguration(
        classes = {
                _MappedEntity_DataJpaTest_Configuration.class
        }
)
@Slf4j
abstract class _MappedEntity_DataJpaTest<ENTITY extends _MappedEntity<ENTITY>>
        extends ___MappedEntity_DataJpaTest<ENTITY, Long> {

    _MappedEntity_DataJpaTest(final Class<ENTITY> entityClass) {
        super(entityClass, Long.class);
    }

    // ----------------------------------------------------------------------------------------------- super.entityClass

    // --------------------------------------------------------------------------------------------------- super.idClass

    // -----------------------------------------------------------------------------------------------------------------
}