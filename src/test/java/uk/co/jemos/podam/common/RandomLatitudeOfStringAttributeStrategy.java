package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.util.List;

public class RandomLatitudeOfStringAttributeStrategy implements AttributeStrategy<String> {

    public static String randomLatitudeOfString() {
        final var value = RandomLatitudeOfBigDecimalAttributeStrategy.randomLatitudeOfBigDecimal().toString();
        return value;
    }

    @Override
    public String getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        assert String.class.isAssignableFrom(attrType);
        return randomLatitudeOfString();
    }
}
