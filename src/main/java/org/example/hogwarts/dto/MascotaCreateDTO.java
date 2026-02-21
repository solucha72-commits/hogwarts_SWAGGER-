package org.example.hogwarts.dto;

import jakarta.validation.constraints.NotBlank;

public class MascotaCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String especie;

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    // SETTERS (OBLIGATORIOS)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
