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
public abstract class MappedProjactId<SELF extends MappedProjactId<SELF>>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 2835326446167509854L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    protected static <
            ENTITY extends MappedProjact<ENTITY, PROJECT, ACT, ID>,
            PROJECT extends MappedProject<PROJECT, ?, ?>,
            ACT extends MappedAct<ACT>,
            ID extends MappedProjactId<ID>
            >
    ID from(final ENTITY entity,
            final Supplier<? extends ID> supplier) {
        Objects.requireNonNull(entity, "entity is null");
        Objects.requireNonNull(supplier, "supplier is null");
        final var instance = Objects.requireNonNull(supplier.get(), "null supplied from " + supplier);
//        instance.setProject(entity.getProj());
//        instance.setAct(entity.getAct());
//        instance.setAcstdate(entity.getAcstdate());
        instance.setProjno(entity.getProjno());
        instance.setActno(entity.getActno());
        instance.setAcstdate(entity.getAcstdate());
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedProjactId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lanq.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
                "projno=" + projno +
                ",actno=" + actno +
                ",acstdate=" + acstdate +
                '}';
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final var that = (MappedProjactId<?>) obj;
        return Objects.equals(projno, that.projno) &&
                Objects.equals(actno, that.actno) &&
                Objects.equals(acstdate, that.acstdate);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(projno, actno, acstdate);
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
    public LocalDate getAcstdate() {
        return acstdate;
    }

    public void setAcstdate(final LocalDate acstdate) {
        this.acstdate = acstdate;
    }

    @SuppressWarnings({"unchecked"})
    public SELF acstdate(final LocalDate acstdate) {
        setAcstdate(acstdate);
        return (SELF) this;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private String projno;

    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    private Integer actno;

    @NotNull
    private LocalDate acstdate;
}