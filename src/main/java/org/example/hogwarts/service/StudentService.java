package org.example.hogwarts.service;

import org.example.hogwarts.dto.EstudianteCreateDTO;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.EstudianteUpdateDTO;

import java.util.List;

public interface StudentService {

    List<EstudianteDTO> findAll();

    EstudianteDTO findById(Long id);

    void delete(Long id);

    EstudianteDTO create(EstudianteCreateDTO dto);

    EstudianteDTO update(Long id, EstudianteUpdateDTO dto);
}