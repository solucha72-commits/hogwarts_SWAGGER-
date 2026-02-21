package org.example.hogwarts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MascotaCreadaConEstudianteDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String especie;

    @NotNull
    private Long estudianteId;

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }
}
