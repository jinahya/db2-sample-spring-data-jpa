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
public abstract class MappedEmpResumeId<SELF extends MappedEmpResumeId<SELF>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 7776742777087163129L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected MappedEmpResumeId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final var that = (MappedEmpResumeId<?>) obj;
        return Objects.equals(empno, that.empno) &&
                Objects.equals(resumeFormat, that.resumeFormat);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(empno, resumeFormat);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = 6)
    @NotNull
    @Column(name = MappedEmpResume.COLUMN_NAME_EMPNO, nullable = false, length = 6)
    private String empno;

    @Size(max = 10)
    @NotNull
    @Column(name = MappedEmpResume.COLUMN_NAME_RESUME_FORMAT, nullable = false, length = 10)
    private String resumeFormat;
}