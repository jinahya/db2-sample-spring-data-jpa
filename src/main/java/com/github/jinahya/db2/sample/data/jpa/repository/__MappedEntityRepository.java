package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * An abstract interface for {@link __MappedEntity} entity.
 *
 * @param <ENTITY> entity type parameter
 * @param <ID>     id type parameter
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@NoRepositoryBean
@SuppressWarnings({
        "java:S114", // Interface names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
public interface __MappedEntityRepository<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable>
        extends JpaRepository<ENTITY, ID>,
                JpaSpecificationExecutor<ENTITY> {

}
