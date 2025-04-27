package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * An abstract mapped superclass for entity classes with a {@code Long} primary key.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class _MappedEntity<SELF extends _MappedEntity<SELF>> extends __MappedEntity<SELF, Long> {

    @Serial
    private static final long serialVersionUID = -4808475044539366875L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    static <ENTITY extends _MappedEntity<ENTITY>> ENTITY of_id_(
            final Supplier<? extends ENTITY> supplier,
            final Long _id_) {
        return __MappedEntity.of_id_(supplier, _id_);
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    // https://jqno.nl/equalsverifier/manual/jpa-entities/
    // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof _MappedEntity)) {
            return false;
        }
        return Objects.equals(getId(), ((_MappedEntity<?>) obj).getId());
    }

    // https://jqno.nl/equalsverifier/manual/jpa-entities/
    // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    @Override
    public final int hashCode() {
        return Objects.hashCode(getId());
    }

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public final Long _id_() {
        return getId();
    }

    @Override
    public final void _id_(final Long _id_) {
        setId(_id_);
    }

    // -------------------------------------------------------------------------------------------------------------- id
    @SuppressWarnings({
            "unchecked"
    })
    SELF id(final Long id) {
        setId(id);
        return (SELF) this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = COLUMN_NAME_ID, nullable = false, insertable = false, updatable = false)
    private Long id;
}
