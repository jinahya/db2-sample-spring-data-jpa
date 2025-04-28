package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;

class ProductSupplier_Test extends __MappedEntity_Test<ProductSupplier, ProductSupplierId> {

    ProductSupplier_Test() {
        super(ProductSupplier.class, ProductSupplierId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    protected SingleTypeEqualsVerifierApi<ProductSupplier> equalsVerifier() {
        return super.equalsVerifier()
                .withPrefabValues(
                        MappedProduct.class,
                        (MappedProduct<?>) __MappedEntity.of_id_(Product::new, "1"),
                        (MappedProduct<?>) __MappedEntity.of_id_(Product::new, "2")
                )
                .withPrefabValues(
                        MappedSupplier.class,
                        (MappedSupplier<?>) __MappedEntity.of_id_(Supplier::new, "1"),
                        (MappedSupplier<?>) __MappedEntity.of_id_(Supplier::new, "2")
                )
                ;
    }
}