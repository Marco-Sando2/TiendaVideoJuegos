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

    @Test
    public void testConsolaFindAll() {
        List<Consola> consolas = consolaRepository.findAll();
        assertNotNull(consolas);
        assertTrue(consolas.size() > 0);
        consolas.forEach(System.out::println);
    }

    @Test
    public void testConsolaFindOne() {
        Optional<Consola> consola = consolaRepository.findById(11);
        assertTrue(consola.isPresent());
        assertEquals("Sony", consola.orElseThrow().getMarca());
        System.out.println(consola);
    }

    @Test
    public void testConsolaSave() {
        Consola nuevaConsola = new Consola(
                11,
                "Sony",
                "CFI-1215A",
                "825GB",
                "Blanco"
        );

        Consola guardada = consolaRepository.save(nuevaConsola);

        assertNotNull(guardada.getIdConsola());
        assertEquals("Sony", guardada.getMarca());
        assertEquals("CFI-1215A", guardada.getModelo());
    }

    @Test
    public void testConsolaActualizar() {
        Optional<Consola> consola = consolaRepository.findById(32);
        consola.orElseThrow().setColor("Blanco");
        consola.orElseThrow().setAlmacenamiento("2GB");

        Consola actualizada = consolaRepository.save(consola.orElseThrow());
        assertEquals("Blanco", actualizada.getColor());
        assertEquals("2GB", actualizada.getAlmacenamiento());
    }

    @Test
    public void testConsolaDelete() {
        if (consolaRepository.existsById(32)) {
                consolaRepository.deleteById(32);
        }
        assertFalse(consolaRepository.existsById(32));
    }
}
