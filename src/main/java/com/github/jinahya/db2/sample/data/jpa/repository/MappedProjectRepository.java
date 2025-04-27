package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedDepartment;
import com.github.jinahya.db2.sample.data.jpa.MappedEmployee;
import com.github.jinahya.db2.sample.data.jpa.MappedProject;
import com.github.jinahya.db2.sample.data.jpa.MappedProject_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * An abstract repository interface for {@link MappedProject} entity.
 *
 * @param <ENTITY>     entity type parameter
 * @param <DEPARTMENT> department type parameter
 * @param <EMPLOYEE>   employee type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedProjectRepository<
        ENTITY extends MappedProject<ENTITY, DEPARTMENT, EMPLOYEE>,
        DEPARTMENT extends MappedDepartment<DEPARTMENT, EMPLOYEE>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, DEPARTMENT>
        >
        extends __MappedEntityRepository<ENTITY, String> {

    /**
     * Finds all entities whose {@link MappedProject_#respemp respemp} attributes match specified value.
     *
     * @param respemp  the {@link MappedProject_#respemp respemp} attribute value to match.
     * @param pageable pagination info.
     * @return a page of found entities.
     */
    Page<ENTITY> findAllByRespemp(EMPLOYEE respemp, Pageable pageable);
}
