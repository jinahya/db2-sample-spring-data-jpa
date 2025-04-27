package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedAct;
import com.github.jinahya.db2.sample.data.jpa.MappedProjact;
import com.github.jinahya.db2.sample.data.jpa.MappedProjactId;
import com.github.jinahya.db2.sample.data.jpa.MappedProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedProjactRepository<
        ENTITY extends MappedProjact<ENTITY, PROJECT, ACT, ID>,
        PROJECT extends MappedProject<PROJECT, ?, ?>,
        ACT extends MappedAct<ACT>,
        ID extends MappedProjactId<ID>
        >
        extends __MappedEntityRepository<ENTITY, ID> {

    // -----------------------------------------------------------------------------------------------------------------
    @Deprecated(forRemoval = true)
    default Optional<ENTITY> findById(final String projno, final Integer actno, final LocalDate acstdate,
                                      final Function<? super String,
                                              ? extends Function<? super Integer,
                                                      ? extends Function<? super LocalDate,
                                                              ? extends ID>>> function) {
        Objects.requireNonNull(function, "function is null");
        return findById(function.apply(projno).apply(actno).apply(acstdate));
    }

    @Deprecated(forRemoval = true)
    default Optional<ENTITY> findById(final String projno, final ACT act, final LocalDate acstdate,
                                      final Function<? super String,
                                              ? extends Function<? super Integer,
                                                      ? extends Function<? super LocalDate,
                                                              ? extends ID>>> function) {
        Objects.requireNonNull(acstdate, "acstdate is null");
        return findById(
                projno,
                Objects.requireNonNull(act, "act is null").getActno(),
                acstdate,
                function
        );
    }

    @Deprecated(forRemoval = true)
    default Optional<ENTITY> findAllByProjAndActno(final PROJECT proj, final Integer actno, final LocalDate acstdate,
                                                   final Function<? super String,
                                                           ? extends Function<? super Integer,
                                                                   ? extends Function<? super LocalDate,
                                                                           ? extends ID>>> function) {
        return findById(
                Objects.requireNonNull(proj, "proj is null").getProjno(),
                actno,
                acstdate,
                function
        );
    }

    @Deprecated(forRemoval = true)
    default Optional<ENTITY> findById(PROJECT proj, ACT act, final LocalDate acstdate,
                                      final Function<? super String,
                                              ? extends Function<? super Integer,
                                                      ? extends Function<? super LocalDate,
                                                              ? extends ID>>> function) {
        return findById(
                Objects.requireNonNull(proj, "proj is null").getProjno(),
                Objects.requireNonNull(act, "act is null").getActno(),
                acstdate,
                function
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    Page<ENTITY> findAllByProjno(String projno, Pageable pageable);

    // TODO: make as default invokes findAllByProjno(proj.getProjno(), pageable)
    Page<ENTITY> findAllByProj(PROJECT proj, Pageable pageable);

    // -----------------------------------------------------------------------------------------------------------------
    Page<ENTITY> findAllByProjnoAndActno(String projno, Integer actno, Pageable pageable);

    // TODO: make as default invokes findAllByProjnoAndActno(projno, act.getActno(), pageable)
    Page<ENTITY> findAllByProjnoAndAct(String projno, ACT act, Pageable pageable);

    // TODO: make as default invokes findAllByProjnoAndActno(proj.getProjno(), actno, pageable)
    Page<ENTITY> findAllByProjAndActno(PROJECT proj, Integer actno, Pageable pageable);

    // TODO: make as default invokes findAllByProjnoAndActno(proj.getProjno(), act.getActno(), pageable)
    Page<ENTITY> findAllByProjAndAct(PROJECT proj, ACT act, Pageable pageable);
}
