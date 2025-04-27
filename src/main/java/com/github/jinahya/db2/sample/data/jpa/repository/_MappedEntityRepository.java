package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa._MappedEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * An abstract repository interface for {@link com.github.jinahya.db2.sample.data.jpa.__MappedEntity} entity.
 *
 * @param <ENTITY> entity type parameter
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S114", // Interface names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
public interface _MappedEntityRepository<ENTITY extends _MappedEntity<ENTITY>>
        extends __MappedEntityRepository<ENTITY, Long> {

}
