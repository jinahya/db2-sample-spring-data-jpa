package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.List;

public class RandomLatitudeOfBigDecimalAttributeStrategy implements AttributeStrategy<BigDecimal> {

    static BigDecimal randomLatitudeOfBigDecimal() {
        return BigDecimal.valueOf(RandomLatitudeOfDoubleAttributeStrategy.randomLatitudeOfDouble());
    }

    @Override
    public BigDecimal getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        return randomLatitudeOfBigDecimal();
    }
}
