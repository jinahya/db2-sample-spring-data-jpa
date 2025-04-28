package com.github.jinahya.db2.sample.data.jpa;

import java.io.Serial;

public class ProductSupplierId extends MappedProductSupplierId<ProductSupplierId> {

    @Serial
    private static final long serialVersionUID = -8759039248588298955L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    public static ProductSupplierId from(final ProductSupplier entity) {
        return from(ProductSupplierId::new, entity);
    }

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    /**
     * Creates a new instance.
     */
    protected ProductSupplierId() {
        super();
    }
}