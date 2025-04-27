package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serial;

@IdClass(ProjactId.class)
@Entity
@Table(name = MappedProjact.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Projact extends MappedProjact<Projact, Project, Act, ProjactId> {

    @Serial
    private static final long serialVersionUID = 7313677298112339855L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public final ProjactId _id_() {
        return ProjactId.from(this);
    }
}