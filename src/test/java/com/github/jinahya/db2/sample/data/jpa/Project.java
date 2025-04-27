package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedProject.TABLE_NAME)
public class Project extends MappedProject<Project, Department, Employee> {

    @Serial
    private static final long serialVersionUID = 6502119587224443858L;
}