package com.github.jinahya.db2.sample.data.jpa.domain;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

// https://docs.spring.io/spring-data/jpa/reference/auditing.html#auditing.reactive-auditor-aware
public class AuditingAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
