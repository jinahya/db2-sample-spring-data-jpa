package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.MapsId;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.Objects;
import java.util.Optional;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedEmpResume<
        SELF extends MappedEmpResume<SELF, ID, EMPLOYEE>,
        ID extends MappedEmpResumeId<ID>,
        EMPLOYEE extends MappedEmployee<EMPLOYEE, ?>>
        extends __MappedEntity<SELF, ID> {

    @Serial
    private static final long serialVersionUID = -6211777994724391726L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "EMP_RESUME";

    // ----------------------------------------------------------------------------------------------------------- EMPNO
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    // --------------------------------------------------------------------------------------------------- RESUME_FORMAT
    public static final String COLUMN_NAME_RESUME_FORMAT = "RESUME_FORMAT";

    // ---------------------------------------------------------------------------------------------------------- RESUME
    public static final String COLUMN_NAME_RESUME = "RESUME";

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR
    protected MappedEmpResume(final Class<ID> idClass) {
        super();
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Override
    public final ID _id_() {
        return id;
    }

    @Override
    public final void _id_(final ID _id_) {
        this.id = _id_;
    }

    // -------------------------------------------------------------------------------------------------------------- id
    public ID getId() {
        return Optional.ofNullable(id).orElseGet(() -> {
            try {
                final var constructor = idClass.getConstructor();
                if (!constructor.canAccess(null)) {
                    constructor.setAccessible(true);
                }
                setId(constructor.newInstance());
                return getId();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException("failed to instantiate " + idClass, roe);
            }
        });
    }

    public void setId(final ID id) {
        this.id = id;
    }

    // -------------------------------------------------------------------------------------------------------- employee
    public EMPLOYEE getEmployee() {
        return employee;
    }

    public void setEmployee(final EMPLOYEE employee) {
        this.employee = employee;
        if (false) {
            getId().setEmpno(
                    Optional.ofNullable(this.employee)
                            .map(__MappedEntity::_id_)
                            .orElse(null)
            );
        }
    }

    @SuppressWarnings({"unchecked"})
    public SELF employee(final EMPLOYEE employee) {
        setEmployee(employee);
        return (SELF) this;
    }

    // ---------------------------------------------------------------------------------------------------------- resume

    // -----------------------------------------------------------------------------------------------------------------
    @Transient
    private Class<ID> idClass;

    @EmbeddedId
    private ID id;

    @Valid
    @NotNull
    @MapsId("empno")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_EMPNO, nullable = false, insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private EMPLOYEE employee;

    @jakarta.annotation.Nullable
    @Size(max = 5120)
    @Lob
    @Basic(optional = true)
    @Column(name = COLUMN_NAME_RESUME, nullable = true, insertable = true, updatable = true)
    private String resume;
}