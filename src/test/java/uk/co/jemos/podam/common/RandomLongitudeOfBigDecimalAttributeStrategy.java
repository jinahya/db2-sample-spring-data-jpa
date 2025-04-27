package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.List;

public class RandomLongitudeOfBigDecimalAttributeStrategy implements AttributeStrategy<BigDecimal> {

    static BigDecimal randomLongitudeOfBigDecimal() {
        return BigDecimal.valueOf(RandomLongitudeOfDoubleAttributeStrategy.randomLongitudeOfDouble());
    }

    @Override
    public BigDecimal getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        return randomLongitudeOfBigDecimal();
    }
}
