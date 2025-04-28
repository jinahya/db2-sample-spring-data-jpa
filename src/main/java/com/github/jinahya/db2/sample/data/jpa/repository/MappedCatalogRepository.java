package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedCatalog;
import com.github.jinahya.db2.sample.data.jpa.MappedCatalog_;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * An abstract repository interface for {@link MappedCatalog} entity.
 *
 * @param <ENTITY> entity type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public interface MappedCatalogRepository<ENTITY extends MappedCatalog<ENTITY>>
        extends __MappedEntityRepository<ENTITY, String> {

    /**
     * Finds the entity whose {@link MappedCatalog_#name name} attribute matches specified value.
     *
     * @param name the {@link MappedCatalog_#name name} attribute value to match.
     * @return an optional of found entity; {@link Optional#empty() empty} if not found.
     * @deprecated Use {@link org.springframework.data.repository.CrudRepository#findById(Object)} method.
     */
    @Deprecated(forRemoval = true)
    Optional<ENTITY> findByName(String name);
}
