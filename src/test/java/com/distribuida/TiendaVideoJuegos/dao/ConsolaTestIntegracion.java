package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.ConsolaRepository;
import com.distribuida.model.Consola;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ConsolaTestIntegracion {

    @Autowired
    private ConsolaRepository consolaRepository;

    // 1. Listar todas las consolas
    @Test
    public void testConsolaFindAll() {
        List<Consola> consolas = consolaRepository.findAll();
        assertNotNull(consolas);
        assertTrue(consolas.size() > 0);
        consolas.forEach(System.out::println);
    }

    // 2. Buscar una consola por ID
    @Test
    public void testConsolaFindOne() {
        Optional<Consola> consola = consolaRepository.findById(1);
        assertTrue(consola.isPresent());
        assertEquals("Sony", consola.orElseThrow().getMarca());
        System.out.println(consola);
    }

    // 3. Guardar una nueva consola
    @Test
    public void testConsolaSave() {
        Consola nuevaConsola = new Consola(
                0, // dejar que JPA genere el id
                "Microsoft",
                "Xbox Series X",
                "1TB",
                "Negro"
        );

        Consola guardada = consolaRepository.save(nuevaConsola);

        assertNotNull(guardada.getIdConsola());
        assertEquals("Microsoft", guardada.getMarca());
        assertEquals("Xbox Series X", guardada.getModelo());
    }

    // 4. Actualizar una consola existente
    @Test
    public void testConsolaActualizar() {
        Optional<Consola> consola = consolaRepository.findById(2);
        consola.orElseThrow().setColor("Blanco");
        consola.orElseThrow().setAlmacenamiento("2TB");

        Consola actualizada = consolaRepository.save(consola.orElseThrow());
        assertEquals("Blanco", actualizada.getColor());
        assertEquals("2TB", actualizada.getAlmacenamiento());
    }

    // 5. Eliminar una consola
    @Test
    public void testConsolaDelete() {
        if (consolaRepository.existsById(3)) {
            consolaRepository.deleteById(3);
        }
        assertFalse(consolaRepository.existsById(3));
    }
}
