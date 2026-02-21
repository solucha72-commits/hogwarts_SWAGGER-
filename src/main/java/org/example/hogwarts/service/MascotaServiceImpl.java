package org.example.hogwarts.service;

import org.example.hogwarts.dto.MascotaCreadaConEstudianteDTO;
import org.example.hogwarts.dto.MascotaDTO;
import org.example.hogwarts.mapper.MascotaMapper;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.EstudentRepository;
import org.example.hogwarts.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final EstudentRepository estudentRepository;
    private final MascotaMapper mascotaMapper;

    public MascotaServiceImpl(MascotaRepository mascotaRepository,
                              EstudentRepository estudentRepository,
                              MascotaMapper mascotaMapper) {
        this.mascotaRepository = mascotaRepository;
        this.estudentRepository = estudentRepository;
        this.mascotaMapper = mascotaMapper;
    }

    @Override
    public List<MascotaDTO> findAll() {
        return mascotaRepository.findAll()
                .stream()
                .map(mascotaMapper::toDTO)
                .toList();
    }

    @Override
    public MascotaDTO findById(Long id) {
        return mascotaRepository.findById(id)
                .map(mascotaMapper::toDTO)
                .orElse(null);
    }

    @Override
    public MascotaDTO createWithEstudiante(MascotaCreadaConEstudianteDTO dto) {

        Estudiante estudiante = estudentRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setEstudiante(estudiante);
        Mascota guardada = mascotaRepository.save(mascota);
        return mascotaMapper.toDTO(guardada);
    }
}