package org.hibernate.integrator.spi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
// https://vladmihalcea.com/how-to-get-access-to-database-table-metadata-with-hibernate-5/
// https://stackoverflow.com/a/56575360/330457
public class MetadataExtractorIntegrator implements Integrator {

    @Override
    public void integrate(final Metadata metadata, final BootstrapContext bootstrapContext,
                          final SessionFactoryImplementor sessionFactory) {
        Integrator.super.integrate(metadata, bootstrapContext, sessionFactory);
        database = metadata.getDatabase();
    }

    @Override
    public void disintegrate(final SessionFactoryImplementor sessionFactory,
                             final SessionFactoryServiceRegistry serviceRegistry) {
    }

    // -------------------------------------------------------------------------------------------------------- database
    public <R> R applyNamespaces(final Function<? super Stream<Namespace>, ? extends R> function) {
        return function.apply(
                StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(
                                database.getNamespaces().iterator(),
                                Spliterator.ORDERED
                        ),
                        false
                )
        );
    }

    public <R> R applyTables(final Function<? super Stream<Table>, ? extends R> function) {
        return applyNamespaces(
                ns -> function.apply(ns.flatMap(v -> v.getTables().stream()))
        );
    }

    public <R> R applyColumns(final Function<? super Stream<Column>, ? extends R> function) {
        return applyTables(
                ts -> function.apply(ts.flatMap(t -> t.getColumns().stream()))
        );
    }

    public List<String> getColumnNames(final String tableName) {
        return applyTables(
                ts -> ts.filter(t -> Objects.equals(t.getName(), tableName))
                        .flatMap(t -> t.getColumns().stream())
                        .map(Column::getName)
                        .toList()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Getter
    private Database database;
}
