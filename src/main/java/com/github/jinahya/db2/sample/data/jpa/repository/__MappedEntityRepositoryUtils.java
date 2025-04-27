package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

import java.util.Objects;
import java.util.Optional;

/**
 * A utility class for {@link __MappedEntityRepository} class.
 *
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
@Slf4j
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119" // Type parameter names should comply with a naming convention
})
public final class __MappedEntityRepositoryUtils {

    /**
     * Resolves the class of {@link ENTITY} type from specified repository class.
     *
     * @param repositoryClass the repository class.
     * @param <ENTITY>        entity type parameter
     * @return the class of {@link ENTITY} type of {@code repositoryClass}.
     * @see com.github.jinahya.db2.sample.data.jpa.__MappedEntityUtils#resolveIdClass(Class)
     */
    @SuppressWarnings({"unchecked"})
    public static <ENTITY extends __MappedEntity<ENTITY, ?>>
    Class<ENTITY> resolveEntiyClass(final Class<? extends __MappedEntityRepository<?, ?>> repositoryClass) {
        Objects.requireNonNull(repositoryClass, "repositoryClass is null");
        final var resolved = ResolvableType
                .forClass(repositoryClass)
                .as(__MappedEntityRepository.class)
                .getGeneric(0)
                .resolve();
        return (Class<ENTITY>) Optional.ofNullable(resolved).orElseThrow(
                () -> new IllegalArgumentException("failed to resolve entity class from " + repositoryClass)
        );
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance, my ass.
     */
    private __MappedEntityRepositoryUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
