package com.github.jinahya.db2.sample.data.jpa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.jinahya.db2.sample.data.util.BeanValidationTestUtils;
import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.spy;

@Slf4j
public abstract class __MappedEntity_Test<ENTITY extends __MappedEntity<ENTITY, ID>, ID extends Serializable> {

    protected __MappedEntity_Test(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a stream of {@link ENTITY} to test.
     *
     * @return a stream of {@link ENTITY}.
     */
    protected Stream<ENTITY> entityInstances_() {
        return Stream.of(
                        newEntityInstance(),
                        newRandomizedEntityInstance().orElse(null)
                )
                .filter(Objects::nonNull);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class ToStringTest {

        private Stream<ENTITY> entityInstances() {
            return entityInstances_();
        }

        @MethodSource({"entityInstances"})
        @ParameterizedTest
        void _NotBlank_(final ENTITY entityInstance) {
            // --------------------------------------------------------------------------------------------------- given
            // ---------------------------------------------------------------------------------------------------- when
            final var string = entityInstance.toString();
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(string).isNotBlank();
        }
    }

    // ------------------------------------------------------------------------------------------------- equals/hashCode
    @DisplayName("equals/hashCode")
    @Test
    protected void equals_verify_() {
        equalsVerifier().verify();
    }

    protected SingleTypeEqualsVerifierApi<ENTITY> equalsVerifier() {
        final var redNode = JsonNodeFactory.instance.objectNode();
        {
            redNode.put("color", "redNode");
        }
        final var blueNode = JsonNodeFactory.instance.objectNode();
        {
            blueNode.put("color", "blueNode");
        }
        return EqualsVerifier
                .forClass(entityClass)
                .suppress(Warning.SURROGATE_KEY)
                .suppress(Warning.STRICT_HASHCODE)
                ;
    }

    // ------------------------------------------------------------------------------------------------- getters/setters
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class AccessorsTest {

        private Stream<ENTITY> entityInstances() {
            return entityInstances_();
        }

        @DisplayName("setXxx(getXxx())")
        @MethodSource({
                "entityInstances"
        })
        @ParameterizedTest
        void accessors(final ENTITY instance)
                throws IntrospectionException, InvocationTargetException, IllegalAccessException {
            final var info = Introspector.getBeanInfo(entityClass);
            for (final var descriptor : info.getPropertyDescriptors()) {
                final var reader = descriptor.getReadMethod();
                if (reader == null) {
                    continue;
                }
                if (!reader.canAccess(instance)) {
                    reader.setAccessible(true);
                }
                final var value = reader.invoke(instance);
                final var writer = descriptor.getWriteMethod();
                if (writer == null) {
                    continue;
                }
                if (!writer.canAccess(instance)) {
                    writer.setAccessible(true);
                }
                assertThatCode(() -> {
                    writer.invoke(instance, value);
                })
                        .as("%s(%s)", writer.getName(), value)
                        .doesNotThrowAnyException();
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------- entityClass
    protected ENTITY newEntityInstance() {
        return __MappedEntity_Test_Utils.newEntityInstanceOf(entityClass);
    }

    protected ENTITY newEntitySpy() {
        return spy(newEntityInstance());
    }

    protected Optional<ENTITY> newRandomizedEntityInstance() {
        try {
            final ENTITY entityInstance = __MappedEntity_Randomizer_Utils.newRandomizedInstanceOf(entityClass);
            final var constraintViolations = BeanValidationTestUtils.validate(entityInstance);
            constraintViolations.forEach(cv -> {
                log.warn("constraint violations, on a randomized entity instance: {}", cv);
            });
            return Optional.of(entityInstance);
        } catch (final Exception e) {
            return Optional.empty();
        }
    }

    protected Optional<ENTITY> newRandomizedEntitySpy() {
        return newRandomizedEntityInstance().map(Mockito::spy);
    }

    // --------------------------------------------------------------------------------------------------------- idClass

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<ENTITY> entityClass;

    protected final Class<ID> idClass;
}