package com.github.jinahya.db2.sample.data.jpa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedProductSupplierId<SELF extends MappedProductSupplierId<SELF>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 5474812877640857082L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS
    public static <
            ENTITY extends MappedProductSupplier<ENTITY, ID, ?, ?>,
            ID extends MappedProductSupplierId<ID>>
    ID from(final Supplier<? extends ID> supplier, final ENTITY entity) {
        Objects.requireNonNull(supplier, "supplier is null");
        Objects.requireNonNull(entity, "entity is null");
        final var instance = Objects.requireNonNull(supplier.get(), "null supplied from " + supplier);
        instance.setPid(entity.getPid());
        instance.setSid(entity.getSid());
        return instance;
    }

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR
    protected MappedProductSupplierId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
                "pid=" + pid +
                ",sid=" + sid +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final var that = (MappedProductSupplierId<?>) obj;
        return Objects.equals(pid, that.pid) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, sid);
    }

    // ------------------------------------------------------------------------------------------------------------- pid
    public String getPid() {
        return pid;
    }

    public void setPid(final String pid) {
        this.pid = pid;
    }

    // ------------------------------------------------------------------------------------------------------------- sid
    public String getSid() {
        return sid;
    }

    public void setSid(final String sid) {
        this.sid = sid;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 10)
    @NotNull
    private String pid;

    @Size(max = 10)
    @NotNull
    private String sid;
}