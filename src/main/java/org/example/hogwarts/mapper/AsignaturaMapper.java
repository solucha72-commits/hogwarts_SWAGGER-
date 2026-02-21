package org.example.hogwarts.mapper;

import org.example.hogwarts.dto.AsignaturaDTO;
import org.example.hogwarts.model.Asignatura;

public class AsignaturaMapper {

    public static AsignaturaDTO toDTO(Asignatura a) {
        if (a == null) return null;

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(a.getIdAsignatura());
        dto.setNombre(a.getNombre());
        dto.setAula(a.getAula());
        dto.setObligatoria(a.isObligatoria());


        return dto;
    }
}
