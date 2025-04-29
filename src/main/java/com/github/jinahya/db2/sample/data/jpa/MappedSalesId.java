package com.github.jinahya.db2.sample.data.jpa;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Supplier;

@Getter
@Setter
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedSalesId<SELF extends MappedSalesId<SELF>> implements Serializable {

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    public static <ID extends MappedSalesId<ID>> ID from(final MappedSales<?, ID> entity,
                                                         final Supplier<? extends ID> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        final var instance = Objects.requireNonNull(supplier.get(), "null supplied from " + supplier);
        instance.setSalesDate(entity.getSalesDate());
        instance.setSalesPerson(entity.getSalesPerson());
        instance.setRegion(entity.getRegion());
        return instance;
    }

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR
    protected MappedSalesId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "salesDate=" + salesDate +
                ",salesPerson=" + salesPerson +
                ",region=" + region +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final var that = (MappedSalesId<?>) obj;
        return Objects.equals(salesDate, that.salesDate) &&
                Objects.equals(salesPerson, that.salesPerson) &&
                Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesDate, salesPerson, region);
    }

    // ------------------------------------------------------------------------------------------------------- salesDate
    @Nullable
    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(@Nullable LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    // ----------------------------------------------------------------------------------------------------- salesPerson
    @Nullable
    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(@Nullable String salesPerson) {
        this.salesPerson = salesPerson;
    }

    // ---------------------------------------------------------------------------------------------------------- region
    @Nullable
    public String getRegion() {
        return region;
    }

    public void setRegion(@Nullable String region) {
        this.region = region;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @jakarta.annotation.Nullable
    private LocalDate salesDate;

    @jakarta.annotation.Nullable
    private String salesPerson;

    @jakarta.annotation.Nullable
    private String region;
}