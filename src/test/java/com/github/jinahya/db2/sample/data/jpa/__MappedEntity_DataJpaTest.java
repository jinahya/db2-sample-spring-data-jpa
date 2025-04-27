package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.ResolvableType;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;

@DataJpaTest(properties = {
//        "logging.level.org.hibernate.SQL=debug",
        "logging.level.org.hibernate.orm.jdbc.bind=trace",
        "spring.jpa.properties.hibernate.format_sql=true",
        "spring.jpa.properties.hibernate.highlight_sql=true",
        "spring.jpa.properties.hibernate.show_sql=true",
        "spring.jpa.properties.hibernate.use_sql_comment=true"
})
@ContextConfiguration(
        classes = {
                __MappedEntity_DataJpaTest_Configuration.class
        }
)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class __MappedEntity_DataJpaTest<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable>
        extends ___MappedEntity_DataJpaTest<ENTITY, ID> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    @Deprecated
    __MappedEntity_DataJpaTest(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super(entityClass, idClass);
    }

    @SuppressWarnings({
            "unchecked"
    })
    __MappedEntity_DataJpaTest(final Class<ENTITY> entityClass) {
        super(entityClass,
              (Class<ID>) ResolvableType.forClass(entityClass).as(__MappedEntity.class).getGeneric(1).resolve());
    }

    // -----------------------------------------------------------------------------------------------------------------

    // ----------------------------------------------------------------------------------------------- super.entityClass

    // --------------------------------------------------------------------------------------------------- super.idClass
}