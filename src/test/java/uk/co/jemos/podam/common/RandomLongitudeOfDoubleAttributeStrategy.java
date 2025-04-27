package uk.co.jemos.podam.common;

import com.github.jinahya.db2.sample.data.jpa.__MappedEntityConstants;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLongitudeOfDoubleAttributeStrategy implements AttributeStrategy<Double> {

    static double randomLongitudeOfDouble() {
        final var value = ThreadLocalRandom.current().nextDouble()
                * (__MappedEntityConstants.MAX_LONGITUDE - (__MappedEntityConstants.MIN_LONGITUDE + Double.MIN_VALUE))
                - __MappedEntityConstants.MAX_LONGITUDE;
        assertThat(value)
                .as("random longitude")
                .isGreaterThanOrEqualTo(__MappedEntityConstants.MIN_LONGITUDE)
                .isLessThanOrEqualTo(__MappedEntityConstants.MAX_LONGITUDE);
        return value;
    }

    @Override
    public Double getValue(final Class<?> attrType, final List<Annotation> attrAnnotations) {
        return randomLongitudeOfDouble();
    }
}
