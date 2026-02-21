package org.example.hogwarts.service;

import org.example.hogwarts.dto.AsignaturaDTO;
import org.example.hogwarts.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorService {
    List<ProfesorDTO> findAll();

    ProfesorDTO findById(Long id);
}
