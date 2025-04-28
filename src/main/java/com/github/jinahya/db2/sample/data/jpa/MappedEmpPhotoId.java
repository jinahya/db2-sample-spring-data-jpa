package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class MappedEmpPhotoId<SELF extends MappedEmpPhotoId<SELF>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 7776742777087163129L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected MappedEmpPhotoId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final var that = (MappedEmpPhotoId<?>) obj;
        return Objects.equals(empno, that.empno) &&
                Objects.equals(photoFormat, that.photoFormat);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(empno, photoFormat);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @NotNull
    @Column(name = MappedEmpPhoto.COLUMN_NAME_EMPNO, nullable = false, length = 6)
    private String empno;

    @Size(max = 10)
    @NotNull
    @Column(name = MappedEmpPhoto.COLUMN_NAME_PHOTO_FORMAT, nullable = false, length = 10)
    private String photoFormat;
}