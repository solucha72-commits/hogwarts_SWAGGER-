package org.example.hogwarts.mapper;

import org.example.hogwarts.dto.MascotaDTO;
import org.example.hogwarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {

    public MascotaDTO toDTO(Mascota m) {
        if (m == null) return null;

        MascotaDTO dto = new MascotaDTO();
        dto.setId(m.getId());
        dto.setNombre(m.getNombre());
        dto.setEspecie(m.getEspecie());

        if (m.getEstudiante() != null) {
            dto.setEstudiante(m.getEstudiante().getNombre());
        }

        return dto;
    }
}
