package org.example.hogwarts.mapper;

import org.example.hogwarts.dto.CasaDTO;
import org.example.hogwarts.model.Casa;

import java.util.List;

public class CasaMapper {

    public static CasaDTO toDTO(Casa c) {
        if (c == null) return null;

        CasaDTO dto = new CasaDTO();
        dto.setId(c.getIdCasa());
        dto.setNombre(c.getNombre());
        dto.setFundador(c.getFundador());
        dto.setFantasma(c.getFantasma());

        // jefe de casa
        if (c.getJefe() != null) {
            dto.setJefe(ProfesorMapper.toDTO(c.getJefe()));
        }


        if (c.getEstudiantes() != null) {
            List<String> nombres = c.getEstudiantes()
                    .stream()
                    .map(e -> e.getNombre() + " " + e.getApellido())
                    .toList();

            dto.setEstudiantes(nombres);
        }

        return dto;
    }
}
