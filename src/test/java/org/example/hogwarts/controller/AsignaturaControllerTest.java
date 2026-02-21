package org.example.hogwarts.controller;

import org.example.hogwarts.service.AsignaturaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TEST DE API - Capa de Controller
 *
 * @WebMvcTest carga solo la capa web (controllers).
 * Los servicios se sustituyen por mocks con @MockBean.
 * MockMvc simula peticiones HTTP sin levantar el servidor real.
 */
@WebMvcTest(AsignaturaController.class)
class AsignaturaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsignaturaService asignaturaService;

    /**
     * TEST: Eliminar una asignatura que tiene alumnos matriculados devuelve 500.
     *
     * GIVEN: La asignatura con ID 1 tiene alumnos → el service lanza RuntimeException
     * WHEN:  Se hace DELETE /asignaturas/1
     * THEN:  Se devuelve HTTP 500 Internal Server Error
     */
    @Test
    @DisplayName("Eliminar asignatura con alumnos devuelve 500")
    void eliminarAsignatura_conAlumnos_devuelve500() throws Exception {

        // GIVEN
        doThrow(new RuntimeException("No se puede borrar la asignatura porque tiene alumnos matriculados"))
                .when(asignaturaService).delete(1L);

        // WHEN & THEN
        mockMvc.perform(delete("/asignaturas/1"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("Eliminar asignatura sin alumnos devuelve 204")
    void eliminarAsignatura_sinAlumnos_devuelve204() throws Exception {

        // GIVEN
        doNothing().when(asignaturaService).delete(2L);

        // WHEN & THEN
        mockMvc.perform(delete("/asignaturas/2"))
                .andExpect(status().isNoContent());

        verify(asignaturaService, times(1)).delete(2L);
    }
}