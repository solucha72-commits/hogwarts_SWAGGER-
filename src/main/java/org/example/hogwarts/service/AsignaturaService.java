package org.example.hogwarts.service;

import org.example.hogwarts.dto.AsignaturaDTO;
import java.util.List;

public interface AsignaturaService {

    List<AsignaturaDTO> findAll();

    AsignaturaDTO findById(Long id);
    void delete(Long id);
}
