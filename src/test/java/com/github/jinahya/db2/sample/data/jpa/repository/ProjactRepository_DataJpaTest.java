package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Projact;
import com.github.jinahya.db2.sample.data.jpa.ProjactId;
import com.github.jinahya.db2.sample.data.jpa.Project;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

class ProjactRepository_DataJpaTest
        extends __MappedEntityRepository_DataJpaTest<ProjactRepository, Projact, ProjactId> {

    ProjactRepository_DataJpaTest() {
        super(ProjactRepository.class);
    }

    @DisplayName("findAllByProjno(projno, pageable)page")
    @Nested
    class FindAllByProjNo_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var projno = "";
            final var found = repositoryInstance().findAllByProjno(projno, Pageable.unpaged());
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            final var persisted = newPersistedEntityInstance();
            final var projno = persisted.getProj().getProjno();
            final var found = repositoryInstance().findAllByProjno(projno, Pageable.unpaged());
            assertThat(found).contains(persisted);
        }
    }

    @DisplayName("findAllByProj(proj, pageable)page")
    @Nested
    class FindAllByProj_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var proj = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Project.class, entityManager());
            final var found = repositoryInstance().findAllByProj(proj, Pageable.unpaged());
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            final var persisted = newPersistedEntityInstance();
            final var proj = persisted.getProj();
            final var found = repositoryInstance().findAllByProj(proj, Pageable.unpaged());
            assertThat(found).contains(persisted);
        }
    }

    @DisplayName("findAllByProjnoAndActno(projno, actno, pageable)page")
    @Nested
    class FindAllByProjnoAndActno_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            final var projno = "";
            final var actno = 0;
            final var found = repositoryInstance().findAllByProjnoAndActno(projno, actno, Pageable.unpaged());
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., persisted., )[persisted]")
        @Test
        void __Known() {
            final var persisted = newPersistedEntityInstance();
            final var projno = persisted.getProj().getProjno();
            final var actno = persisted.getAct().getActno();
            final var found = repositoryInstance().findAllByProjnoAndActno(projno, actno, Pageable.unpaged());
            assertThat(found).contains(persisted);
        }
    }
}