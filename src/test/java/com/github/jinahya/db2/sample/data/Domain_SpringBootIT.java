package com.github.jinahya.db2.sample.data;

import com.github.jinahya.db2.sample.data.util.HibernateTestUtils;
import com.github.jinahya.db2.sample.data.util.JdbcTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import static org.assertj.core.api.Assumptions.assumeThat;

@SpringBootTest
@Slf4j
class Domain_SpringBootIT {

    @Test
    void metadata() throws SQLException {
        try (var connection = dataSource.getConnection()) {
            final var metaData = connection.getMetaData();
            try (var r = metaData.getCatalogs()) {
                while (r.next()) {
                    final var tableCat = r.getString("TABLE_CAT");
                    log.debug("TABLE_CAT: {}", tableCat);
                    log.info("TABLE_CAT: {}", tableCat);
                    try (var s = metaData.getSchemas(tableCat, "%")) {
                        while (s.next()) {
                            final var tableSchem = s.getString("TABLE_SCHEM");
                            log.debug("\tTABLE_SCHEM: {}", tableSchem);
                            log.info("\tTABLE_SCHEM: {}", tableSchem);
                        }
                    }
                }
            }
            try (var r = metaData.getSchemas()) {
                while (r.next()) {
                    final var tableCatalog = r.getString("TABLE_CATALOG");
                    final var tableSchem = r.getString("TABLE_SCHEM");
                    log.debug("TABLE_SCHEM: {}", tableSchem);
                    log.info("TABLE_CATALOG: {}, TABLE_SCHEM: {}", tableCatalog, tableSchem);
                }
            }
        }
    }

    @Test
    void jdbcTableNames__() throws SQLException {
        final var jdbcTtableNames = new LinkedHashSet<>(JdbcTestUtils.getTableNames(dataSource.getConnection()));
        jdbcTtableNames.removeAll(List.of(
                "ADEFUSR", // materialized view
                "VACT",        // view
                "VASTRDE1",    // view
                "VASTRDE2",    // view
                "VDEPMG1",     // view
                "VDEPT",       // view
                "VEMP",        // view
                "VEMPDPT1",    // view
                "VEMPLP",      // view
                "VEMPPROJACT", // view
                "VFORPLA",     // view
                "VHDEPT",      // view
                "VPHONE",      // view
                "VPROJ",       // view
                "VPROJACT", // view
                "VPROJRE1", // view
                "VPSTRDE1", // view
                "VPSTRDE2", // view
                "VSTAFAC1", // view
                "VSTAFAC2", // view
                "DEPT",    // synonym
                "EMP",     // synonym
                "EMP_ACT", // synonym
                "EMPACT",  // synonym
                "PROJ"     // synonym
        ));
        log.info("number of all jdbc tables: {}", jdbcTtableNames.size());
        final var jpaTableNames = new LinkedHashSet<>(HibernateTestUtils.getRootTableNames(sessionFactory));
        jdbcTtableNames.removeAll(jpaTableNames);
        log.info("number of unmapped jdbc tables: {}", jdbcTtableNames.size());
        jdbcTtableNames.forEach(jtn -> {
            log.warn("unmapped jdbc table: {}", jtn);
        });
        assumeThat(jdbcTtableNames).isEmpty();
    }

    @Test
    void jpaTableNames__() throws SQLException {
        final var jpaTableNames = new LinkedHashSet<>(HibernateTestUtils.getRootTableNames(sessionFactory));
        log.info("number of all jpa tables: {}", jpaTableNames.size());
        final var jdbcTtableNames = new LinkedHashSet<>(JdbcTestUtils.getTableNames(dataSource.getConnection()));
        jpaTableNames.removeAll(jdbcTtableNames);
        log.info("number of unknown jpa tables: {}", jpaTableNames.size());
        jpaTableNames.forEach(jtn -> {
            log.warn("unknown jpa table: {}", jtn);
        });
        assumeThat(jpaTableNames).isEmpty();
    }

    @Test
    void VSTAFAC2() throws SQLException {
        try (var connection = dataSource.getConnection()) {
            final var metaData = connection.getMetaData();
            try (var r = metaData.getBestRowIdentifier(JdbcTestUtils.CATALOG, JdbcTestUtils.SCHEMA, "VSTAFAC2", 0,
                                                       true)) {
                while (r.next()) {
                    final var scope = r.getString("SCOPE");
                    final var columnName = r.getString("COLUMN_NAME");
                    log.debug("scope: {}, columnName: {}", scope, columnName);
                }
            }
            try (var r = metaData.getBestRowIdentifier(null, null, "VSTAFAC2", DatabaseMetaData.bestRowTemporary,
                                                       true)) {
                while (r.next()) {
                    final var scope = r.getString("SCOPE");
                    final var columnName = r.getString("COLUMN_NAME");
                    log.debug("scope: {}, columnName: {}", scope, columnName);
                }
            }
            try (var r = metaData.getBestRowIdentifier(null, null, "VSTAFAC2", DatabaseMetaData.bestRowTransaction,
                                                       true)) {
                while (r.next()) {
                    final var scope = r.getString("SCOPE");
                    final var columnName = r.getString("COLUMN_NAME");
                    log.debug("scope: {}, columnName: {}", scope, columnName);
                }
            }
            try (var r = metaData.getBestRowIdentifier(null, null, "VSTAFAC2", DatabaseMetaData.bestRowSession, true)) {
                while (r.next()) {
                    final var scope = r.getString("SCOPE");
                    final var columnName = r.getString("COLUMN_NAME");
                    log.debug("scope: {}, columnName: {}", scope, columnName);
                }
            }
            try (var r = metaData.getPrimaryKeys(null, null, "VSTAFAC2")) {
                while (r.next()) {
                    final var columnName = r.getString("COLUMN_NAME");
                    final var keySeq = r.getString("KEY_SEQ");
                    log.debug("columnName: {}, keySeq: {}", columnName, keySeq);
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;
}
