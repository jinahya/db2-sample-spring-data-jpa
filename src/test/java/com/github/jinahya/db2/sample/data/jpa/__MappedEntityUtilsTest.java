package com.github.jinahya.db2.sample.data.jpa;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class __MappedEntityUtilsTest {

    @Nested
    class ResolveIdClassTest {

        @CsvSource({
                "com.github.jinahya.db2.sample.data.jpa.ApplicationSigning,java.lang.Long"
        })
        @ParameterizedTest
        void __(final String entityClassName, final String idClassName) throws ClassNotFoundException {
            // --------------------------------------------------------------------------------------------------- given
            @SuppressWarnings({"unchecked"})
            final var entityClass = (Class<__MappedEntity<?, ?>>)
                    Class.forName(entityClassName)
                            .asSubclass(__MappedEntity.class);
            // ---------------------------------------------------------------------------------------------------- when
            final var idClass = __MappedEntityUtils.resolveIdClass(entityClass);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(idClass).isSameAs(Class.forName(idClassName));
        }
    }
}