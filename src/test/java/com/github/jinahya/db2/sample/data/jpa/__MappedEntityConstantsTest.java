package com.github.jinahya.db2.sample.data.jpa;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class __MappedEntityConstantsTest {

    @Test
    void MAX_INT_UNSIGNED__() {
        final var expected = ((long) Math.pow(2, 32)) - 1L;
        assertThat(__MappedEntityConstants.MAX_INT_UNSIGNED).isEqualTo(expected);
    }

    //     public static final long MIN_LATITUDE = -90L;
    //
    //    public static final long MAX_LATITUDE = +90L;
    //
    //    public static final long MIN_LONGITUDE = -180L;
    //
    //    public static final long MAX_LONGITUDE = +180L;
    @Test
    void MIN_LATITUDE__() {
        final var expected = -90L;
        assertThat(__MappedEntityConstants.MIN_LATITUDE).isEqualTo(
                new BigDecimal(__MappedEntityConstants.DECIMAL_MIN_LATITUDE).longValue()
        );
    }

    @Test
    void MAX_LATITUDE__() {
        final var expected = -90L;
        assertThat(__MappedEntityConstants.MAX_LATITUDE).isEqualTo(
                new BigDecimal(__MappedEntityConstants.DECIMAL_MAX_LATITUDE).longValue()
        );
    }

    @Test
    void MIN_LONGITUDE__() {
        final var expected = -90L;
        assertThat(__MappedEntityConstants.MIN_LONGITUDE).isEqualTo(
                new BigDecimal(__MappedEntityConstants.DECIMAL_MIN_LONGITUDE).longValue()
        );
    }

    @Test
    void MAX_LONGITUDE__() {
        final var expected = -90L;
        assertThat(__MappedEntityConstants.MAX_LONGITUDE).isEqualTo(
                new BigDecimal(__MappedEntityConstants.DECIMAL_MAX_LONGITUDE).longValue()
        );
    }
}