package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.util.Optional;

/**
 * An abstract mapped superclass for mapping {@value MappedDepartment#TABLE_NAME} table.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
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
public abstract class MappedDepartment<
        SELF extends MappedDepartment<SELF, EMPLOYEE>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, SELF>>
        extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = 6996788270622837133L;

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The name of the database table to which this entity maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "DEPARTMENT";

    // ---------------------------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the table column to which the {@link MappedDepartment_#deptno deptno} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    // ----------------------------------------------------------------------------------------------------------- MGRNO
    public static final String COLUMN_NAME_MGRNO = "MGRNO";

    // -------------------------------------------------------------------------------------------------------- ADMRDEPT

    // -------------------------------------------------------------------------------------------------------- LOCATION

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public final boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final String _id_() {
        return deptno;
    }

    @Override
    public final void _id_(final String _id_) {
        this.deptno = _id_;
    }

    // ---------------------------------------------------------------------------------------------------------- deptno

    // -------------------------------------------------------------------------------------------------------- deptname

    // ----------------------------------------------------------------------------------------------------------- mgrno

    // ------------------------------------------------------------------------------------------------------------- mgr
    public EMPLOYEE getMgr() {
        return mgr;
    }

    public void setMgr(final EMPLOYEE mgr) {
        setMgrno(
                Optional.ofNullable(mgr)
                        .map(MappedEmployee::getEmpno)
                        .orElse(null)
        );
    }

    // -------------------------------------------------------------------------------------------------------- admrdept

    // -------------------------------------------------------------------------------------------------------- location

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 3)
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_DEPTNO, nullable = false, insertable = true, updatable = false)
    private String deptno;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 36)
    @NotNull
    @Basic(optional = false)
    @Column(name = "DEPTNAME", nullable = false, insertable = true, updatable = true)
    private String deptname;

    @jakarta.annotation.Nullable
    @Size(max = 6)
    @Basic(optional = true)
    @Column(name = COLUMN_NAME_MGRNO, nullable = true, insertable = true, updatable = true)
    private String mgrno;

    @jakarta.annotation.Nullable
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_MGRNO, referencedColumnName = EMPLOYEE.COLUMN_NAME_EMPNO, nullable = true,
                insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private EMPLOYEE mgr;

    //    @Valid
//    @NotNull
    @org.hibernate.annotations.OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(
//            optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "ADMRDEPT", referencedColumnName = MappedDepartment.COLUMN_NAME_DEPTNO,
//                nullable = false,
                insertable = true, updatable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private SELF admrdept;

    @jakarta.annotation.Nullable
    @Size(max = 16)
    @Basic(optional = true)
    @Column(name = "LOCATION", nullable = true, insertable = true, updatable = true)
    private String location;
}