package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Setter
@Getter
public abstract class __MappedEmbeddableGeographicLocation {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String COLUMN_NAME_LATITUDE = "latitude";

    public static final int COLUMN_PRECISION_LATITUDE = 10;

    public static final int COLUMN_SCALE_LATITUDE = 8;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String COLUMN_NAME_LONGITUDE = "longitude";

    public static final int COLUMN_PRECISION_LONGITUDE = 11;

    public static final int COLUMN_SCALE_LONGITUDE = 8;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String COLUMN_NAME_ALTITUDE = "altitude";

    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- latitude
    @Transient
    protected Double getLatitudeAsDouble() {
        return Optional.ofNullable(getLatitude())
                .map(BigDecimal::doubleValue).
                orElse(null);
    }

    protected void setLatitudeAsDouble(final Double latitudeAsDouble) {
        setLatitude(
                Optional.ofNullable(latitudeAsDouble)
                        .map(BigDecimal::valueOf)
                        .orElse(null)
        );
    }

    // ------------------------------------------------------------------------------------------------------- longitude
    @Transient
    protected Double getLongitudeAsDouble() {
        return Optional.ofNullable(getLongitude())
                .map(BigDecimal::doubleValue).
                orElse(null);
    }

    protected void setLongitudeAsDouble(final Double longitudeAsDouble) {
        setLongitude(
                Optional.ofNullable(longitudeAsDouble)
                        .map(BigDecimal::valueOf)
                        .orElse(null)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DecimalMax(__MappedEntityConstants.DECIMAL_MAX_LATITUDE)
    @DecimalMin(__MappedEntityConstants.DECIMAL_MIN_LATITUDE)
    @NotNull
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_LATITUDE, nullable = false, insertable = true, updatable = true,
            precision = COLUMN_PRECISION_LATITUDE, scale = COLUMN_SCALE_LATITUDE)
    private BigDecimal latitude;

    @DecimalMax(__MappedEntityConstants.DECIMAL_MAX_LONGITUDE)
    @DecimalMin(__MappedEntityConstants.DECIMAL_MIN_LONGITUDE)
    @NotNull
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_LONGITUDE, nullable = false, insertable = true, updatable = true,
            precision = COLUMN_PRECISION_LONGITUDE, scale = COLUMN_SCALE_LONGITUDE)
    private BigDecimal longitude;
}
