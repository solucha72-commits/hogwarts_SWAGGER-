package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(name = "anyo_curso")
    private Integer anyoCurso;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteAsignatura> asignaturas;


    public List<EstudianteAsignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<EstudianteAsignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }


    @OneToOne(mappedBy = "estudiante",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Mascota mascota;


    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    private List<Asignatura> asignatura;

    @ManyToOne
    @JoinColumn(name = "id_casa", nullable = false)
    @JsonBackReference
    private Casa casa;


    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public Casa getCasa() {
        return casa;
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


    public Mascota getMascota() {
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

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }


}
