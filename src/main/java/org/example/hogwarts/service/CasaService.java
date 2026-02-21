package org.example.hogwarts.service;

import org.example.hogwarts.dto.CasaDTO;

import java.util.List;

public interface CasaService {

    List<CasaDTO> findAll();

    CasaDTO findById(Long id);



    void delete(Long id);
}
