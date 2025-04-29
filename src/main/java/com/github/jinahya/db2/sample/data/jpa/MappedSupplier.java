package com.github.jinahya.db2.sample.data.jpa;

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

/**
 * .
 *
 * @param <SELF> self type parameter
 * @see <a
 * href="https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__suptab__title__1">SUPPLIERS
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
public abstract class MappedSupplier<SELF extends MappedSupplier<SELF>> extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = -9190228576742524541L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "SUPPLIERS";

    // ------------------------------------------------------------------------------------------------------------- SID
    public static final String COLUMN_NAME_SID = "SID";

    // ------------------------------------------------------------------------------------------------------------ ADDR
    public static final String COLUMN_NAME_ADDR = "ADDR";

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
        return sid;
    }

    @Override
    public final void _id_(final String _id_) {
        this.sid = _id_;
    }

    // ------------------------------------------------------------------------------------------------------------- sid

    // ------------------------------------------------------------------------------------------------------------ addr

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 10)
    @Id
    @Column(name = COLUMN_NAME_SID, nullable = false, insertable = true, updatable = false)
    private String sid;

    @jakarta.annotation.Nullable
    @JdbcTypeCode(SqlTypes.SQLXML)
    @Column(name = COLUMN_NAME_ADDR, nullable = true, insertable = true, updatable = true)
    private com.github.jinahya.db2.sample.xml.bind.Supplierinfo addr;
}