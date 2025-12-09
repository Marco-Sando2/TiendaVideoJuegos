package com.distribuida.TiendaVideoJuegos.model;


import com.distribuida.model.Accesorios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccesoriosTestUnitaria {

    private Accesorios accesorios;

    @BeforeEach
    public void setUp() {
        accesorios = new Accesorios(21, "Inalámbrico", "PS5", "Sony", "Blanco", "USB-C");
    }

    @Test
    public void testAccesoriosConstructor() {
        assertAll("Validar datos del constructor - Accesorios",
                () -> assertEquals(21, accesorios.getIdProducto()),
                () -> assertEquals("Inalámbrico", accesorios.getConectividad()),
                () -> assertEquals("PS5", accesorios.getCompatibilidad()),
                () -> assertEquals("Sony", accesorios.getMarca()),
                () -> assertEquals("Blanco", accesorios.getColor()),
                () -> assertEquals("USB-C", accesorios.getConexion())
        );
    }

    @Test
    public void testAccesoriosSetters() {
        accesorios.setIdProducto(22);
        accesorios.setConectividad("Cableado");
        accesorios.setCompatibilidad("Switch");
        accesorios.setMarca("Razer");
        accesorios.setColor("Negro");
        accesorios.setConexion("USB");

        assertAll("Validar datos modificados - Accesorios",
                () -> assertEquals(22, accesorios.getIdProducto()),
                () -> assertEquals("Cableado", accesorios.getConectividad()),
                () -> assertEquals("Switch", accesorios.getCompatibilidad()),
                () -> assertEquals("Razer", accesorios.getMarca()),
                () -> assertEquals("Negro", accesorios.getColor()),
                () -> assertEquals("USB", accesorios.getConexion())
        );
    }

    @Test
    public void testAutorToString() {
        String str = accesorios.toString();
        assertAll("Validar contenido de toString - Accesorios",
                () -> assertTrue(str.contains("21")),
                () -> assertTrue(str.contains("Inalámbrico")),
                () -> assertTrue(str.contains("PS5")),
                () -> assertTrue(str.contains("Sony")),
                () -> assertTrue(str.contains("Blanco")),
                () -> assertTrue(str.contains("USB-C"))
        );
    }

}
