package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedCustomer.TABLE_NAME)
public class Customer extends MappedCustomer<Customer> {

    @Serial
    private static final long serialVersionUID = -7863572442682283485L;
}