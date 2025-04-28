package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * An abstract mapped superclass for entity classes.
 *
 * @param <SELF> self type parameter
 * @param <ID>   id type parameter
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class __MappedEntity<SELF extends __MappedEntity<SELF, ID>, ID extends Serializable>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = -338022319015815059L;

    // -------------------------------------------------------------------------------------------------------------- id

    /**
     * A column name of {@value}.
     */
    public static final String COLUMN_NAME_ID = "id";

    // ------------------------------------------------------------------------------------------------------ created_at

    /**
     * A column name of {@value}.
     */
    public static final String COLUMN_NAME_CREATED_AT = "created_at";

    // ------------------------------------------------------------------------------------------------------ updated_at

    /**
     * A column name of {@value}.
     */
    public static final String COLUMN_NAME_UPDATED_AT = "updated_at";

    // ------------------------------------------------------------------------------------------------------ deleted_at

    /**
     * A column name of {@value}.
     */
    public static final String COLUMN_NAME_DELETED_AT = "deleted_at";

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    static <ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable> ENTITY of_id_(
            final Supplier<? extends ENTITY> supplier,
            final ID _id_) {
        Objects.requireNonNull(supplier, "supplier is null");
        final var instance = Objects.requireNonNull(supplier.get(), "null supplied from " + supplier);
        instance._id_(_id_);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "_id_=" + _id_() +
                '}';
    }

    // https://jqno.nl/equalsverifier/manual/jpa-entities/
    // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof __MappedEntity)) {
            return false;
        }
        return Objects.equals(_id_(), ((__MappedEntity<?, ?>) obj)._id_());
    }

    // https://jqno.nl/equalsverifier/manual/jpa-entities/
    // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    @Override
    public final int hashCode() {
        return Objects.hashCode(_id_());
    }

    // ------------------------------------------------------------------------------------------------------------ _id_

    /**
     * Returns an instance of {@code <ID>} type of this entity.
     *
     * @return an instance of {@code <ID>} type of this entity.
     */
    @SuppressWarnings({
            "java:S100" // Method names should comply with a naming convention
    })
    public abstract ID _id_();

    /**
     * Replaces current value of {@code <ID>} type of this entity with specified value.
     *
     * @param _id_ new value of {@code <ID>} type of this entity
     */
    @SuppressWarnings({
            "java:S100", // Method names should comply with a naming convention
            "java:S117" // Local variable and method parameter names should comply with a naming convention
    })
    public abstract void _id_(final ID _id_);
}
