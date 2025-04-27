package com.github.jinahya.db2.sample.data.jpa;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class __AttributeEnumTest<E extends Enum<E> & __AttributeEnum<E, ATTRIBUTE>, ATTRIBUTE> {

    abstract static class __OfIntegerTest<E extends Enum<E> & __AttributeEnum.__OfInteger<E>>
            extends __AttributeEnumTest<E, Integer> {

        __OfIntegerTest(final Class<E> enumClss) {
            super(enumClss);
        }
    }

    abstract static class __OfLongTest<E extends Enum<E> & __AttributeEnum.__OfLong<E>>
            extends __AttributeEnumTest<E, Long> {

        __OfLongTest(final Class<E> enumClss) {
            super(enumClss);
        }
    }

    abstract static class __OfStringTest<E extends Enum<E> & __AttributeEnum.__OfString<E>>
            extends __AttributeEnumTest<E, String> {

        __OfStringTest(final Class<E> enumClss) {
            super(enumClss);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    __AttributeEnumTest(final Class<E> enumClass) {
        this.enumClass = Objects.requireNonNull(enumClass, "enumClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void assertNoDuplicateAttributeValues() {
        final var set = new HashSet<ATTRIBUTE>();
        for (final var enumConstant : enumClass.getEnumConstants()) {
            assertThat(set.add(enumConstant.getAttributeValue()))
                    .as("added to set; enum constant: %s; attribute value of %s", enumConstant,
                        enumConstant.getAttributeValue())
                    .isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<E> enumClass;
}