package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Entity
@Table(name = MappedDepartment.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class Department extends MappedDepartment<Department, Employee> {

    @Serial
    private static final long serialVersionUID = 8256421760603270571L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    static Department of_id_(final String _id_) {
        return of_id_(Department::new, _id_);
    }
}