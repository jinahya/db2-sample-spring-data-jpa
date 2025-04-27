package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
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

import java.io.Serial;

// https://www.ibm.com/docs/en/db2-for-zos/12.0.0?topic=tables-activity-table-dsn8c10act
@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedAct<SELF extends MappedAct<SELF>> extends __MappedEntity<SELF, Integer> {

    public static final String TABLE_NAME = "ACT";

    @Serial
    private static final long serialVersionUID = -7517869559169108587L;

    // ----------------------------------------------------------------------------------------------------------- ACTNO
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    // ---------------------------------------------------------------------------------------------------------- ACTKWD
    public static final String COLUMN_NAME_ACTKWD = "ACTKWD";
    // --------------------------------------------------------------------------------------------------------- ACTDESC

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final Integer _id_() {
        return actno;
    }

    @Override
    public final void _id_(final Integer _id_) {
        this.actno = _id_;
    }

    // ------------------------------------------------------------------------------------------------------------- ACT

    // ---------------------------------------------------------------------------------------------------------- ACTKWD

    // --------------------------------------------------------------------------------------------------------- ACTDESC

    // -----------------------------------------------------------------------------------------------------------------
    @Max(__DomainConstants.MAX_SMALL_INT)
    @Min(__DomainConstants.MIN_SMALL_INT)
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_ACTNO, nullable = false, insertable = true, updatable = true)
    private Integer actno;

//    @MapsId
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @OnDelete(action = OnDeleteAction.RESTRICT)
//    @JoinColumn(name = COLUMN_NAME_ACTNO, nullable = false)
//    private SELF act;

    @Size(max = 6)
    @NotNull
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_ACTKWD, nullable = false, insertable = true, updatable = true)
    private String actkwd;

    @Size(max = 20)
    @NotNull
    @Basic(optional = false)
    @Column(name = "ACTDESC", nullable = false, insertable = true, updatable = true)
    private String actdesc;
}