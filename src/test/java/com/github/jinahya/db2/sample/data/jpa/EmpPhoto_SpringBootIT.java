package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
class EmpPhoto_SpringBootIT extends __MappedEntity_SpringBootIT<EmpPhoto, EmpPhotoId> {

    EmpPhoto_SpringBootIT() {
        super(EmpPhoto.class);
    }

    @Test
    void __() throws IOException {
        final var path = Path.of("target", "employee-photos");
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        final var builder = entityManager().getCriteriaBuilder();
        final var query = builder.createQuery(EmpPhoto.class);
        query.from(EmpPhoto.class);
        entityManager().createQuery(query).getResultStream().filter(er -> er.getPicture() != null).forEach(er -> {
            final var extension = switch (er.getId().getPhotoFormat()) {
                case "bitmap" -> "bmp";
                default -> er.getId().getPhotoFormat();
            };
            final var name = MappedEmpPhoto.TABLE_NAME + "_" + er.getId().getEmpno() + "." + extension;
            try {
                Files.write(path.resolve(name), er.getPicture());
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }
}