package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Embeddable;

import java.io.Serial;

@Embeddable
public class EmpResumeId extends MappedEmpResumeId<EmpResumeId> {

    @Serial
    private static final long serialVersionUID = -1331433296760383172L;
}