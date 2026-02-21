package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.dto.ProfesorDTO;
import org.example.hogwarts.service.ProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @Operation(summary = "Obtener todos los profesores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de profesores obtenida correctamente")
    })
    @GetMapping
    public List<ProfesorDTO> getAll() {
        return profesorService.findAll();
    }

    @Operation(summary = "Obtener un profesor por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profesor encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/{id}")
    public ProfesorDTO getById(@PathVariable Long id) {
        return profesorService.findById(id);
    }
}