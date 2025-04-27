package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
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
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

// https://www.ibm.com/docs/en/db2-for-zos/12.0.0?topic=tables-project-table-dsn8c10proj
@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedProject<
        SELF extends MappedProject<SELF, DEPARTMENT, EMPLOYEE>,
        DEPARTMENT extends MappedDepartment<DEPARTMENT, EMPLOYEE>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, DEPARTMENT>>
        extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = 8130545690453228560L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "PROJECT";

    // ---------------------------------------------------------------------------------------------------------- PROJNO

    // -------------------------------------------------------------------------------------------------------- PROJNAME

    // ---------------------------------------------------------------------------------------------------------- DEPTNO
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    // --------------------------------------------------------------------------------------------------------- RESPEMP

    // --------------------------------------------------------------------------------------------------------- PRSTAFF

    // -------------------------------------------------------------------------------------------------------- PRSTDATE

    // -------------------------------------------------------------------------------------------------------- PRENDATE

    // --------------------------------------------------------------------------------------------------------- MAJPROJ

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
        return projno;
    }

    @Override
    public final void _id_(final String _id_) {
        this.projno = _id_;
    }

    // ---------------------------------------------------------------------------------------------------------- projno

    // -------------------------------------------------------------------------------------------------------- projname

    // ---------------------------------------------------------------------------------------------------------- deptno
    protected String getDeptno() {
        return deptno;
    }

    protected void setDeptno(final String deptno) {
        this.deptno = deptno;
    }

    // ------------------------------------------------------------------------------------------------------------ dept

    public DEPARTMENT getDept() {
        return dept;
    }

    public void setDept(final DEPARTMENT dept) {
        this.dept = dept;
        setDeptno(
                Optional.ofNullable(this.dept).map(MappedDepartment::getDeptno).orElse(null)
        );
    }

    // --------------------------------------------------------------------------------------------------------- respemp

    // --------------------------------------------------------------------------------------------------------- prstaff

    // -------------------------------------------------------------------------------------------------------- prstdate

    // -------------------------------------------------------------------------------------------------------- prendate

    // --------------------------------------------------------------------------------------------------------- majproj

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @Id
    @Basic(optional = false)
    @Column(name = "PROJNO", nullable = false, insertable = true, updatable = false)
    private String projno;

    @Size(max = 24)
    @NotNull
    @ColumnDefault("''")
    @Basic(optional = false)
    @Column(name = "PROJNAME", nullable = false, insertable = true, updatable = true)
    private String projname;

    @Size(max = 3)
    @NotNull
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_DEPTNO, nullable = false, insertable = true, updatable = true)
    private String deptno;

    @Valid
    @NotNull
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_DEPTNO, nullable = false, insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DEPARTMENT dept;

    // ID of employee responsible for the project
    @Valid
    @NotNull
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPEMP", referencedColumnName = MappedEmployee.COLUMN_NAME_EMPNO, nullable = false,
                insertable = true, updatable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private EMPLOYEE respemp;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PRSTAFF", nullable = true, insertable = true, updatable = true, precision = 5, scale = 2)
    private BigDecimal prstaff;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PRSTDATE", nullable = true, insertable = true, updatable = true)
    private LocalDate prstdate;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "PRENDATE", nullable = true, insertable = true, updatable = true)
    private LocalDate prendate;

    // ID of any project of which this project is a part
    @jakarta.annotation.Nullable
    @Valid
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "MAJPROJ", nullable = true, insertable = true, updatable = true)
    private SELF majproj;
}