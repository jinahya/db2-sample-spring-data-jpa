package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

// https://github.com/spring-projects/spring-boot/issues/13337#issuecomment-1320921333
@Import({
        ValidationAutoConfiguration.class,
})
//@EnableJpaAuditing // why?????????????
@TestConfiguration
@Slf4j
public class _MappedEntity_DataJpaTest_Configuration {

//    @Bean
//    AuditorAware<String> auditorProvider() {
//        return new AuditingAwareImpl();
//    }
}