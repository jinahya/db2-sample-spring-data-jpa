package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serial;
import java.util.Optional;

@IdClass(SalesId.class)
@Entity
@Table(name = MappedSales.TABLE_NAME)
public class Sales extends MappedSales<Sales, SalesId> {

    @Serial
    private static final long serialVersionUID = -6661815045576894003L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Sales() {
        super();
    }

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public SalesId _id_() {
        return MappedSalesId.from(this, SalesId::new);
    }

    // ----------------------------------------------------------------------------------------------- super.salesPerson
    @Transient
    public void setEmployee(final Employee employee) {
        setSalesPerson(
                Optional.ofNullable(employee).map(MappedEmployee::getLastname).orElse(null)
        );
    }
}