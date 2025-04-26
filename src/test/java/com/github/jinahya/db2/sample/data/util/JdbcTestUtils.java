package com.github.jinahya.db2.sample.data.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class JdbcTestUtils {

    private static final String CATALOG = null;

    private static final String SCHEMA = "DB2INST1";

    // -----------------------------------------------------------------------------------------------------------------
    public static void acceptEachTableName(final Connection connection, final Consumer<? super String> consumer)
            throws SQLException {
        try (var result = connection.getMetaData().getTables(CATALOG, "%", "%", null)) {
            while (result.next()) {
                consumer.accept(result.getString("TABLE_NAME"));
            }
        }
    }

    public static <C extends Collection<? super String>> C addAllTableNames(final Connection connection,
                                                                            final C collection)
            throws SQLException {
        acceptEachTableName(connection, collection::add);
        return collection;
    }

    public static List<String> getTableNames(final Connection connection) throws SQLException {
        return addAllTableNames(connection, new ArrayList<>());
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static void acceptEachColumnName(final Connection connection, final String tableName,
                                            final Consumer<? super String> consumer)
            throws SQLException {
        try (var result = connection.getMetaData().getColumns(CATALOG, SCHEMA, tableName, "%")) {
            while (result.next()) {
                consumer.accept(result.getString("COLUMN_NAME"));
            }
        }
    }

    public static <C extends Collection<? super String>> C addAllColumnNames(final Connection connection,
                                                                             final String tableName, final C collection)
            throws SQLException {
        acceptEachColumnName(connection, tableName, collection::add);
        return collection;
    }

    public static List<String> getAllColumnNames(final Connection connection, final String tableName)
            throws SQLException {
        if (false) {
            final var metaData = connection.getMetaData();
            try (var c = metaData.getCatalogs()) {
                while (c.next()) {
                    final var tableCat = c.getString("TABLE_CAT");
                    log.debug("tableCat: {}", tableCat);
                }
            }
            try (var c = metaData.getSchemas()) {
                while (c.next()) {
                    final var tableSchem = c.getString("TABLE_SCHEM");
                    log.debug("tableSchem: {}", tableSchem);
                }
            }
        }
        return Collections.unmodifiableList(
                addAllColumnNames(connection, tableName, new ArrayList<>())
        );
    }
}
