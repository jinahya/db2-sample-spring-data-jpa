package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.time.LocalDate;

/**
 * @param <SELF>     self type parameter
 * @param <CUSTOMER> customer type parameter
 * @see <a
 * href="https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__potab__title__1">PURCHASEORDER
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
public abstract class MappedPurchaseOrder<
        SELF extends MappedPurchaseOrder<SELF, CUSTOMER>,
        CUSTOMER extends MappedCustomer<CUSTOMER>>
        extends __MappedEntity<SELF, Long> {

    @Serial
    private static final long serialVersionUID = 4262849538176652654L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "PURCHASEORDER";

    // ------------------------------------------------------------------------------------------------------------ POID
    public static final String COLUMN_NAME_POID = "POID";

    // ---------------------------------------------------------------------------------------------------------- STATUS
    public static final String COLUMN_NAME_STATUS = "STATUS";

    public static final String COLUMN_VALUE_UNSHIPPED = "Unshipped";

    public static final String COLUMN_VALUE_SHIPPED = "Shipped";

    // ---------------------------------------------------------------------------------------------------------- CUSTID
    public static final String COLUMN_NAME_CUSTID = "CUSTID";

    // ------------------------------------------------------------------------------------------------------- ORDERDATE

    // ---------------------------------------------------------------------------------------------------------- PORDER

    // -------------------------------------------------------------------------------------------------------- COMMENTS

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public final Long _id_() {
        return poid;
    }

    @Override
    public final void _id_(final Long _id_) {
        this.poid = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_POID, nullable = false, insertable = true, updatable = false)
    private Long poid;

    @Size(max = 10)
    @NotNull
    @ColumnDefault("'" + COLUMN_VALUE_UNSHIPPED + "'")
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_STATUS, nullable = false, insertable = true, updatable = true)
    private String status = COLUMN_VALUE_UNSHIPPED;

    @Basic(optional = false)
    @Column(name = COLUMN_NAME_CUSTID, nullable = false, insertable = true, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PROTECTED)
    private Long custid;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = COLUMN_NAME_CUSTID, nullable = false, insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CUSTOMER customer;

    @jakarta.annotation.Nullable
    @Basic(optional = false)
    @Column(name = "ORDERDATE", nullable = true, insertable = true, updatable = true)
    private LocalDate orderdate;

    @JdbcTypeCode(SqlTypes.SQLXML)
    @Column(name = "PORDER", nullable = true, insertable = true, updatable = true)
    private com.github.jinahya.db2.sample.xml.bind.PurchaseOrder porder;

    @jakarta.annotation.Nullable
    @Size(max = 1000)
    @Basic(optional = true)
    @Column(name = "COMMENTS", nullable = true, insertable = true, updatable = true)
    private String comments;
}