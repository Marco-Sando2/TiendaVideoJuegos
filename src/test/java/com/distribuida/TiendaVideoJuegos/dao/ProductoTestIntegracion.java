package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.ProductoRepository;
import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Producto;
import com.distribuida.model.Categoria;
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
public class ProductoTestIntegracion {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testProductoFindAll() {
        List<Producto> productos = productoRepository.findAll();
        assertNotNull(productos);
        assertTrue(productos.size() > 0);
        productos.forEach(System.out::println);
    }

    // 2. Buscar un producto por ID
    @Test
    public void testProductoFindOne() {
        Optional<Producto> producto = productoRepository.findById(1);
        assertTrue(producto.isPresent());
        assertEquals("FIFA 24", producto.orElseThrow().getNombre());
        System.out.println(producto);
    }

    @Test
    public void testProductoSave() {
        Categoria categoria = categoriaRepository.findById(1).orElseThrow();

        Producto nuevoProducto = new Producto(
                0, // dejar que JPA lo genere automáticamente
                "FIFA 24",
                "Videojuego de fútbol",
                59.99,
                "Videojuego",
                20,
                categoria
        );

        Producto guardado = productoRepository.save(nuevoProducto);

        assertNotNull(guardado.getIdProducto());
        assertEquals("FIFA 24", guardado.getNombre());
        assertEquals("Videojuego", guardado.getTipoProducto());
        assertEquals(1, guardado.getCategoria().getIdCategoria());
    }

    @Test
    public void testProductoActualizar() {
        Optional<Producto> producto = productoRepository.findById(2);
        producto.orElseThrow().setPrecio(49.99);
        producto.orElseThrow().setStock(30);

        Producto actualizado = productoRepository.save(producto.orElseThrow());
        assertEquals(49.99, actualizado.getPrecio());
        assertEquals(30, actualizado.getStock());
    }

    @Test
    public void testProductoDelete() {
        // Crear una categoría temporal para la prueba
        Producto nueva = new Producto();
        nueva.setNombre("Temporal");
        nueva.setDescripcion("Futbol");

        // Guardar la categoría en la BD
        Producto guardada = productoRepository.save(nueva);

        // Eliminar la categoría recién creada
        productoRepository.deleteById(guardada.getIdProducto());

        // Validar que ya no exista
        assertFalse(productoRepository.existsById(guardada.getIdProducto()));
    }
}

