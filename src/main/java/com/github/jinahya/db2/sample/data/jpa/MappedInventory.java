package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedInventory<SELF extends MappedInventory<SELF>> extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = -6375557392673855599L;

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The name of the database tabel to which this entity class maps. The value is{@value}.
     */
    public static final String TABLE_NAME = "INVENTORY";

    // ------------------------------------------------------------------------------------------------------------- PID

    /**
     * The name of the tabel column to which the {@link MappedInventory_#pid pid} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_PID = "PID";

    // -------------------------------------------------------------------------------------------------------- QUANTITY

    // -------------------------------------------------------------------------------------------------------- LOCATION

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
    public final String _id_() {
        return pid;
    }

    @Override
    public final void _id_(final String _id_) {
        this.pid = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 10)
    @Id
    @Column(name = "PID", nullable = false, insertable = true, updatable = false)
    private String pid;

    // -----------------------------------------------------------------------------------------------------------------
    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "QUANTITY", nullable = true, insertable = true, updatable = true)
    private Integer quantity;

    @jakarta.annotation.Nullable
    @Size(max = 128)
    @Basic(optional = true)
    @Column(name = "LOCATION", nullable = true, insertable = true, updatable = true)
    private String location;
}