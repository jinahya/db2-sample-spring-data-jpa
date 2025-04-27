package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serial;

@IdClass(EmpprojactId.class)
@Entity
@Table(name = MappedEmpprojact.TABLE_NAME)
public class Empprojact extends MappedEmpprojact<Empprojact, Employee, Project, Act, EmpprojactId> {

    @Serial
    private static final long serialVersionUID = 3843390539108746049L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public EmpprojactId _id_() {
        return MappedEmpprojactId.from(this, EmpprojactId::new);
    }
}