package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedEmpPhoto.TABLE_NAME)
public class EmpPhoto extends MappedEmpPhoto<EmpPhoto, EmpPhotoId, Employee> {

    @Serial
    private static final long serialVersionUID = 8483071749379120286L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected EmpPhoto() {
        super(EmpPhotoId.class);
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
}