package com.github.jinahya.db2.sample.data.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public final class JacksonTestUtils {

    public static JsonNode randomJsonNode(final ObjectMapper objectMapper) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            final var node = objectMapper.createArrayNode();
            IntStream.range(0, 9).forEach(node::add);
            return node;
        } else {
            final var node = objectMapper.createObjectNode();
            IntStream.range(0, 9).forEach(i -> node.put(Integer.toString(i), i));
            node.set("child", randomJsonNode(objectMapper));
            return node;
        }
    }

    public static JsonNode randomArrayNode(final ObjectMapper objectMapper) {
        final var node = objectMapper.createArrayNode();
        IntStream.range(0, 9).forEach(node::add);
        return node;
    }

    public static JsonNode randomObjectNode(final ObjectMapper objectMapper) {
        final var node = objectMapper.createObjectNode();
        IntStream.range(0, 9).forEach(i -> node.put(Integer.toString(i), i));
        return node;
    }

    private JacksonTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}