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
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedEmployee<
        SELF extends MappedEmployee<SELF, DEPARTMENT>,
        DEPARTMENT extends MappedDepartment<DEPARTMENT, SELF>>
        extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = 2903588977083308289L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "EMPLOYEE";

    // ----------------------------------------------------------------------------------------------------------- EMPNO
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    // -------------------------------------------------------------------------------------------------------- FIRSTNME

    // --------------------------------------------------------------------------------------------------------- MIDINIT

    // -------------------------------------------------------------------------------------------------------- LASTNAME

    // -------------------------------------------------------------------------------------------------------- WORKDEPT
    public static final String COLUMN_NAME_WORKDEPT = "WORKDEPT";

    // --------------------------------------------------------------------------------------------------------- PHONENO

    // -------------------------------------------------------------------------------------------------------- HIREDATE

    // ------------------------------------------------------------------------------------------------------------- JOB

    // --------------------------------------------------------------------------------------------------------- EDLEVEL

    // ------------------------------------------------------------------------------------------------------------- SEX

    // ------------------------------------------------------------------------------------------------------- BIRTHDATE

    // ---------------------------------------------------------------------------------------------------------- SALARY

    // ----------------------------------------------------------------------------------------------------------- BONUS

    // ------------------------------------------------------------------------------------------------------------ COMM

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
        return empno;
    }

    @Override
    public final void _id_(final String _id_) {
        this.empno = _id_;
    }

    // ----------------------------------------------------------------------------------------------------------- empno
    // ------------------------------------------------------------------------------------------------------- firstnme
    // ------------------------------------------------------------------------------------------------------- midinit
    // ------------------------------------------------------------------------------------------------------- lastname

    // -------------------------------------------------------------------------------------------------------- workdept

    // ------------------------------------------------------------------------------------------------------- phoneno
    // ------------------------------------------------------------------------------------------------------- hiredate
    // ------------------------------------------------------------------------------------------------------- job
    // ------------------------------------------------------------------------------------------------------- edlevel
    // ------------------------------------------------------------------------------------------------------- sex
    // ------------------------------------------------------------------------------------------------------- birthdate
    // ------------------------------------------------------------------------------------------------------- salary
    // ------------------------------------------------------------------------------------------------------- bonus
    // ------------------------------------------------------------------------------------------------------- comm

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_EMPNO, nullable = false, insertable = true, updatable = false)
    private String empno;

    @Size(max = 12)
    @NotNull
    @Basic(optional = false)
    @Column(name = "FIRSTNME", nullable = false, insertable = true, updatable = true)
    private String firstnme;

    @jakarta.annotation.Nullable
    @Size(max = 1)
    @Basic(optional = true)
    @Column(name = "MIDINIT", nullable = true, insertable = true, updatable = true)
    private String midinit;

    @Size(max = 15)
    @NotNull
    @Basic(optional = false)
    @Column(name = "LASTNAME", nullable = false, insertable = true, updatable = true)
    private String lastname;

//    @jakarta.annotation.Nullable
//    @Valid
//    @Basic(optional = true)
//    @Column(name = COLUMN_NAME_WORKDEPT, nullable = true, insertable = true, updatable = true)
//    private String workdept;

    @jakarta.annotation.Nullable
    @Valid
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_WORKDEPT, referencedColumnName = MappedDepartment.COLUMN_NAME_DEPTNO,
                nullable = true, insertable = true, updatable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DEPARTMENT workdept;

    @Size(max = 4)
    @Basic(optional = true)
    @Column(name = "PHONENO", nullable = true, insertable = true, updatable = true)
    private String phoneno;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "HIREDATE", nullable = true, insertable = true, updatable = true)
    private LocalDate hiredate;

    @jakarta.annotation.Nullable
    @Size(max = 8)
    @Basic(optional = true)
    @Column(name = "JOB", nullable = true, insertable = true, updatable = true)
    private String job;

    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    @Basic(optional = false)
    @Column(name = "EDLEVEL", nullable = false, insertable = true, updatable = true)
    private Short edlevel;

    @jakarta.annotation.Nullable
    @Size(max = 1)
    @Basic(optional = true)
    @Column(name = "SEX", nullable = true, insertable = true, updatable = true)
    private String sex;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = "BIRTHDATE", nullable = true, insertable = true, updatable = true)
    private LocalDate birthdate;

    @jakarta.annotation.Nullable
    @DecimalMax("9999999.99")
    @Basic(optional = true)
    @Column(name = "SALARY", nullable = true, insertable = true, updatable = true, precision = 9, scale = 2)
    private BigDecimal salary;

    @jakarta.annotation.Nullable
    @DecimalMax("9999999.99")
    @Basic(optional = true)
    @Column(name = "BONUS", nullable = true, insertable = true, updatable = true, precision = 9, scale = 2)
    private BigDecimal bonus;

    @jakarta.annotation.Nullable
    @DecimalMax("9999999.99")
    @Basic(optional = true)
    @Column(name = "COMM", nullable = true, insertable = true, updatable = true, precision = 9, scale = 2)
    private BigDecimal comm;
}