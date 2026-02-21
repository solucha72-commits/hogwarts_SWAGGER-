package org.example.hogwarts.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EstudianteCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotNull
    private Integer anyoCurso;

    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private Long casaId;

    @Valid
    private MascotaCreateDTO mascota;

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getAnyoCurso() {
        return anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Long getCasaId() {
        return casaId;
    }

    public MascotaCreateDTO getMascota() {
        return mascota;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAnyoCurso(Integer anyoCurso) {
        this.anyoCurso = anyoCurso;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCasaId(Long casaId) {
        this.casaId = casaId;
    }

    public void setMascota(MascotaCreateDTO mascota) {
        this.mascota = mascota;
    }
}
