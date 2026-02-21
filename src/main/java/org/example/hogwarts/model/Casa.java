package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long idCasa;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String fundador;

    @Column(nullable = false, length = 50)
    private String fantasma;

    @ManyToOne
    @JoinColumn(name = "id_jefe")

    private Profesor jefe;

    @OneToMany(mappedBy = "casa")

    private List<Estudiante> estudiantes;


    public String getNombre() {
        return nombre;
    }
    public Long getIdCasa() {
        return idCasa;
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


    public String getFundador() {
        return fundador;
    }

    public String getFantasma() {
        return fantasma;
    }

    public Profesor getJefe() {
        return jefe;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

}
