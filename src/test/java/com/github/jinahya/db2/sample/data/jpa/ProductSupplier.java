package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serial;

@IdClass(ProductSupplierId.class)
@Entity
@Table(name = MappedProductSupplier.TABLE_NAME)
public class ProductSupplier extends MappedProductSupplier<ProductSupplier, ProductSupplierId, Product, Supplier> {

    @Serial
    private static final long serialVersionUID = 4717135820620102375L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public final ProductSupplierId _id_() {
        return ProductSupplierId.from(this);
    }
}