package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public abstract class MappedEmpprojact<
        SELF extends MappedEmpprojact<SELF, EMPLOYEE, PROJECT, ACT, ID>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>,
        PROJECT extends MappedProject<PROJECT, ?, ?>,
        ACT extends MappedAct<ACT>,
        ID extends MappedEmpprojactId<ID>
        >
        extends __MappedEntity<SELF, ID> {

    @Serial
    private static final long serialVersionUID = -5197063440073394482L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "EMPPROJACT";

    // ---------------------------------------------------------------------------------------------------------- EMPNO
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    // ---------------------------------------------------------------------------------------------------------- PROJNO
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    // ----------------------------------------------------------------------------------------------------------- ACTNO
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    // --------------------------------------------------------------------------------------------------------- EMPTIME
    public static final String COLUMN_NAME_EMPTIME = "EMPTIME";

    // -------------------------------------------------------------------------------------------------------- EMSTDATE
    public static final String COLUMN_NAME_EMSTDATE = "EMSTDATE";

    // -------------------------------------------------------------------------------------------------------- EMENDATE
    public static final String COLUMN_NAME_EMENDATE = "EMENDATE";

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
    @Override
    public final void _id_(final ID _id_) {
        setEmpno(
                Optional.ofNullable(_id_)
                        .map(MappedEmpprojactId::getEmpno)
                        .orElse(null)
        );
        setProjno(
                Optional.ofNullable(_id_)
                        .map(MappedEmpprojactId::getProjno)
                        .orElse(null)
        );
        setActno(
                Optional.ofNullable(_id_)
                        .map(MappedEmpprojactId::getActno)
                        .orElse(null)
        );
        setEmstdate(
                Optional.ofNullable(_id_)
                        .map(MappedEmpprojactId::getEmstdate)
                        .orElse(null)
        );
    }

    // ---------------------------------------------------------------------------------------------------------- projno
    protected String getProjno() {
        return projno;
    }

    protected void setProjno(final String projno) {
        this.projno = projno;
    }

    // ------------------------------------------------------------------------------------------------------------ proj
    public PROJECT getProj() {
        return proj;
    }

    public void setProj(final PROJECT proj) {
        this.proj = proj;
        setProjno(
                Optional.ofNullable(this.proj)
                        .map(__MappedEntity::_id_)
                        .orElse(null)
        );
    }

    // ----------------------------------------------------------------------------------------------------------- actno

    protected Integer getActno() {
        return actno;
    }

    protected void setActno(final Integer actno) {
        this.actno = actno;
    }

    // ------------------------------------------------------------------------------------------------------------- act
    public ACT getAct() {
        return act;
    }

    public void setAct(final ACT act) {
        this.act = act;
        setActno(
                Optional.ofNullable(this.act)
                        .map(__MappedEntity::_id_)
                        .orElse(null)
        );
    }

    // --------------------------------------------------------------------------------------------------------- emptime

    // -------------------------------------------------------------------------------------------------------  emstdate

    // --------------------------------------------------------------------------------------------------------- emedate

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @NotNull
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_EMPNO, nullable = false, insertable = true, updatable = false)
    private String empno;

    @Valid
    @NotNull
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_EMPNO, nullable = false, insertable = false, updatable = false)
    private EMPLOYEE emp;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @NotNull
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_PROJNO, nullable = false, insertable = true, updatable = false)
    private String projno;

    @Valid
    @NotNull
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_PROJNO, nullable = false, insertable = false, updatable = false)
    private PROJECT proj;

    // -----------------------------------------------------------------------------------------------------------------
    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_ACTNO, nullable = false, insertable = true, updatable = false)
    private Integer actno;

    @Valid
    @NotNull
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_ACTNO, nullable = false, insertable = false, updatable = false)
    private ACT act;

    // -----------------------------------------------------------------------------------------------------------------
    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = COLUMN_NAME_EMPTIME, nullable = true, insertable = true, updatable = true, precision = 5, scale = 2)
    private BigDecimal emptime;

    @NotNull
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_EMSTDATE, nullable = false, insertable = true, updatable = false)
    private LocalDate emstdate;

    @jakarta.annotation.Nullable
    @Basic(optional = true)
    @Column(name = COLUMN_NAME_EMENDATE, nullable = true, insertable = true, updatable = true)
    private LocalDate emendate;
}