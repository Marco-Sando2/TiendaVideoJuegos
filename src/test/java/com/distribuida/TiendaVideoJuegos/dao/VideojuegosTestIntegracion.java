package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.VideojuegosRepository;
import com.distribuida.dao.VideojuegosRepository;
import com.distribuida.model.Videojuego;
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
public class VideojuegosTestIntegracion {

    @Autowired
    private VideojuegosRepository videojuegoRepository;

    @Test
    public void testVideojuegoFindAll() {
        List<Videojuego> videojuegos = videojuegoRepository.findAll();
        assertNotNull(videojuegos);
        assertTrue(videojuegos.size() > 0);
        videojuegos.forEach(System.out::println);
    }

    @Test
    public void testVideojuegoFindOne() {
        Optional<Videojuego> videojuego = videojuegoRepository.findById(1);
        assertTrue(videojuego.isPresent());
        assertEquals("FIFA 24", videojuego.orElseThrow().getEstudio()); // ejemplo de campo esperado
        System.out.println(videojuego);
    }

    @Test
    public void testVideojuegoSave() {
        Videojuego nuevoVideojuego = new Videojuego(
                0, // dejar que JPA genere el id
                "PlayStation 5",
                "Deportes",
                "2023-09-29",
                "EA Sports",
                "E",
                "Multijugador"
        );

        Videojuego guardado = videojuegoRepository.save(nuevoVideojuego);

        assertNotNull(guardado.getIdProducto());
        assertEquals("EA Sports", guardado.getEstudio());
        assertEquals("Deportes", guardado.getGenero());
    }

    @Test
    public void testVideojuegoActualizar() {
        Optional<Videojuego> videojuego = videojuegoRepository.findById(2);
        videojuego.orElseThrow().setGenero("Acción");
        videojuego.orElseThrow().setModoJuego("Un jugador");

        Videojuego actualizado = videojuegoRepository.save(videojuego.orElseThrow());
        assertEquals("Acción", actualizado.getGenero());
        assertEquals("Un jugador", actualizado.getModoJuego());
    }

    @Test
    public void testVideojuegoDelete() {
        if (videojuegoRepository.existsById(3)) {
            videojuegoRepository.deleteById(3);
        }
        assertFalse(videojuegoRepository.existsById(3));
    }
}
