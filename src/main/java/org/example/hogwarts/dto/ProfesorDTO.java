package org.example.hogwarts.dto;

import java.time.LocalDate;

public class ProfesorDTO {

    private Long id;
    private String nombre;
    private String asignatura;
    private LocalDate fechaInicio;   // ✅ LocalDate

    public ProfesorDTO() {
    }

    public ProfesorDTO(Long id, String nombre, String asignatura, LocalDate fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.fechaInicio = fechaInicio;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
