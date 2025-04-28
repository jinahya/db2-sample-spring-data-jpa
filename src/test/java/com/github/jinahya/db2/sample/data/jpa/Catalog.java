package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedCatalog.TABLE_NAME)
public class Catalog extends MappedCatalog<Catalog> {

    @Serial
    private static final long serialVersionUID = 2966912781776090976L;
}