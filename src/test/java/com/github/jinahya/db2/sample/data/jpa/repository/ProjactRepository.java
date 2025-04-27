package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Act;
import com.github.jinahya.db2.sample.data.jpa.Projact;
import com.github.jinahya.db2.sample.data.jpa.ProjactId;
import com.github.jinahya.db2.sample.data.jpa.Project;
import org.springframework.stereotype.Repository;

@Repository
interface ProjactRepository extends MappedProjactRepository<Projact, Project, Act, ProjactId> {

}