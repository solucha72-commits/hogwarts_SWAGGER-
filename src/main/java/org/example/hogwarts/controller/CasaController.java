package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.hogwarts.dto.CasaDTO;
import org.example.hogwarts.service.CasaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casas")
public class CasaController {

    private final CasaService casaService;

    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @Operation(summary = "Obtener todas las casas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de casas obtenida correctamente")
    })
    @GetMapping
    public List<CasaDTO> getAll() {
        return casaService.findAll();
    }

    @Operation(summary = "Obtener una casa por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Casa encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "Casa no encontrada")
    })
    @GetMapping("/{id}")
    public CasaDTO getById(@PathVariable Long id) {
        return casaService.findById(id);
    }
}