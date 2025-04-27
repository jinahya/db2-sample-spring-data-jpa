package uk.co.jemos.podam.api;

import uk.co.jemos.podam.common.AttributeStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DataProviderStrategyUtils {

    private static final Map<Class<?>, Map<String, Class<?>>> DECLARING_CLASSES = new HashMap<>();

    // https://github.com/mtedone/podam/issues/329
    public static <T extends DataProviderStrategy> T addOrReplaceAttributeStrategy(
            final T strategy, final Class<?> type, final String attributeName,
            final AttributeStrategy<?> attributeStrategy) {
        Objects.requireNonNull(strategy, "strategy is null");
        final var actualType = DECLARING_CLASSES.computeIfAbsent(type, k -> new HashMap<>())
                .computeIfAbsent(attributeName, an -> {
                    for (var c = type; c != null; c = c.getSuperclass()) {
                        try {
                            c.getDeclaredField(an);
                            return c;
                        } catch (final NoSuchFieldException nsfe) {
                        }
                    }
                    throw new IllegalArgumentException("no declaring class for '" + attributeName + "' onward " + type);
                });
        return (T) strategy.addOrReplaceAttributeStrategy(actualType, attributeName, attributeStrategy);
    }

    private DataProviderStrategyUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
