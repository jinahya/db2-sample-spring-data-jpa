package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = MappedPurchaseOrder.TABLE_NAME)
public class PurchaseOrder extends MappedPurchaseOrder<PurchaseOrder, Customer> {

    @Serial
    private static final long serialVersionUID = 4426007601798090643L;
}