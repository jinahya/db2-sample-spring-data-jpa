package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.util.List;

public class RandomLongitudeOfStringAttributeStrategy implements AttributeStrategy<String> {

    public static String randomLongitudeOfString() {
        return RandomLongitudeOfBigDecimalAttributeStrategy.randomLongitudeOfBigDecimal().toString();
    }

    @Override
    public String getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        assert String.class.isAssignableFrom(attrType);
        return randomLongitudeOfString();
    }
}
