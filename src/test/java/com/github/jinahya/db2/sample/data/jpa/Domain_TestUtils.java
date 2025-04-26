package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
final class Domain_TestUtils {

    private Domain_TestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
