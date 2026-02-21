package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.dto.AsignaturaDTO;
import org.example.hogwarts.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @Operation(summary = "Obtener todas las asignaturas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de asignaturas obtenida correctamente")
    })
    @GetMapping
    public List<AsignaturaDTO> getAll() {
        return asignaturaService.findAll();
    }

    @Operation(summary = "Obtener una asignatura por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @GetMapping("/{id}")
    public AsignaturaDTO getById(@PathVariable Long id) {
        return asignaturaService.findById(id);
    }

    @Operation(summary = "Eliminar una asignatura por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Asignatura eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        asignaturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}