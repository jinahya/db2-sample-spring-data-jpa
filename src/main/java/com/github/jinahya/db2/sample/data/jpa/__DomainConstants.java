package com.github.jinahya.db2.sample.data.jpa;

@SuppressWarnings({
        "java:S114", // Interface names should comply with a naming convention
        "java:S119" // Type parameter names should comply with a naming convention
})
public final class __DomainConstants {

    // -----------------------------------------------------------------------------------------------------------------
    public static final long MIN_TINYINT = -128;

    public static final long MAX_TINYINT = +127;

    public static final long MAX_TINYINT_UNSIGNED = 255;

    // -----------------------------------------------------------------------------------------------------------------
    public static final long MIN_MEDIUM = -8388608;

    public static final long MAX_MEDIUM = +8388608;

    public static final long MAX_MEDIUM_UNSIGNED = 16777215;

    // -----------------------------------------------------------------------------------------------------------------
    public static final long MIN_SMALL_INT = -32768;

    public static final long MAX_SMALL_INT = +32767;

    public static final long MAX_SMALL_INT_UNSIGNED = 65535;

    // -----------------------------------------------------------------------------------------------------------------
    public static final long MIN_INT = -2147483648;

    public static final long MAX_INT = +2147483647;

    public static final long MAX_INT_UNSIGNED = 4294967295L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final long MIN_BIGINT = -9223372036854775808L; // Long.MIN_VALUE

    public static final long MAX_BIGINT = +9223372036854775807L; // Long.MAX_VALUE

    public static final String MAX_BIGINT_UNSIGNED = "18446744073709551615";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String DECIMAL_MIN_82 = "000000.00";

    public static final String DECIMAL_MAX_82 = "999999.99";

    // -----------------------------------------------------------------------------------------------------------------

    public static final String DECIMAL_MIN_LATITUDE = "-90.0";

    public static final String DECIMAL_MAX_LATITUDE = "+90.0";

    public static final String DECIMAL_MIN_LONGITUDE = "-180.0";

    public static final String DECIMAL_MAX_LONGITUDE = "+180.0";

    public static final long MIN_LATITUDE = -90L;

    public static final long MAX_LATITUDE = +90L;

    public static final long MIN_LONGITUDE = -180L;

    public static final long MAX_LONGITUDE = +180L;

    // -----------------------------------------------------------------------------------------------------------------
    private __DomainConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
