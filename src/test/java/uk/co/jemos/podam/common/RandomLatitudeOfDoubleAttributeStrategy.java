package uk.co.jemos.podam.common;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntityConstants;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLatitudeOfDoubleAttributeStrategy implements AttributeStrategy<Double> {

    static double randomLatitudeOfDouble() {
        final var value = ThreadLocalRandom.current().nextDouble()
                * (__MappedEntityConstants.MAX_LATITUDE - (__MappedEntityConstants.MIN_LATITUDE + Double.MIN_VALUE))
                - __MappedEntityConstants.MAX_LATITUDE;
        assertThat(value)
                .as("random latitude")
                .isGreaterThanOrEqualTo(__MappedEntityConstants.MIN_LATITUDE)
                .isLessThanOrEqualTo(__MappedEntityConstants.MAX_LATITUDE);
        return value;
    }

    @Override
    public Double getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        return randomLatitudeOfDouble();
    }
}
