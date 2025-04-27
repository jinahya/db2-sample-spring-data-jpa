package com.github.jinahya.db2.sample.data.jpa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S3577" // Test classes should comply with a naming convention
})
class __MappedEntityRepositoryUtilsTest {

    @DisplayName("resolveEntityClass(repositoryClass)")
    @Nested
    class ResolveEntityClassTest {

        @CsvSource({
                "com.github.jinahya.db2.sample.data.jpa.repository.ActRepository" +
                        ",com.github.jinahya.db2.sample.data.jpa.Act"
        })
        @ParameterizedTest
        void __(final String repositoryClassName, final String entityClassName) throws ClassNotFoundException {
            // --------------------------------------------------------------------------------------------------- given
            @SuppressWarnings({"unchecked"})
            final var repositoryClass = (Class<__MappedEntityRepository<?, ?>>)
                    Class.forName(repositoryClassName)
                            .asSubclass(__MappedEntityRepository.class);
            // ---------------------------------------------------------------------------------------------------- when
            final var entityClass = __MappedEntityRepositoryUtils.resolveEntiyClass(repositoryClass);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(entityClass).isSameAs(Class.forName(entityClassName));
        }
    }
}