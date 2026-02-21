package org.example.hogwarts.dto;
import java.time.LocalDate;
import java.util.List;

public class EstudianteDTO {
    private Long id;
    private String nombre;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDTO mascota;
    private List<AsignaturaCalificacionDTO> asignaturas;
    public EstudianteDTO() {
    }

    public EstudianteDTO(Long id, String nombre, int anyoCurso,
                         LocalDate fechaNacimiento, String casa,
                         MascotaDTO mascota,
                         List<AsignaturaCalificacionDTO> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.anyoCurso = anyoCurso;
        this.fechaNacimiento = fechaNacimiento;
        this.casa = casa;
        this.mascota = mascota;
        this.asignaturas = asignaturas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnyoCurso() {
        return anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCasa() {
        return casa;
    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public List<AsignaturaCalificacionDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setId(Long idEstudiante) {
        this.id=idEstudiante;
    }
    public void setAsignaturas(List<AsignaturaCalificacionDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public void setNombre(String nombre) {
        this. nombre=nombre;
    }

    public void setAnyoCurso(Integer anyoCurso) {
        this.anyoCurso=anyoCurso;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento=fechaNacimiento;
    }

    public void setCasa(String nombre) {
        this.casa=nombre;
    }

    public void setMascota(MascotaDTO dto) {
        this.mascota=dto;
    }
}
