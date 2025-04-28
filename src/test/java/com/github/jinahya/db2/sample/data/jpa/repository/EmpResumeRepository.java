package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.EmpResume;
import com.github.jinahya.db2.sample.data.jpa.EmpResumeId;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import org.springframework.stereotype.Repository;

@Repository
interface EmpResumeRepository extends MappedEmpResumeRepository<EmpResume, EmpResumeId, Employee> {

}