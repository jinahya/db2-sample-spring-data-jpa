package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Product;
import com.github.jinahya.db2.sample.data.jpa.ProductSupplier;
import com.github.jinahya.db2.sample.data.jpa.ProductSupplierId;
import com.github.jinahya.db2.sample.data.jpa.Supplier;
import org.springframework.stereotype.Repository;

@Repository
interface ProductSupplierRepository
        extends MappedProductSupplierRepository<ProductSupplier, ProductSupplierId, Product, Supplier> {

}