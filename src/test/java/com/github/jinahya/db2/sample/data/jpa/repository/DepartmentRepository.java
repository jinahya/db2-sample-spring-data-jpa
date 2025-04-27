package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Department;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import org.springframework.stereotype.Repository;

@Repository
interface DepartmentRepository extends MappedDepartmentRepository<Department, Employee> {

}