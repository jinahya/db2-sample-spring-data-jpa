package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Department;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentRepository_DataJpaTest
        extends __MappedEntityRepository_DataJpaTest<DepartmentRepository, Department, String> {

    DepartmentRepository_DataJpaTest() {
        super(DepartmentRepository.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("findAllByMgrIsNull(pageable)page")
    @Nested
    class FindAllMgrIsNull_Test {

        @Test
        void __() {
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByMgrIsNull(Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).satisfiesAnyOf(
                    f -> assertThat(f).isEmpty(),
                    f -> assertThat(f).extracting(Department::getMgr).containsOnlyNulls()
            );
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("findAllByMgr(mgr, pageable)page")
    @Nested
    class FindAllMgr_Test {

        @DisplayName("(unknown., )empty")
        @Test
        void __Unknown() {
            // --------------------------------------------------------------------------------------------------- given
            final var mgr = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager());
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByMgr(mgr, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var mgr = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Employee.class, entityManager());
            persisted.setMgr(mgr);
            repositoryInstance().save(persisted);
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByMgr(mgr, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("findAllByAdmrdept(admrdept, pageable)page")
    @Nested
    class FindAllAdmrdept_Test {

        @DisplayName("(unknown., )empty")
        @Test
        void __Unknown() {
            // --------------------------------------------------------------------------------------------------- given
            final var admrdept =
                    __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager()
                    );
            admrdept.setAdmrdept(null);
            entityManager().merge(admrdept);
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByAdmrdept(admrdept, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var admrdept =
                    __MappedEntity_Persister_Utils.newPersistedInstanceOf(Department.class, entityManager());
            persisted.setAdmrdept(admrdept);
            repositoryInstance().save(persisted);
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByAdmrdept(admrdept, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }
}