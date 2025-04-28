package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Embeddable;

import java.io.Serial;

@Embeddable
public class EmpPhotoId extends MappedEmpPhotoId<EmpPhotoId> {

    @Serial
    private static final long serialVersionUID = -2266623578870354643L;
}