package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedCustomer;
import com.github.jinahya.db2.sample.data.jpa.MappedPurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedPurchaseOrderRepository<
        ENTITY extends MappedPurchaseOrder<ENTITY, CUSTOMER>,
        CUSTOMER extends MappedCustomer<CUSTOMER>
        >
        extends __MappedEntityRepository<ENTITY, Long> {

    Page<ENTITY> findAllByCustid(Long custid, Pageable pageable);

    Page<ENTITY> findAllByCustomer(CUSTOMER customer, Pageable pageable);
}

