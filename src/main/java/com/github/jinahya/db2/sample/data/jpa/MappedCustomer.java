package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
public abstract class MappedCustomer<SELF extends MappedCustomer<SELF>> extends __MappedEntity<SELF, Long> {

    @Serial
    private static final long serialVersionUID = -7164971232942982662L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "CUSTOMER";

    // ------------------------------------------------------------------------------------------------------------- CID
    public static final String COLUMN_NAME_CID = "CID";

    // ------------------------------------------------------------------------------------------------------------ INFO
    public static final String COLUMN_NAME_INFO = "INFO";

    // --------------------------------------------------------------------------------------------------------- HISTORY
    public static final String COLUMN_NAME_HISTORY = "HISTORY";

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object
//    @Override
//    public final boolean equals(final Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public final int hashCode() {
//        return super.hashCode();
//    }

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final Long _id_() {
        return cid;
    }

    @Override
    public final void _id_(final Long _id_) {
        cid = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_CID, nullable = false, insertable = true, updatable = false)
    private Long cid;

    @jakarta.annotation.Nullable
    @JdbcTypeCode(SqlTypes.SQLXML)
    @Column(name = COLUMN_NAME_INFO, nullable = true, insertable = true, updatable = true, unique = true)
    private com.github.jinahya.db2.sample.xml.bind.Customerinfo info;

    @jakarta.annotation.Nullable
    @Column(name = COLUMN_NAME_HISTORY, nullable = true, insertable = true, updatable = true, unique = true)
    @JdbcTypeCode(SqlTypes.SQLXML)
    private Object history;
}