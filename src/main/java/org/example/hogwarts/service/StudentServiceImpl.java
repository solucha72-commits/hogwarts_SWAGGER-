package org.example.hogwarts.service;

import org.example.hogwarts.dto.EstudianteCreateDTO;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.EstudianteUpdateDTO;
import org.example.hogwarts.mapper.EstudianteMapper;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.CasaRepository;
import org.example.hogwarts.repository.EstudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final EstudentRepository repository;
    private final CasaRepository casaRepository;
    private final EstudianteMapper estudianteMapper;

    public StudentServiceImpl(
            EstudentRepository repository,
            CasaRepository casaRepository,
            EstudianteMapper estudianteMapper
    ) {
        this.repository = repository;
        this.casaRepository = casaRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Override
    public List<EstudianteDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO findById(Long id) {
        return repository.findById(id)
                .map(estudianteMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        if (estudiante.getMascota() != null) {
            throw new RuntimeException("No se puede borrar el estudiante porque tiene mascota");
        }

        repository.delete(estudiante);
    }

    @Override
    public EstudianteDTO create(EstudianteCreateDTO dto) {

        Casa casa = casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new RuntimeException("Casa no encontrada"));

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setCasa(casa);

        if (dto.getMascota() != null) {
            Mascota mascota = new Mascota();
            mascota.setNombre(dto.getMascota().getNombre());
            mascota.setEspecie(dto.getMascota().getEspecie());
            mascota.setEstudiante(estudiante);
            estudiante.setMascota(mascota);
        }

        Estudiante guardado = repository.save(estudiante);
        return estudianteMapper.toDTO(guardado);
    }

    @Override
    public EstudianteDTO update(Long id, EstudianteUpdateDTO dto) {

        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        if (dto.getMascota() == null) {
            estudiante.setMascota(null);
        } else {
            Mascota mascota = estudiante.getMascota();
            if (mascota == null) {
                mascota = new Mascota();
                mascota.setEstudiante(estudiante);
            }
            mascota.setNombre(dto.getMascota().getNombre());
            mascota.setEspecie(dto.getMascota().getEspecie());
            estudiante.setMascota(mascota);
        }

        Estudiante guardado = repository.save(estudiante);
        return estudianteMapper.toDTO(guardado);
    }
}