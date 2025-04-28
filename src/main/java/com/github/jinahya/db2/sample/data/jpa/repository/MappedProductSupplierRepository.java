package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedProduct;
import com.github.jinahya.db2.sample.data.jpa.MappedProductSupplier;
import com.github.jinahya.db2.sample.data.jpa.MappedProductSupplierId;
import com.github.jinahya.db2.sample.data.jpa.MappedSupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * An abstract repository interface for {@link MappedProductSupplier} entity.
 *
 * @param <ENTITY>   entity type parameter
 * @param <ID>
 * @param <PRODUCT>
 * @param <SUPPLIER>
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedProductSupplierRepository<
        ENTITY extends MappedProductSupplier<ENTITY, ID, PRODUCT, SUPPLIER>,
        ID extends MappedProductSupplierId<ID>,
        PRODUCT extends MappedProduct<PRODUCT>,
        SUPPLIER extends MappedSupplier<SUPPLIER>
        >
        extends __MappedEntityRepository<ENTITY, ID> {

    Page<ENTITY> findAllByPid(String pid, Pageable pageable);

    Page<ENTITY> findAllByProduct(PRODUCT product, Pageable pageable);

    Page<ENTITY> findAllBySid(String sid, Pageable pageable);

    Page<ENTITY> findAllBySupplier(SUPPLIER product, Pageable pageable);
}
