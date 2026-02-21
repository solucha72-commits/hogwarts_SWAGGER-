package org.example.hogwarts.repository;

import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class EstudianteRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EstudentRepository estudentRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    /**
     * TEST DE INTEGRACIÓN
     *
     * GIVEN: Existe Harry Potter con su mascota Hedwig
     * WHEN:  Se borra el estudiante
     * THEN:  La mascota también desaparece (borrado en cascada)
     */
    @Test
    void testBorrarEstudianteConMascota_mascotaTambienDesaparece() {

        // GIVEN

        Casa gryffindor = new Casa();
        gryffindor.setNombre("Gryffindor");
        gryffindor.setFundador("Godric");
        gryffindor.setFantasma("Nick");

        entityManager.persist(gryffindor);

        Estudiante harry = new Estudiante();
        harry.setNombre("Harry");
        harry.setApellido("Potter");
        harry.setAnyoCurso(7);
        harry.setFechaNacimiento(LocalDate.of(1980, 7, 31));
        harry.setCasa(gryffindor);

        Mascota hedwig = new Mascota();
        hedwig.setNombre("Hedwig");
        hedwig.setEspecie("Lechuza");

        // Relación bidireccional correcta
        hedwig.setEstudiante(harry);
        harry.setMascota(hedwig);

        entityManager.persist(harry);
        entityManager.flush();
        entityManager.clear();

        Long harryId = harry.getIdEstudiante();
        Long hedwigId = hedwig.getId();

        assertTrue(estudentRepository.findById(harryId).isPresent());
        assertTrue(mascotaRepository.findById(hedwigId).isPresent());

        // WHEN - Borramos SOLO el estudiante
        estudentRepository.deleteById(harryId);
        entityManager.flush();
        entityManager.clear();

        // THEN - Ambos deben haber desaparecido
        Optional<Estudiante> estudianteBorrado =
                estudentRepository.findById(harryId);

        Optional<Mascota> mascotaBorrada =
                mascotaRepository.findById(hedwigId);

        assertFalse(estudianteBorrado.isPresent(),
                "El estudiante debería haber sido borrado");

        assertFalse(mascotaBorrada.isPresent(),
                "La mascota debería haberse eliminado en cascada");
    }


    /**
     * TEST DE INTEGRACIÓN
     *
     * GIVEN: Se guarda un estudiante sin mascota
     * WHEN:  Se busca por ID
     * THEN:  Se encuentra correctamente
     */
    @Test
    void testGuardarEstudiante_seEncuentraPorId() {

        Casa hufflepuff = new Casa();
        hufflepuff.setNombre("Hufflepuff");
        hufflepuff.setFundador("Helga");
        hufflepuff.setFantasma("Fat Friar");

        entityManager.persist(hufflepuff);

        Estudiante neville = new Estudiante();
        neville.setNombre("Neville");
        neville.setApellido("Longbottom");
        neville.setAnyoCurso(7);
        neville.setFechaNacimiento(LocalDate.of(1980, 7, 30));
        neville.setCasa(hufflepuff);

        entityManager.persist(neville);
        entityManager.flush();
        entityManager.clear();

        // WHEN
        Optional<Estudiante> resultado =
                estudentRepository.findById(neville.getIdEstudiante());

        // THEN
        assertTrue(resultado.isPresent());
        assertEquals("Neville", resultado.get().getNombre());
        assertEquals("Longbottom", resultado.get().getApellido());
    }
}