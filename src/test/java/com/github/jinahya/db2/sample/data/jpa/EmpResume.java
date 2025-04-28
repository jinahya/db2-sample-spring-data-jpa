package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedEmpResume.TABLE_NAME)
public class EmpResume extends MappedEmpResume<EmpResume, EmpResumeId, Employee> {

    @Serial
    private static final long serialVersionUID = 3990633113504484885L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected EmpResume() {
        super(EmpResumeId.class);
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
}