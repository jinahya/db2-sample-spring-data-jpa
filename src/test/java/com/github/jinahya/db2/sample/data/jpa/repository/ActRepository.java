package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Act;
import org.springframework.stereotype.Repository;

@Repository
interface ActRepository extends MappedActRepository<Act> {

}