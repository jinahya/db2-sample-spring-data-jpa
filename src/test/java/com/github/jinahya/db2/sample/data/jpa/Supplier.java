package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedSupplier.TABLE_NAME)
public class Supplier extends MappedSupplier<Supplier> {

    @Serial
    private static final long serialVersionUID = -8678303787104706496L;
}