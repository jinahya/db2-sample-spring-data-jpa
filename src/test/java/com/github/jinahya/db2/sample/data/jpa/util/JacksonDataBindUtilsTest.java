package com.github.jinahya.db2.sample.data.jpa.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class JacksonDataBindUtilsTest {

    @Data
    @Builder
    private static class Person {

        private String name;

        private int age;
    }

    @Deprecated(forRemoval = true)
    @DisplayName("toArrayNode(mapper, values)")
    @Nested
    class ToArrayNodeTest {

        @Test
        void __Ints() {
            final var ints = List.of(0, 1);
            final var node = JacksonDatabindUtils.toArrayNode(new ObjectMapper(), ints);
            log.debug("int node: {}", node);
        }

        @Test
        void __Longs() {
            final var ints = List.of(0L, 1L);
            final var node = JacksonDatabindUtils.toArrayNode(new ObjectMapper(), ints);
            log.debug("int node: {}", node);
        }

        @Test
        void __Strings() {
            final var strings = List.of("a", "b");
            final var node = JacksonDatabindUtils.toArrayNode(new ObjectMapper(), strings);
            log.debug("string node: {}", node);
        }

        @Test
        void __People() {
            final var people = List.of(
                    Person.builder().name("a").age(0).build(),
                    Person.builder().name("b").age(1).build()
            );
            final var node = JacksonDatabindUtils.toArrayNode(new ObjectMapper(), people);
            log.debug("people node: {}", node);
        }
    }
}