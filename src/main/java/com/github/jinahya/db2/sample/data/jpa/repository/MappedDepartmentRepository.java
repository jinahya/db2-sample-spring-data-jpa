package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedDepartment;
import com.github.jinahya.db2.sample.data.jpa.MappedEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedDepartmentRepository<
        ENTITY extends MappedDepartment<ENTITY, EMPLOYEE>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, ENTITY>>
        extends __MappedEntityRepository<ENTITY, String> {

    @Deprecated(forRemoval = true)
    Page<ENTITY> findAllByMgrnoIsNull(Pageable pageable);

    @Deprecated(forRemoval = true)
    Page<ENTITY> findAllByMgrno(String mgrno, Pageable pageable);

    // -----------------------------------------------------------------------------------------------------------------
    Page<ENTITY> findAllByMgrIsNull(Pageable pageable);

    Page<ENTITY> findAllByMgr(EMPLOYEE mgr, Pageable pageable);

    // -----------------------------------------------------------------------------------------------------------------
    Page<ENTITY> findAllByAdmrdept(ENTITY admrdept, Pageable pageable);
}
