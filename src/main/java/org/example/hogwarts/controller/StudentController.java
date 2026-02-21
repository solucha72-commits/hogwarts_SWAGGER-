package org.example.hogwarts.controller;

import jakarta.validation.Valid;
import org.example.hogwarts.dto.EstudianteCreateDTO;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.EstudianteUpdateDTO;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Obtener todos los estudiantes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida correctamente")
    })
    @GetMapping
    public List<EstudianteDTO> getAll() {
        return studentService.findAll();
    }


    @Operation(summary = "Obtener un estudiante por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public EstudianteDTO getById(@PathVariable Long id) {
        return studentService.findById(id);
    }


    @Operation(summary = "Eliminar un estudiante por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Crear un nuevo estudiante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<EstudianteDTO> create(
            @Valid @RequestBody EstudianteCreateDTO dto) {

        EstudianteDTO creado = studentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }


    @Operation(summary = "Actualizar un estudiante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody EstudianteUpdateDTO dto
    ) {
        EstudianteDTO actualizado = studentService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}