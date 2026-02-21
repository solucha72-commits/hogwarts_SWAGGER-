package org.example.hogwarts.service;

import org.example.hogwarts.dto.MascotaCreadaConEstudianteDTO;
import org.example.hogwarts.dto.MascotaDTO;
import org.example.hogwarts.model.Mascota;
import java.util.List;

public interface MascotaService {
    List<MascotaDTO> findAll();



    MascotaDTO findById(Long id);

    MascotaDTO createWithEstudiante(MascotaCreadaConEstudianteDTO dto);

}
