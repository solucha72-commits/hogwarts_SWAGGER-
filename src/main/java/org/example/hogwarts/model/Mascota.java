package org.example.hogwarts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")   // 🔥 ESTA LÍNEA ES LA CLAVE
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    // ===== CONSTRUCTOR VACÍO (OBLIGATORIO PARA JPA) =====
    public Mascota() {
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}

