package com.github.jinahya.db2.sample.data.jpa;

import com.github.jinahya.db2.sample.xml.bind.Product;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * An abstract mapped superclass for mapping {@value MappedProduct#TABLE_NAME} table.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a
 * href="https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__prodtab__title__1">PRODUCT
 * table</a>
 */
@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedProduct<SELF extends MappedProduct<SELF>> extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = -5702361452315201946L;

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The name of the database tabel to which this entity maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PRODUCT";

    // ------------------------------------------------------------------------------------------------------------- PID
    public static final String COLUMN_NAME_PID = "PID";
    // ------------------------------------------------------------------------------------------------------------ NAME

    // ----------------------------------------------------------------------------------------------------------- PRICE

    // ------------------------------------------------------------------------------------------------------ PROMOPRICE

    // ------------------------------------------------------------------------------------------------------ PROMOSTART

    // -------------------------------------------------------------------------------------------------------- PROMOEND

    // ----------------------------------------------------------------------------------------------------- DESCRIPTION

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object
//    @Override
//    public final boolean equals(final Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public final int hashCode() {
//        return super.hashCode();
//    }

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final String _id_() {
        return pid;
    }

    @Override
    public final void _id_(final String _id_) {
        pid = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 10)
    @Id
    @Column(name = COLUMN_NAME_PID, nullable = false, insertable = true, updatable = false)
    private String pid;

    @jakarta.annotation.Nullable
    @Size(max = 128)
    @Basic(optional = true)
    @Column(name = "NAME", nullable = true, insertable = true, updatable = true)
    private String name;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PRICE", nullable = true, insertable = true, updatable = true, precision = 30, scale = 2)
    private BigDecimal price;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PROMOPRICE", nullable = true, insertable = true, updatable = true, precision = 30, scale = 2)
    private BigDecimal promoprice;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PROMOSTART", nullable = true, insertable = true, updatable = true)
    private LocalDate promostart;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PROMOEND", nullable = true, insertable = true, updatable = true)
    private LocalDate promoend;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true)
    @JdbcTypeCode(SqlTypes.SQLXML)
    private Product description;
}