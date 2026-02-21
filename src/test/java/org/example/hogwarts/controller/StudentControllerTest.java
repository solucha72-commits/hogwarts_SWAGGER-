package org.example.hogwarts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hogwarts.dto.EstudianteCreateDTO;
import org.example.hogwarts.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    // ===============================
    // CREATE
    // ===============================

    @Test
    @DisplayName("Crear estudiante con año inválido devuelve 500")
    void crearEstudiante_anyoCursoInvalido_devuelve500() throws Exception {

        EstudianteCreateDTO dto = new EstudianteCreateDTO();
        dto.setNombre("Harry");
        dto.setApellido("Potter");
        dto.setAnyoCurso(10);
        dto.setFechaNacimiento(LocalDate.of(1980, 7, 31));
        dto.setCasaId(1L);

        when(studentService.create(any()))
                .thenThrow(new RuntimeException("Año de curso inválido"));

        mockMvc.perform(post("/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isInternalServerError());
    }

    // ===============================
    // DELETE OK
    // ===============================

    @Test
    @DisplayName("Eliminar estudiante existente devuelve 204")
    void eliminarEstudiante_existente_devuelve204() throws Exception {

        doNothing().when(studentService).delete(1L);

        mockMvc.perform(delete("/estudiantes/1"))
                .andExpect(status().isNoContent());

        verify(studentService, times(1)).delete(1L);
    }

    // ===============================
    // DELETE ERROR
    // ===============================

    @Test
    @DisplayName("Eliminar estudiante con mascota devuelve 500")
    void eliminarEstudiante_conMascota_devuelve500() throws Exception {

        doThrow(new RuntimeException("No se puede borrar el estudiante porque tiene mascota"))
                .when(studentService).delete(2L);

        mockMvc.perform(delete("/estudiantes/2"))
                .andExpect(status().isInternalServerError());
    }

    // ===============================
    // GET ALL
    // ===============================

    @Test
    @DisplayName("Obtener todos los estudiantes devuelve 200")
    void getAll_devuelve200() throws Exception {

        when(studentService.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/estudiantes"))
                .andExpect(status().isOk());
    }
}
