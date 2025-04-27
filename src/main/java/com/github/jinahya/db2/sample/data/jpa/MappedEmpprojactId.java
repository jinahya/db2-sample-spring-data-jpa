package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Embeddable
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedEmpprojactId<SELF extends MappedEmpprojactId<SELF>>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = -2824267908900680994L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    protected static <
            ENTITY extends MappedEmpprojact<ENTITY, EMPLOYEE, PROJECT, ACT, ID>,
            EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>,
            PROJECT extends MappedProject<PROJECT, ?, ?>,
            ACT extends MappedAct<ACT>,
            ID extends MappedEmpprojactId<ID>
            >
    ID from(final ENTITY entity,
            final Supplier<? extends ID> supplier) {
        Objects.requireNonNull(entity, "entity is null");
        Objects.requireNonNull(supplier, "supplier is null");
        final var instance = Objects.requireNonNull(supplier.get(), "null supplied from " + supplier);
        instance.setEmpno(entity.getEmpno());
        instance.setProjno(entity.getProjno());
        instance.setActno(entity.getActno());
        instance.setEmstdate(entity.getEmendate());
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpprojactId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lanq.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
                "empno=" + empno +
                ",projno=" + projno +
                ",actno=" + actno +
                ",emendate=" + emstdate +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        final var that = (MappedEmpprojactId<?>) obj;
        return Objects.equals(empno, that.empno) &&
                Objects.equals(projno, that.projno) &&
                Objects.equals(actno, that.actno) &&
                Objects.equals(emstdate, that.emstdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, projno, actno, emstdate);
    }

    // ----------------------------------------------------------------------------------------------------------- empno
    public String getEmpno() {
        return empno;
    }

    public void setEmpno(final String empno) {
        this.empno = empno;
    }

    @SuppressWarnings({"unchecked"})
    public SELF empno(final String empno) {
        setEmpno(empno);
        return (SELF) this;
    }

    // ------------------------------------------------------------------------------------------------------------- emp
    @Transient
    public <EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>> void setEmployee(final EMPLOYEE empect) {
        setEmpno(
                Optional.ofNullable(empect)
                        .map(__MappedEntity::_id_)
                        .orElse(null)
        );
    }

    @SuppressWarnings({"unchecked"})
    public <EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>> SELF employee(final EMPLOYEE employee) {
        setEmployee(employee);
        return (SELF) this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Transient
    public void setProjActId(final MappedProjactId<?> projActId) {
        Objects.requireNonNull(projActId, "projActId is null");
        setProjno(projActId.getProjno());
        setActno(projActId.getActno());
        setEmstdate(projActId.getAcstdate());
    }

    @SuppressWarnings({"unchecked"})
    public SELF projActId(final MappedProjactId<?> projActId) {
        setProjActId(projActId);
        return (SELF) this;
    }

    // ---------------------------------------------------------------------------------------------------------- projno
    public String getProjno() {
        return projno;
    }

    public void setProjno(final String projno) {
        this.projno = projno;
    }

    @SuppressWarnings({"unchecked"})
    public SELF projno(final String projno) {
        setProjno(projno);
        return (SELF) this;
    }

    // ------------------------------------------------------------------------------------------------------------ proj
    @Transient
    public <PROJECT extends MappedProject<PROJECT, ?, ?>> void setProject(final PROJECT project) {
        setProjno(
                Optional.ofNullable(project)
                        .map(__MappedEntity::_id_)
                        .orElse(null)
        );
    }

    @SuppressWarnings({"unchecked"})
    public <PROJECT extends MappedProject<PROJECT, ?, ?>> SELF project(final PROJECT project) {
        setProject(project);
        return (SELF) this;
    }

    // ----------------------------------------------------------------------------------------------------------- actno
    public Integer getActno() {
        return actno;
    }

    public void setActno(final Integer actno) {
        this.actno = actno;
    }

    @SuppressWarnings({"unchecked"})
    public SELF actno(final Integer actno) {
        setActno(actno);
        return (SELF) this;
    }

    // ------------------------------------------------------------------------------------------------------------- act
    @Transient
    public <ACT extends MappedAct<ACT>> void setAct(final ACT act) {
        setActno(
                Optional.ofNullable(act)
                        .map(__MappedEntity::_id_)
                        .orElse(null)
        );
    }

    @SuppressWarnings({"unchecked"})
    public <ACT extends MappedAct<ACT>> SELF act(final ACT act) {
        setAct(act);
        return (SELF) this;
    }

    // -------------------------------------------------------------------------------------------------------- acstdate

    public LocalDate getEmstdate() {
        return emstdate;
    }

    public void setEmstdate(final LocalDate emendate) {
        this.emstdate = emendate;
    }

    @SuppressWarnings({"unchecked"})
    public SELF emstdate(final LocalDate emstdate) {
        setEmstdate(emstdate);
        return (SELF) this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private String empno;

    @NotNull
    private String projno;

    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    private Integer actno;

    @NotNull
    private LocalDate emstdate;
}