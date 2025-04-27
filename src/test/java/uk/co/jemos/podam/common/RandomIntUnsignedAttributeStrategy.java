package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntUnsignedAttributeStrategy implements AttributeStrategy<Long> {

    @Override
    public Long getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
        return ThreadLocalRandom.current().nextLong() & 0xFFFFFFFFL;
    }
}
