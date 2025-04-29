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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;

@MappedSuperclass
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedCatalog<SELF extends MappedCatalog<SELF>> extends __MappedEntity<SELF, String> {

    @Serial
    private static final long serialVersionUID = 1976076452444952744L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "CATALOG";

    // ------------------------------------------------------------------------------------------------------------ NAME
    public static final String COLUMN_NAME_NAME = "NAME";

    // ---------------------------------------------------------------------------------------------------------- CATLOG
    public static final String COLUMN_NAME_CATLOG = "CATLOG";
    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ----------------------------------------------------------------------------------------------------- CONSTRUCTOR

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // ------------------------------------------------------------------------------------------------------ super._id_
    @Transient
    @Override
    public final String _id_() {
        return name;
    }

    @Override
    public final void _id_(final String _id_) {
        name = _id_;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 128)
    @Id
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_NAME, nullable = false, insertable = true, updatable = false)
    private String name;

    @jakarta.annotation.Nullable
    @JdbcTypeCode(SqlTypes.SQLXML)
    @Basic(optional = true)
    @Column(name = COLUMN_NAME_CATLOG, nullable = true, insertable = true, updatable = true)
    private com.github.jinahya.db2.sample.xml.bind.Catalog catlog;
}