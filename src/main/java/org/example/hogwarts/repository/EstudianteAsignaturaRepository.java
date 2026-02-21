package org.example.hogwarts.repository;

import org.example.hogwarts.model.EstudianteAsignatura;
import org.example.hogwarts.model.EstudianteAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteAsignaturaRepository
        extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {
}