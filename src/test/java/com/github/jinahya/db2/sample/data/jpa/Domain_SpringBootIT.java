package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.data.util.HibernateTestUtils;
import com.github.jinahya.db2.sample.data.util.JdbcTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.LinkedHashSet;

@SpringBootTest
@Slf4j
class Domain_SpringBootIT {

    @Test
    void jdbcTableNames__() throws SQLException {
        final var jdbcTtableNames = new LinkedHashSet<>(JdbcTestUtils.getTableNames(dataSource.getConnection()));
        log.warn("number of all tables: {}", jdbcTtableNames.size());
        final var jpaTableNames = new LinkedHashSet<>(HibernateTestUtils.getRootTableNames(sessionFactory));
        jdbcTtableNames.removeAll(jpaTableNames);
        log.warn("number of unmapped tables: {}", jdbcTtableNames.size());
        jdbcTtableNames.forEach(jtn -> {
            log.warn("unmapped table: {}", jtn);
        });
    }

    @Test
    void jpaTableNames__() throws SQLException {
        final var jpaTableNames = new LinkedHashSet<>(HibernateTestUtils.getRootTableNames(sessionFactory));
        final var jdbcTtableNames = new LinkedHashSet<>(JdbcTestUtils.getTableNames(dataSource.getConnection()));
        jpaTableNames.removeAll(jdbcTtableNames);
        jpaTableNames.remove("example_entity_with_embedded_id");
        jpaTableNames.remove("example_entity_with_id_class");
        jpaTableNames.remove("h2_some");
        jpaTableNames.remove("h2_other");
        jpaTableNames.remove("h2_other_history");
        jpaTableNames.forEach(jtn -> {
            log.warn("unknown table: {}", jtn);
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;
}
