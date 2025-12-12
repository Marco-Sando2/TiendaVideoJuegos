package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Videojuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VideojuegoTestUnitaria {

    private Videojuego videojuego;

    @BeforeEach
    public void setUp() {
        videojuego = new Videojuego(
                1,
                "PS5",
                "Deportes",
                "2023-09-15",
                "EA Sports",
                "T",
                "Multijugador"
        );
    }

    @Test
    public void testVideojuegoConstructor() {
        assertAll("Validar datos del constructor - Videojuego",
                () -> assertEquals(1, videojuego.getIdProducto()),
                () -> assertEquals("PS5", videojuego.getPlataforma()),
                () -> assertEquals("Deportes", videojuego.getGenero()),
                () -> assertEquals("2023-09-15", videojuego.getFechaLanzamiento()),
                () -> assertEquals("EA Sports", videojuego.getEstudio()),
                () -> assertEquals("T", videojuego.getCalsificacion()),
                () -> assertEquals("Multijugador", videojuego.getModoJuego())
        );
    }

    @Test
    public void testVideojuegoSetters() {
        videojuego.setIdProducto(2);
        videojuego.setPlataforma("PS5");
        videojuego.setGenero("Shooter");
        videojuego.setFechaLanzamiento("2023-11-10");
        videojuego.setEstudio("Activision");
        videojuego.setCalsificacion("M");
        videojuego.setModoJuego("Multijugador");

        assertAll("Validar datos modificados - Videojuego",
                () -> assertEquals(2, videojuego.getIdProducto()),
                () -> assertEquals("PS5", videojuego.getPlataforma()),
                () -> assertEquals("Shooter", videojuego.getGenero()),
                () -> assertEquals("2023-11-10", videojuego.getFechaLanzamiento()),
                () -> assertEquals("Activision", videojuego.getEstudio()),
                () -> assertEquals("M", videojuego.getCalsificacion()),
                () -> assertEquals("Multijugador", videojuego.getModoJuego())
        );
    }

    @Test
    public void testVideojuegoToString() {
        String str = videojuego.toString();
        assertAll("Validar contenido de toString - Videojuego",
                () -> assertTrue(str.contains("PS5")),
                () -> assertTrue(str.contains("Deportes")),
                () -> assertTrue(str.contains("2023-09-15")),
                () -> assertTrue(str.contains("EA Sports")),
                () -> assertTrue(str.contains("T")),
                () -> assertTrue(str.contains("Multijugador"))
        );
    }
}
