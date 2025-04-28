package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedEmpResume;
import com.github.jinahya.db2.sample.data.jpa.MappedEmpResumeId;
import com.github.jinahya.db2.sample.data.jpa.MappedEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * An abstract repository interface for {@link MappedEmpResume} entity.
 *
 * @param <ENTITY> entity type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedEmpResumeRepository<
        ENTITY extends MappedEmpResume<ENTITY, ID, EMPLOYEE>,
        ID extends MappedEmpResumeId<ID>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>
        >
        extends __MappedEntityRepository<ENTITY, ID> {

    Page<ENTITY> findAllByIdEmpno(String empno, Pageable pageable);

    Page<ENTITY> findAllByEmployee(EMPLOYEE employee, Pageable pageable);
}
