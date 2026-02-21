package org.example.hogwarts.mapper;

import org.example.hogwarts.dto.ProfesorDTO;
import org.example.hogwarts.model.Profesor;

public class ProfesorMapper {

    public static ProfesorDTO toDTO(Profesor p) {
        if (p == null) return null;

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(p.getIdProfesor().longValue());
        dto.setNombre(p.getNombre());
        dto.setFechaInicio(p.getFechaInicio());

        if (p.getAsignatura() != null) {
            dto.setAsignatura(p.getAsignatura().getNombre());
        }

        return dto;
    }
}
