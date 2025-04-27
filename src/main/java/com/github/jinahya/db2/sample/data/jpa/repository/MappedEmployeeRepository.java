package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedDepartment;
import com.github.jinahya.db2.sample.data.jpa.MappedEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedEmployeeRepository<
        ENTITY extends MappedEmployee<ENTITY, DEPARTMERNT>,
        DEPARTMERNT extends MappedDepartment<DEPARTMERNT, ENTITY>>
        extends __MappedEntityRepository<ENTITY, String> {

    Page<ENTITY> findAllByWorkdept(DEPARTMERNT workdept, Pageable pageable);
}
