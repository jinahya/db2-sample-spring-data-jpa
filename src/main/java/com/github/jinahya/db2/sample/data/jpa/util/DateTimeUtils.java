package com.github.jinahya.db2.sample.data.jpa.util;

import lombok.extern.slf4j.Slf4j;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DateTimeUtils {

    /**
     * .
     *
     * @param amount .
     * @param unit   .
     * @return the value of {@code amount} in {@code unit}.
     * @see <a href="https://docs.oracle.com/en/java/javase//21/docs/api/java.base/java/util/concurrent/TimeUnit.html">
     * java.util.concurrent.TimeUnit</a>
     * @see <a
     * href="https://docs.oracle.com/en/java/javase//21/docs/api/java.base/java/time/temporal/TemporalUnit.html">java.time.temporal.TemporalUnit</a>
     * @see <a
     * href="https://docs.oracle.com/en/java/javase//21/docs/api/java.base/java/time/temporal/ChronoUnit.html">java.time.temporal.ChronoUnit</a>
     */
    public static long get(final TemporalAmount amount, final TimeUnit unit) {
        Objects.requireNonNull(amount, "amount is null");
        Objects.requireNonNull(unit, "unit is null");
        if (false) {
            return amount.get(unit.toChronoUnit());
        }
        return amount.getUnits()
                .stream()
                .filter(u -> u instanceof ChronoUnit)
                .map(u -> {
                    try {
                        return unit.convert(amount.get(u), TimeUnit.of((ChronoUnit) u));
                    } catch (final IllegalArgumentException iae) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("no supported (chrono) units; " + amount));
    }

    public static long get(final TemporalAmount amount, final ChronoUnit unit) {
        Objects.requireNonNull(amount, "amount is null");
        Objects.requireNonNull(unit, "unit is null");
        return get(amount, TimeUnit.of(unit));
    }

    private DateTimeUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
