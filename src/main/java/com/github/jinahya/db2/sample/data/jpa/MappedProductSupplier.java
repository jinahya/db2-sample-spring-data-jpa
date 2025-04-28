package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serial;
import java.util.Optional;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedProductSupplier<
        SELF extends MappedProductSupplier<SELF, ID, PRODUCT, SUPPLIER>,
        ID extends MappedProductSupplierId<ID>,
        PRODUCT extends MappedProduct<PRODUCT>,
        SUPPLIER extends MappedSupplier<SUPPLIER>
        >
        extends __MappedEntity<SELF, ID> {

    @Serial
    private static final long serialVersionUID = -3015625692622112895L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "PRODUCTSUPPLIER";

    // ------------------------------------------------------------------------------------------------------------- PID
    public static final String COLUMN_NAME_PID = "PID";

    // ------------------------------------------------------------------------------------------------------------- SID
    public static final String COLUMN_NAME_SID = "SID";

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
    @Override
    public final void _id_(final ID _id_) {
        setPid(
                Optional.ofNullable(_id_).map(MappedProductSupplierId::getPid).orElse(null)
        );
    }

    // ------------------------------------------------------------------------------------------------------------- pid
    public String getPid() {
        return pid;
    }

    public void setPid(final String pid) {
        this.pid = pid;
    }

    // --------------------------------------------------------------------------------------------------------- product

    public PRODUCT getProduct() {
        return product;
    }

    public void setProduct(final PRODUCT product) {
        this.product = product;
        setPid(
                Optional.ofNullable(product).map(__MappedEntity::_id_).orElse(null)
        );
    }

    // ------------------------------------------------------------------------------------------------------------- sid

    public String getSid() {
        return sid;
    }

    public void setSid(final String sid) {
        this.sid = sid;
    }

    // -------------------------------------------------------------------------------------------------------- supplier

    public SUPPLIER getSupplier() {
        return supplier;
    }

    public void setSupplier(final SUPPLIER supplier) {
        this.supplier = supplier;
        setSid(
                Optional.ofNullable(this.supplier).map(__MappedEntity::_id_).orElse(null)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    @Size(max = 10)
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_PID, nullable = false, insertable = true, updatable = false)
    private String pid;

    @Valid
    @NotFound(action = NotFoundAction.IGNORE) // -> EAGER!!!
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY // WON'T WORK!!!
               )
    @JoinColumn(name = COLUMN_NAME_PID, referencedColumnName = MappedProduct.COLUMN_NAME_PID, nullable = false,
                insertable = false, updatable = false)
    private PRODUCT product;

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    @Size(max = 10)
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_SID, nullable = false, insertable = true, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String sid;

    @Valid
    @NotFound(action = NotFoundAction.IGNORE) // -> EAGER!!!
    @ManyToOne(optional = false,
               fetch = FetchType.LAZY // WON'T WORK!!!
               )
    @JoinColumn(name = COLUMN_NAME_SID, referencedColumnName = MappedSupplier.COLUMN_NAME_SID, nullable = false,
                insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private SUPPLIER supplier;
}