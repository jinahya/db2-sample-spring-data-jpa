package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.EmpResume;
import com.github.jinahya.db2.sample.data.jpa.EmpResumeId;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

class EmpResumeRepository_DataJpaTest
        extends __MappedEntityRepository_DataJpaTest<EmpResumeRepository, EmpResume, EmpResumeId> {

    EmpResumeRepository_DataJpaTest() {
        super(EmpResumeRepository.class);
    }

    @DisplayName("findAllByIdEmpno(idEmpNo, pageable)page")
    @Nested
    class FindAllByIdEmpno_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var idEmpNo = "";
            final var found = repositoryInstance().findAllByIdEmpno(idEmpNo, Pageable.unpaged());
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]}")
        @Test
        void __Known() {
            final var persisted = newPersistedEntityInstance();
            final var idEmpNo = persisted.getId().getEmpno();
            final var found = repositoryInstance().findAllByIdEmpno(idEmpNo, Pageable.unpaged());
            assertThat(found).contains(persisted);
        }
    }

    @DisplayName("findAllByEmployee(employee, pageable)page")
    @Nested
    class FindAllByEmployee_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var employee = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager());
            final var found = repositoryInstance().findAllByEmployee(employee, Pageable.unpaged());
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]}")
        @Test
        void __Known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var employee = persisted.getEmployee();
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByEmployee(employee, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }
}