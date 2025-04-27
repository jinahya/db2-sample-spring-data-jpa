package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Department;
import com.github.jinahya.db2.sample.data.jpa.Employee;
import com.github.jinahya.db2.sample.data.jpa.Project;
import org.springframework.stereotype.Repository;

@Repository
interface ProjectRepository extends MappedProjectRepository<Project, Department, Employee> {

}