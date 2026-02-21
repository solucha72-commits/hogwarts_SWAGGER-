package org.example.hogwarts.service;

import org.example.hogwarts.dto.ProfesorDTO;
import org.example.hogwarts.mapper.ProfesorMapper;
import org.example.hogwarts.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository repository;

    public ProfesorServiceImpl(ProfesorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProfesorDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProfesorMapper::toDTO)
                .toList();
    }

    @Override
    public ProfesorDTO findById(Long id) {
        return repository.findById(id)
                .map(ProfesorMapper::toDTO)
                .orElse(null);
    }
}
