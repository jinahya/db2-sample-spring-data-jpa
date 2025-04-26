package com.github.jinahya.db2.sample.data.jpa;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

// https://github.com/spring-projects/spring-boot/issues/13337#issuecomment-1320921333
@Import({
        ValidationAutoConfiguration.class,
})
//@EnableJpaAuditing
@TestConfiguration
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class __MappedEntity_SpringBootIT_Configuration {

    @PostConstruct
    private void doOnPostConstruct() {
        log.debug("entityManagerFactoryBean: {}", entityManagerFactoryBean);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;
}