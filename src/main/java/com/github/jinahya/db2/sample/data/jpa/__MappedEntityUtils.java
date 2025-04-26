package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A utility class for {@link __MappedEntity} class.
 *
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@Slf4j
@SuppressWarnings({
        "java:S101"
})
public final class __MappedEntityUtils {

    @SuppressWarnings({
            "unchecked",
            "java:S119" // Type parameter names should comply with a naming convention
    })
    public static <ID extends Serializable>
    Class<ID> resolveIdClass(final Class<? extends __MappedEntity<?, ?>> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        final Class<?> resolved = ResolvableType
                .forClass(entityClass)
                .as(__MappedEntity.class)
                .getGeneric(1)
                .resolve();
        return (Class<ID>) Optional.ofNullable(resolved).orElseThrow(
                () -> new IllegalArgumentException("failed to resolve id class from " + entityClass)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static String join(final Collection<String> collection, final String delimiter, final boolean strip,
                              final boolean nonblank) {
        Objects.requireNonNull(collection, "collection is null");
        Objects.requireNonNull(delimiter, "delimiter is null");
        return collection.stream()
                .map(v -> strip ? v.strip() : v)
                .filter(v -> nonblank ? !v.isBlank() : true)
                .collect(Collectors.joining(delimiter));
    }

    public static Stream<String> split(final String joined, final String delimiter, final boolean strip,
                                       final boolean nonblank) {
        Objects.requireNonNull(joined, "joined is null");
        Objects.requireNonNull(delimiter, "delimiter is null");
        return Arrays.stream(joined.split(delimiter))
                .map(v -> strip ? v.strip() : v)
                .filter(v -> nonblank ? !v.isBlank() : true)
                ;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance, my ass.
     */
    private __MappedEntityUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
