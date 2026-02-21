package org.example.hogwarts.service;

import org.example.hogwarts.dto.CasaDTO;
import org.example.hogwarts.mapper.CasaMapper;
import org.example.hogwarts.repository.CasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl implements CasaService {

    private final CasaRepository repository;

    public CasaServiceImpl(CasaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CasaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(CasaMapper::toDTO)
                .toList();
    }

    @Override
    public CasaDTO findById(Long id) {
        return repository.findById(id)
                .map(CasaMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}