package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Categoria;
import com.distribuida.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTestUnitaria {

    private Producto producto;

    @BeforeEach
    public void setUp() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);

        producto = new Producto(
                1,
                "FIFA 24",
                "Videojuego de fútbol",
                59.99,
                "videojuego",
                20,
                categoria
        );
    }

    @Test
    public void testProductoConstructor() {
        assertAll("Validar datos del constructor - Producto",
                () -> assertEquals(1, producto.getIdProducto()),
                () -> assertEquals("FIFA 24", producto.getNombre()),
                () -> assertEquals("Videojuego de fútbol", producto.getDescripcion()),
                () -> assertEquals(59.99, producto.getPrecio()),
                () -> assertEquals(20, producto.getStock()),
                () -> assertEquals("videojuego", producto.getTipoProducto()),
                () -> assertEquals(1, producto.getCategoria().getIdCategoria())
        );
    }

    @Test
    public void testProductoSetters() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);

        producto.setIdProducto(2);
        producto.setNombre("Call of Duty MW3");
        producto.setDescripcion("Shooter táctico");
        producto.setPrecio(69.99);
        producto.setStock(15);
        producto.setTipoProducto("videojuego");
        producto.setCategoria(categoria);

        assertAll("Validar datos modificados - Producto",
                () -> assertEquals(2, producto.getIdProducto()),
                () -> assertEquals("Call of Duty MW3", producto.getNombre()),
                () -> assertEquals("Shooter táctico", producto.getDescripcion()),
                () -> assertEquals(69.99, producto.getPrecio()),
                () -> assertEquals(15, producto.getStock()),
                () -> assertEquals("videojuego", producto.getTipoProducto()),
                () -> assertEquals(1, producto.getCategoria().getIdCategoria())
        );
    }

    @Test
    public void testProductoToString() {
        String str = producto.toString();
        assertAll("Validar contenido de toString - Producto",
                () -> assertTrue(str.contains("FIFA 24")),
                () -> assertTrue(str.contains("Videojuego de fútbol")),
                () -> assertTrue(str.contains("59.99")),
                () -> assertTrue(str.contains("videojuego")),
                () -> assertTrue(str.contains("1"))
        );
    }
}
