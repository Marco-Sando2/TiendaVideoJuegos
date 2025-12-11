package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Accesorios;
import com.distribuida.model.Consola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsolaTestUnitaria {

    private Consola consola;

    @BeforeEach
    public void setUp() {
        consola = new Consola(11, "Sony", "CFI-1215A", "825GB", "Blanco");
    }

    @Test
    public void testConsolaConstructor() {
        assertAll("Validar datos del constructor - Consola",
                () -> assertEquals(11, consola.getIdConsola()),
                () -> assertEquals("Sony", consola.getMarca()),
                () -> assertEquals("CFI-1215A", consola.getModelo()),
                () -> assertEquals("825GB", consola.getAlmacenamiento()),
                () -> assertEquals("Blanco", consola.getColor())
        );
    }

    @Test
    public void testConsolaSetters() {
        consola.setIdConsola(16);
        consola.setMarca("Nintendo");
        consola.setModelo("Lite");
        consola.setAlmacenamiento("32GB");
        consola.setColor("Azul");

        assertAll("Validar datos modificados - Consola",
                () -> assertEquals(16, consola.getIdConsola()),
                () -> assertEquals("Nintendo", consola.getMarca()),
                () -> assertEquals("Lite", consola.getModelo()),
                () -> assertEquals("32GB", consola.getAlmacenamiento()),
                () -> assertEquals("Azul", consola.getColor())
        );
    }

    @Test
    public void testConsolaToString() {
        String str = consola.toString();
        assertAll("Validar contenido de toString - Consola",
                () -> assertTrue(str.contains("11")),
                () -> assertTrue(str.contains("Sony")),
                () -> assertTrue(str.contains("CFI-1215A")),
                () -> assertTrue(str.contains("825GB")),
                () -> assertTrue(str.contains("Blanco"))
        );
    }

}
