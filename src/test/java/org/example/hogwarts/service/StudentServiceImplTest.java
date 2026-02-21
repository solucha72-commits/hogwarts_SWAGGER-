package org.example.hogwarts.service;

import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.mapper.EstudianteMapper;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.CasaRepository;
import org.example.hogwarts.repository.EstudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TEST UNITARIO - Capa de Servicio
 *
 * Usamos @ExtendWith(MockitoExtension.class) para que JUnit use Mockito.
 * No se levanta Spring, no hay base de datos real. Todo son objetos en memoria.
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    // Mock del repositorio: simula la BD sin conectarse a ella
    @Mock
    private EstudentRepository repository;

    @Mock
    private CasaRepository casaRepository;

    @Mock
    private EstudianteMapper estudianteMapper;

    // La instancia REAL del servicio, con los mocks inyectados
    @InjectMocks
    private StudentServiceImpl studentService;

    // Datos de prueba que usaremos en los tests
    private Estudiante harryPotter;
    private EstudianteDTO harryPotterDTO;

    /**
     * @BeforeEach se ejecuta ANTES de cada test.
     * Aquí preparamos los datos de prueba.
     */
    @BeforeEach
    void setUp() {
        // Creamos a Harry Potter como objeto Estudiante (sin guardar en BD)
        harryPotter = new Estudiante();
        harryPotter.setIdEstudiante(1L);
        harryPotter.setNombre("Harry");
        harryPotter.setApellido("Potter");
        harryPotter.setAnyoCurso(7);
        harryPotter.setFechaNacimiento(LocalDate.of(1980, 7, 31));
        harryPotter.setMascota(null); // sin mascota para poder borrarlo

        // DTO equivalente que devolvería el mapper
        harryPotterDTO = new EstudianteDTO();
        harryPotterDTO.setId(1L);
        harryPotterDTO.setNombre("Harry");
        harryPotterDTO.setAnyoCurso(7);
    }

    /**
     * TEST: Expulsión de Harry Potter (delete sin mascota).
     *
     * GIVEN: Harry Potter existe y no tiene mascota
     * WHEN:  Se llama al método delete con su ID
     * THEN:  El repositorio ejecuta delete exactamente 1 vez
     */
    @Test
    void testExpulsarHarryPotter_sinMascota_deleteEjecutado1Vez() {
        // GIVEN - Programamos el comportamiento del mock
        when(repository.findById(1L)).thenReturn(Optional.of(harryPotter));

        // WHEN - Ejecutamos la expulsión
        studentService.delete(1L);

        // THEN - Verificamos que delete se llamó exactamente 1 vez
        verify(repository, times(1)).delete(harryPotter);
    }

    /**
     * TEST: No se puede expulsar a un estudiante que tiene mascota.
     *
     * GIVEN: Harry Potter tiene una mascota (Hedwig)
     * WHEN:  Se intenta borrar al estudiante
     * THEN:  Se lanza una RuntimeException y delete NO se llama
     */
    @Test
    void testExpulsarEstudianteConMascota_lanzaExcepcion() {
        // GIVEN - Hedwig es la mascota de Harry
        Mascota hedwig = new Mascota();
        hedwig.setNombre("Hedwig");
        hedwig.setEspecie("Lechuza");
        hedwig.setEstudiante(harryPotter);
        harryPotter.setMascota(hedwig);

        when(repository.findById(1L)).thenReturn(Optional.of(harryPotter));

        // WHEN & THEN - Esperamos que se lance la excepción
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            studentService.delete(1L);
        });

        assertEquals("No se puede borrar el estudiante porque tiene mascota", excepcion.getMessage());

        // Y verificamos que delete NUNCA se llegó a llamar
        verify(repository, never()).delete(any());
    }

    /**
     * TEST: Buscar un estudiante que existe devuelve su DTO.
     *
     * GIVEN: Harry Potter existe en el repositorio
     * WHEN:  Se busca por su ID
     * THEN:  Se devuelve el DTO con sus datos
     */
    @Test
    void testFindById_estudianteExiste_devuelveDTO() {
        // GIVEN
        when(repository.findById(1L)).thenReturn(Optional.of(harryPotter));
        when(estudianteMapper.toDTO(harryPotter)).thenReturn(harryPotterDTO);

        // WHEN
        EstudianteDTO resultado = studentService.findById(1L);

        // THEN
        assertNotNull(resultado);
        assertEquals("Harry", resultado.getNombre());
        verify(repository, times(1)).findById(1L);
    }
}
