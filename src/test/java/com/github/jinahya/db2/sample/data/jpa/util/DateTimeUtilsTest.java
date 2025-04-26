package com.github.jinahya.db2.sample.data.jpa.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.Period;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class DateTimeUtilsTest {

    @Nested
    class ConvertTest {

        @ValueSource(longs = {0L, 1L, 2L})
        @ParameterizedTest
        void minutes2seconds(final long minutes) {
            final var temporalAmount = Duration.ofMinutes(minutes);
            final var timeUnit = TimeUnit.SECONDS;
            final var converted = DateTimeUtils.get(temporalAmount, timeUnit);
            log.debug("minutes: {} -> seconds: {}", String.format("%4d", minutes), String.format("%4d", converted));
            final var expected = TimeUnit.MINUTES.toSeconds(minutes);
            assertThat(converted).isEqualTo(expected);
        }

        @ValueSource(longs = {0L, 1L, 2L, 59L, 60L, 61L})
        @ParameterizedTest
        void seconds2minutes(final long seconds) {
            final var temporalAmount = Duration.ofSeconds(seconds);
            final var timeUnit = TimeUnit.MINUTES;
            final var converted = DateTimeUtils.get(temporalAmount, timeUnit);
            log.debug("seconds: {} -> minutes: {}", String.format("%4d", seconds), String.format("%4d", converted));
            final var expected = TimeUnit.SECONDS.toMinutes(seconds);
            assertThat(converted).isEqualTo(expected);
        }

        @ValueSource(ints = {0, 1, 2})
        @ParameterizedTest
        void days2seconds(final int days) {
            final var temporalAmount = Period.ofDays(days);
            final var timeUnit = TimeUnit.SECONDS;
            final var converted = DateTimeUtils.get(temporalAmount, timeUnit);
            log.debug("days: {} -> seconds: {}", String.format("%4d", days), String.format("%6d", converted));
            final var expected = TimeUnit.DAYS.toSeconds(days);
            assertThat(converted).isEqualTo(expected);
        }

        @ValueSource(ints = {0, 86399, 86400, 172799, 172800})
        @ParameterizedTest
        void seconds2days(final int seconds) {
            final var temporalAmount = Duration.ofSeconds(seconds);
            final var timeUnit = TimeUnit.DAYS;
            final var converted = DateTimeUtils.get(temporalAmount, timeUnit);
            log.debug("seconds: {} -> days: {}", String.format("%6d", seconds), String.format("%4d", converted));
            final var expected = TimeUnit.SECONDS.toDays(seconds);
            assertThat(converted).isEqualTo(expected);
        }
    }
}