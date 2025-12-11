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
    public void testCategoriaConstructor() {
        assertAll("Validar datos del constructor - Categoria",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Videojuegos", categoria.getCategoria()),
                () -> assertEquals("Videojuegos físicos y digitales", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaSetters() {
        categoria.setIdCategoria(2);
        categoria.setCategoria("Consolas");
        categoria.setDescripcion("Consolas de Videojuegos");


        assertAll("Validar datos modificados - Categoria",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("Consolas", categoria.getCategoria()),
                () -> assertEquals("Consolas de Videojuegos", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaToString() {
        String str = categoria.toString();
        assertAll("Validar contenido de toString - Categoria",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Videojuegos")),
                () -> assertTrue(str.contains("Videojuegos físicos y digitales"))
        );
    }
}

