package org.example.hogwarts.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
public class EstudianteUpdateDTO {

    @NotNull
    private Integer anyoCurso;

    @NotNull
    private LocalDate fechaNacimiento;

    @Valid
    private MascotaCreateDTO mascota;

    public Integer getAnyoCurso() {
        return anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public MascotaCreateDTO getMascota() {
        return mascota;
    }
}
