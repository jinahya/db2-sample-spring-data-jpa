package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Catalog;
import org.springframework.stereotype.Repository;

@Repository
interface CatalogRepository extends MappedCatalogRepository<Catalog> {

}