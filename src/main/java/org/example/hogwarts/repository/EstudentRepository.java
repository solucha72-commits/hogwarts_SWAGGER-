package org.example.hogwarts.repository;

import org.example.hogwarts.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudentRepository
        extends JpaRepository<Estudiante, Long> {
}
