package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Optional;

/**
 * .
 *
 * @param <SELF> self type parameter
 * @param <ID>   id type parameter
 * @see <a href="https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__xmpsal__title__1">SALES
 * table</a>
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
public abstract class MappedSales<SELF extends MappedSales<SELF, ID>, ID extends MappedSalesId<ID>>
        extends __MappedEntity<SELF, ID> {

    @Serial
    private static final long serialVersionUID = -8715546439135866685L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "SALES";

    // ------------------------------------------------------------------------------------------------------ SALES_DATE

    // ---------------------------------------------------------------------------------------------------- SALES_PERSON

    // ---------------------------------------------------------------------------------------------------------- REGION

    // ----------------------------------------------------------------------------------------------------------- SALES

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final void _id_(final ID _id_) {
        setSalesDate(
                Optional.ofNullable(_id_).map(MappedSalesId::getSalesDate).orElse(null)
        );
        setSalesPerson(
                Optional.ofNullable(_id_).map(MappedSalesId::getSalesPerson).orElse(null)
        );
        setRegion(
                Optional.ofNullable(_id_).map(MappedSalesId::getRegion).orElse(null)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Id
    @Basic(optional = true)
    @Column(name = "SALES_DATE", nullable = true, insertable = true, updatable = true)
    private LocalDate salesDate;

    @Size(max = 15)
    @Id
    @Basic(optional = true)
    @Column(name = "SALES_PERSON", nullable = true, insertable = true, updatable = true)
    private String salesPerson;

    @Size(max = 15)
    @Id
    @Basic(optional = true)
    @Column(name = "REGION", nullable = true, insertable = true, updatable = true)
    private String region;

    @Basic(optional = true)
    @Column(name = "SALES", nullable = true, insertable = true, updatable = true)
    private Integer sales;
}