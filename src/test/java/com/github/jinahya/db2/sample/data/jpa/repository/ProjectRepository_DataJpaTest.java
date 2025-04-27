package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Employee;
import com.github.jinahya.db2.sample.data.jpa.Project;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectRepository_DataJpaTest extends __MappedEntityRepository_DataJpaTest<ProjectRepository, Project, String> {

    ProjectRepository_DataJpaTest() {
        super(ProjectRepository.class);
    }

    @DisplayName("findAllByRespemp(respemp, pageable)page")
    @Nested
    class FindAllByRespemp_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            // --------------------------------------------------------------------------------------------------- given
            final var respemp = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager());
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByRespemp(respemp, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var respemp = persisted.getRespemp();
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByRespemp(respemp, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }
}