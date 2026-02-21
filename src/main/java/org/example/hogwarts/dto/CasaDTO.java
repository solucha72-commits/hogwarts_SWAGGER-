package org.example.hogwarts.dto;
import org.example.hogwarts.model.Profesor;

import java.util.List;

public class CasaDTO {
    private Long id;
    private String nombre;
    private String fundador;
    private String fantasma;
    private ProfesorDTO jefe;
    private List<String> estudiantes;

    public CasaDTO() {

    }
    public CasaDTO (Long id, String nombre, String fundador, String fantasma, ProfesorDTO jefe, List<String> estudiantes) {

        this.id = id;
        this.nombre = nombre;
        this.fundador = fundador;
        this.fantasma = fantasma;
        this.jefe =jefe;
        this.estudiantes = estudiantes;

    }
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getFundador() {
        return fundador;
    }

    public String getFantasma() {
        return fantasma;
    }

    public ProfesorDTO getJefe() {
        return jefe;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }


    public void setJefe(ProfesorDTO dto) {
        this.jefe =dto;
    }


    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
