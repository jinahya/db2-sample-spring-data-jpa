package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class _MappedEntity_SpringBootIT<ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntity_SpringBootIT<ENTITY, Long> {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    _MappedEntity_SpringBootIT(final Class<ENTITY> entityClass) {
        super(entityClass, Long.class);
    }
}