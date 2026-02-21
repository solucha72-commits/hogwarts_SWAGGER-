package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long idAsignatura;

    @Column(nullable = false)
    private String nombre;

    private String aula;

    private boolean obligatoria;



    @OneToMany(mappedBy = "asignatura")
    @JsonIgnore
    private List<EstudianteAsignatura> estudiantes;



    public Asignatura() {
    }


    public Long getIdAsignatura() {
        return idAsignatura;
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



    public List<EstudianteAsignatura> getEstudiantes() {
        return estudiantes;
    }



    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
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




    public void setEstudiantes(List<EstudianteAsignatura> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
