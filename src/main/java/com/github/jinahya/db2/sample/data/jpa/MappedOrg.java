package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

/**
 * An abstract mapped superclass for mapping {@link MappedOrg#TABLE_NAME} table.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__os2org__title__1">ORG
 * table</a>
 */
@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedOrg<SELF extends MappedOrg<SELF>> extends __MappedEntity<SELF, Integer> {

    @Serial
    private static final long serialVersionUID = 5064914616167966528L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "ORG";

    // -------------------------------------------------------------------------------------------------------- DEPTNUMB
    public static final String COLUMN_NAME_DEPTNUMB = "DEPTNUMB";

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    // --------------------------------------------------------------------------------------------------------- MANAGER
    public static final String COLUMN_NAME_MANAGER = "MANAGER";

    // -------------------------------------------------------------------------------------------------------- DIVISION

    // -------------------------------------------------------------------------------------------------------- LOCATION

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    /**
     * Creates a new instance.
     */
    protected MappedOrg() {
        super();
    }

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
    public final Integer _id_() {
        return deptnumb;
    }

    @Override
    public final void _id_(final Integer _id_) {
        this.deptnumb = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_DEPTNUMB, nullable = false, insertable = true, updatable = false)
    private Integer deptnumb;

    @Size(max = 14)
    @Basic(optional = true)
    @Column(name = "DEPTNAME", nullable = true, insertable = true, updatable = true)
    private String deptname;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "MANAGER", nullable = true, insertable = true, updatable = true)
    private Short manager;

    @jakarta.annotation.Nullable
    @Size(max = 10)
    @Basic(optional = true)
    @Column(name = "DIVISION", nullable = true, insertable = true, updatable = true)
    private String division;

    @jakarta.annotation.Nullable
    @Size(max = 13)
    @Basic(optional = true)
    @Column(name = "LOCATION", nullable = true, insertable = true, updatable = true)
    private String location;
}