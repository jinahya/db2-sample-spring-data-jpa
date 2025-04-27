package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Department;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentRepository_SpringBootIT
        extends __MappedEntityRepository_SpringBootIT<DepartmentRepository, Department, String> {

    DepartmentRepository_SpringBootIT() {
        super(DepartmentRepository.class);
    }

    @Test
    void __A00() {
        final var found = repositoryInstance().findById("A00");
        assertThat(found).hasValueSatisfying(v -> {
            assertThat(v.getAdmrdept()).isSameAs(v);
            assertThat(v.getAdmrdeptEffective()).isEmpty();
        });
    }
}