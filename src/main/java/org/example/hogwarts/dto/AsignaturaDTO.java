package org.example.hogwarts.dto;

import java.time.LocalDate;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String aula;
    private boolean obligatoria;
    private String profesor;
    private Integer anyoCurso;
    private LocalDate fechaNacimiento;
    private Long casaId;
    private MascotaCreateDTO mascota;

    public AsignaturaDTO() {
    }

    public AsignaturaDTO(Long id, String nombre, String aula, boolean obligatoria, String profesor) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
        this.obligatoria = obligatoria;
        this.profesor = profesor;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAula() {
        return aula;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public String getProfesor() {
        return profesor;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
