package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriaTestUnitaria {

    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(1, "Videojuegos", "Videojuegos físicos y digitales");
    }

    @Test
    public void testAccesoriosConstructor() {
        assertAll("Validar datos del constructor - Accesorios",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Videojuegos", categoria.getCategoria()),
                () -> assertEquals("Videojuegos físicos y digitales", categoria.getDescripcion())
        );
    }

    @Test
    public void testAccesoriosSetters() {
        categoria.setIdCategoria(22);
        categoria.setCategoria("Cableado");
        categoria.setDescripcion("Switch");


        /*assertAll("Validar datos modificados - Accesorios",
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
    }*/
}
}
