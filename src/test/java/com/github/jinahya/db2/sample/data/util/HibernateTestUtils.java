package com.github.jinahya.db2.sample.data.util;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.MappingMetamodel;
import org.hibernate.persister.entity.AbstractEntityPersister;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class HibernateTestUtils {

    public static List<String> getRootTableNames(final SessionFactory sessionFactory) {
        return ((MappingMetamodel) sessionFactory.getMetamodel())
                .streamEntityDescriptors()
                .map(ep -> ((AbstractEntityPersister) ep).getRootTableName())
                .collect(Collectors.toList());
    }

    public static String getRootEntityName(final SessionFactory sessionFactory, final Class<?> entityClass) {
        return ((MappingMetamodel) sessionFactory.getMetamodel())
                .getEntityDescriptor(entityClass)
                .getRootEntityName();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static String getIdentifierPropertyName(final SessionFactory sessionFactory, final Class<?> entityClass) {
        return ((MappingMetamodel) sessionFactory.getMetamodel())
                .getEntityDescriptor(entityClass)
                .getIdentifierPropertyName();
    }

    public static Stream<String> getPropertyNames(final SessionFactory sessionFactory, final Class<?> entityClass) {
        return Arrays.stream(
                ((MappingMetamodel) sessionFactory.getMetamodel())
                        .getEntityDescriptor(entityClass)
                        .getPropertyNames()
        );
    }

    public static Stream<String> getAllPropertyNames(final SessionFactory sessionFactory, final Class<?> entityClass) {
        return Stream.concat(
                Stream.of(getIdentifierPropertyName(sessionFactory, entityClass)),
                getPropertyNames(sessionFactory, entityClass)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static Stream<String> getColumnNames(final SessionFactory sessionFactory, final Class<?> entityClass) {
        final var entityPersister = (AbstractEntityPersister) ((MappingMetamodel) sessionFactory.getMetamodel())
                .getEntityDescriptor(entityClass).getEntityPersister();
        return Arrays.stream((entityPersister.getPropertyNames()))
                .flatMap(pn -> Arrays.stream(entityPersister.toColumns(pn)));
    }

    public static Stream<String> getAllColumnNames(final SessionFactory sessionFactory, final Class<?> entityClass) {
        final var entityPersister = (AbstractEntityPersister) ((MappingMetamodel) sessionFactory.getMetamodel())
                .getEntityDescriptor(entityClass).getEntityPersister();
        return Stream.concat(
                Arrays.stream(entityPersister.getIdentifierColumnNames()),
                getColumnNames(sessionFactory, entityClass)
        );
    }

    /**
     * .
     *
     * @param entityManager .
     * @param entityClass   .
     * @see <a
     * href="https://docs.jboss.org/hibernate/orm/current/javadocs/org/hibernate/persister/entity/EntityPersister.html">org.hibernate.persister.entity.EntityPersister</a>
     * @see <a
     * href="https://docs.jboss.org/hibernate/orm/current/javadocs/org/hibernate/persister/entity/AbstractEntityPersister.html">org.hibernate.persister.entity.AbstractEntityPersister</a>
     */
    // https://discourse.hibernate.org/t/how-to-get-the-column-name-for-an-entity-attribute-using-hibernate/1872
    // https://vladmihalcea.com/how-to-get-access-to-database-table-metadata-with-hibernate-5/
    public static void a(final EntityManager entityManager, final Class<?> entityClass) {
        // ((AbstractEntityPersister)((MetamodelImplementor) entityManager.getEntityManagerFactory().unwrap(
        //SessionFactory.class).getMetamodel()).entityPersister(Reference.class))
        //.getPropertyColumnNames(“viewName”)
        final var entityManagerFactory = entityManager.getEntityManagerFactory();
        final var sessionFactory = entityManagerFactory.unwrap(org.hibernate.SessionFactory.class);
        final var metaModel = sessionFactory.getMetamodel();
        final var entityPersister = ((MappingMetamodel) metaModel).locateEntityDescriptor(entityClass);
        final var attributeMappingList = entityPersister.getAttributeMappings();
        attributeMappingList.forEach(am -> {
            final var attributeMetadata = am.getAttributeMetadata();
        });
    }

    private HibernateTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
