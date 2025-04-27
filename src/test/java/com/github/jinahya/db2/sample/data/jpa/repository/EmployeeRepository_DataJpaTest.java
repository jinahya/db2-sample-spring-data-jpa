package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Department;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepository_DataJpaTest
        extends __MappedEntityRepository_DataJpaTest<EmployeeRepository, Employee, String> {

    EmployeeRepository_DataJpaTest() {
        super(EmployeeRepository.class);
    }

    @DisplayName("findAllByWorkdept(workdept, pageable)page")
    @Nested
    class FindAllByWorkdept_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var workdept =
                    __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager()
                    );
            final var found = applyRepositoryInstance(r -> r.findAllByWorkdept(workdept, Pageable.unpaged()));
            assertThat(found).isEmpty();
        }

        //        @Transactional
        @DisplayName("(persisted., )[persisted]")
        @Test
        void _NotEmpty_Known() {
            final var workdept =
                    __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager()
                    );
            final var persisted = newPersistedEntityInstance();
            persisted.setWorkdept(workdept);
            repositoryInstance().save(persisted);
            // ---------------------------------------------------------------------------------------------------------
            final var found = applyRepositoryInstance(r -> r.findAllByWorkdept(workdept, Pageable.unpaged()));
            // ---------------------------------------------------------------------------------------------------------
            assertThat(found).contains(persisted);
        }
    }
}