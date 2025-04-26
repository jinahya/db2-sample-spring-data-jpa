package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
public final class __DomainUtils {

    // ----------------------------------------------------------------------------------------------------- boolean/int
    public static boolean toBoolean(final long v) {
        return v != 0L;
    }

    public static long toLong(final boolean v) {
        return v ? 1L : 0L;
    }

    public static boolean toBoolean(final int v) {
        return toBoolean((long) v);
    }

    public static int toInt(final boolean v) {
        return Math.toIntExact(toLong(v));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @org.springframework.lang.NonNull
    @jakarta.annotation.Nonnull
    public static BigDecimal toBigDecimal(final double v) {
        return BigDecimal.valueOf(v);
    }

    public static double toInt(@org.springframework.lang.NonNull
                               @jakarta.annotation.Nonnull final BigDecimal v) {
        Objects.requireNonNull(v, "v is null");
        return v.doubleValue();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private __DomainUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}