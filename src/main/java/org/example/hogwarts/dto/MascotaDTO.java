package org.example.hogwarts.dto;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String estudiante;   // 👈 requerido por el PDF

    public MascotaDTO() {
    }

    public MascotaDTO(Long id, String nombre, String especie, String estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.estudiante = estudiante;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getEstudiante() {
        return estudiante;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
}
