package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.ProductoRepository;
import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Producto;
import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
                "PRUEBA",
                "Prueba",
                59.99,
                "Videojuego",
                20,
                categoria
        );

        Producto guardado = productoRepository.save(nuevoProducto);

        assertNotNull(guardado.getIdProducto());
        assertEquals("PRUEBA", guardado.getNombre());
        assertEquals("Videojuego", guardado.getTipoProducto());
        assertEquals(1, guardado.getCategoria().getIdCategoria());
    }

    @Test
    public void testProductoActualizar() {
        Optional<Producto> producto = productoRepository.findById(109);
        producto.orElseThrow().setPrecio(99.99);
        producto.orElseThrow().setStock(50);

        Producto actualizado = productoRepository.save(producto.orElseThrow());
        assertEquals(99.99, actualizado.getPrecio());
        assertEquals(50, actualizado.getStock());
    }

    @Test
    public void testProductoDelete() {
        int idProducto = 110;

        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
        }

        assertFalse(productoRepository.existsById(idProducto));
    }
}

