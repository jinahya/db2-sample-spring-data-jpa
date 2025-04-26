package com.github.jinahya.db2.sample.data.jpa.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.Objects;
import java.util.stream.StreamSupport;

public final class JacksonDatabindUtils {

    /**
     * .
     *
     * @param mapper .
     * @param values .
     * @param <T>    .
     * @return .
     * @deprecated Use {@link ObjectMapper#valueToTree(Object)} method.
     */
    @Deprecated(forRemoval = true)
    public static <T> ArrayNode toArrayNode(final ObjectMapper mapper, final Iterable<? extends T> values) {
        Objects.requireNonNull(mapper, "mapper is null");
        Objects.requireNonNull(values, "values is null");
        if (true) {
            return mapper.<ArrayNode>valueToTree(values);
        }
        return StreamSupport.stream(values.spliterator(), false)
                .<JsonNode>map(mapper::valueToTree)
                .reduce(
                        mapper.createArrayNode(),
                        ArrayNode::add,
                        (n1, n2) -> {
                            for (int i = 0; i < n1.size(); i++) {
                                n2.add(n2.get(i));
                            }
                            return n2;
                        }
                );
    }

    private JacksonDatabindUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
