package org.example.hogwarts.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstudianteAsignaturaId implements Serializable {

    private Long idEstudiante;
    private Long idAsignatura;

    public EstudianteAsignaturaId() {}

    public EstudianteAsignaturaId(Long idEstudiante, Long idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudianteAsignaturaId that)) return false;
        return Objects.equals(idEstudiante, that.idEstudiante)
                && Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idAsignatura);
    }
}
