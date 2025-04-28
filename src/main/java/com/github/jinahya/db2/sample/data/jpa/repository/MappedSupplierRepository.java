package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedSupplier;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * An abstract repository interface for {@link MappedSupplier} entity.
 *
 * @param <ENTITY> entity type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedSupplierRepository<ENTITY extends MappedSupplier<ENTITY>>
        extends __MappedEntityRepository<ENTITY, String> {

}
