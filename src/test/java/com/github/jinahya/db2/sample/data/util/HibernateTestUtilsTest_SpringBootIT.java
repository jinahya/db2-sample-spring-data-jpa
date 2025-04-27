package com.github.jinahya.db2.sample.data.util;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class HibernateTestUtilsTest_SpringBootIT {

    @Test
    void getPropertyNames__() throws SQLException {
        try (var connection = dataSource.getConnection()) {
            final var tableNames = JdbcTestUtils.getTableNames(connection);
            tableNames.forEach(tn -> log.debug("tableName: {}", tn));
        }
        try (var connection = dataSource.getConnection()) {
            final var tableNames = JdbcTestUtils.getTableNames(connection);
            tableNames.forEach(tn -> log.debug("tableName: {}", tn));
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;
}