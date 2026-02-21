package org.example.hogwarts.service;

import java.util.List;
import org.example.hogwarts.dto.AsignaturaDTO;
import org.example.hogwarts.model.Asignatura;
import org.example.hogwarts.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public List<AsignaturaDTO> findAll() {
        return asignaturaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public AsignaturaDTO findById(Long id) {
        return asignaturaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        // Si tiene estudiantes matriculados, no se puede borrar
        if (asignatura.getEstudiantes() != null && !asignatura.getEstudiantes().isEmpty()) {
            throw new RuntimeException("No se puede borrar la asignatura porque tiene alumnos matriculados");
        }

        asignaturaRepository.delete(asignatura);
    }

    // ---------- MAPPER ----------
    private AsignaturaDTO toDTO(Asignatura a) {
        return new AsignaturaDTO(
                a.getIdAsignatura(),
                a.getNombre(),
                a.getAula(),
                a.isObligatoria(),
                null
        );
    }
}