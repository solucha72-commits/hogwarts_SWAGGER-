package org.example.hogwarts.mapper;

import org.example.hogwarts.dto.AsignaturaCalificacionDTO;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EstudianteMapper {

    private final MascotaMapper mascotaMapper;

    public EstudianteMapper(MascotaMapper mascotaMapper) {
        this.mascotaMapper = mascotaMapper;
    }

    public EstudianteDTO toDTO(Estudiante e) {
        if (e == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getIdEstudiante());
        dto.setNombre(e.getNombre());
        dto.setAnyoCurso(e.getAnyoCurso());
        dto.setFechaNacimiento(e.getFechaNacimiento());

        if (e.getCasa() != null) {
            dto.setCasa(e.getCasa().getNombre());
        }

        if (e.getMascota() != null) {
            dto.setMascota(mascotaMapper.toDTO(e.getMascota()));
        }

        return dto;
    }
}