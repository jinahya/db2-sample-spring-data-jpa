package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
class EmpResume_SpringBootIT extends __MappedEntity_SpringBootIT<EmpResume, EmpResumeId> {

    EmpResume_SpringBootIT() {
        super(EmpResume.class);
    }

    @Test
    void __() throws IOException {
        final var path = Path.of("target", "employee-resumes");
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        final var builder = entityManager().getCriteriaBuilder();
        final var query = builder.createQuery(EmpResume.class);
        query.from(EmpResume.class);
        entityManager().createQuery(query).getResultStream().filter(er -> er.getResume() != null).forEach(er -> {
            final var extension = switch (er.getId().getResumeFormat()) {
                case "ascii" -> "txt";
                default -> er.getId().getResumeFormat();
            };
            final var name = MappedEmpResume.TABLE_NAME + "_" + er.getId().getEmpno() + "." + extension;
            try {
                Files.write(path.resolve(name), er.getResume().getBytes(StandardCharsets.UTF_8));
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }
}