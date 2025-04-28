package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedProduct.TABLE_NAME)
public class Product extends MappedProduct<Product> {

    @Serial
    private static final long serialVersionUID = -6207089883209592833L;
}