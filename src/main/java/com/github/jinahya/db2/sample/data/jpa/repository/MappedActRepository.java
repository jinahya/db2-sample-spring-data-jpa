package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.MappedAct;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MappedActRepository<ENTITY extends MappedAct<ENTITY>>
        extends __MappedEntityRepository<ENTITY, Integer> {

}
