package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Entity
@Table(name = MappedAct.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                MappedAct.COLUMN_NAME_ACTNO,
                MappedAct.COLUMN_NAME_ACTKWD
        })
})
@Slf4j
public class Act extends MappedAct<Act> {

    @Serial
    private static final long serialVersionUID = 481687903887903886L;
}