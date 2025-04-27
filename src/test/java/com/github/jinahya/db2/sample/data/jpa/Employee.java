package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedEmployee.TABLE_NAME)
public class Employee extends MappedEmployee<Employee, Department> {

    @Serial
    private static final long serialVersionUID = -4431468269306894643L;
}