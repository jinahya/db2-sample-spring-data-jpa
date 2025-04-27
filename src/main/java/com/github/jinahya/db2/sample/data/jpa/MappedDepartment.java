package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedDepartment<SELF extends MappedDepartment<SELF>> extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = 6996788270622837133L;

    public static final String TABLE_NAME = "DEPARTMENT";

    // ---------------------------------------------------------------------------------------------------------- DEPTNO
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    // ----------------------------------------------------------------------------------------------------------- MGRNO

    // -------------------------------------------------------------------------------------------------------- ADMRDEPT

    // -------------------------------------------------------------------------------------------------------- LOCATION

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

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
    @NotNull
    @Basic(optional = true)
    @Column(name = "MGRNO", nullable = true, insertable = true, updatable = true)
    private String mgrno;

    @Valid
    @NotNull
    @org.hibernate.annotations.OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADMRDEPT", nullable = false, insertable = true, updatable = true)
    private SELF admrdept;

    @jakarta.annotation.Nullable
    @Size(max = 16)
    @Basic(optional = true)
    @Column(name = "LOCATION", nullable = true, insertable = true, updatable = true)
    private String location;
}