package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.CategoriaRepository;
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
public class CategoriaTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriaFindAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);
        categorias.forEach(System.out::println);
    }

    @Test
    public void testCategoriaFindOne() {
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        assertTrue(categoria.isPresent());
        assertEquals("Videojuegos", categoria.orElseThrow().getCategoria());
        System.out.println(categoria);
    }

    @Test
    public void testCategoriaSave() {
        Categoria nuevaCategoria = new Categoria(1, "Videojuegos", "Videojuegos físicos y digitales");
        Categoria guardada = categoriaRepository.save(nuevaCategoria);
        assertNotNull(guardada.getIdCategoria());
        assertEquals("Videojuegos", guardada.getCategoria());
    }

    @Test
    public void testCategoriaActualizar() {
        Optional<Categoria> categoria = categoriaRepository.findById(10);
        categoria.orElseThrow().setCategoria("Videojuegos");
        categoria.orElseThrow().setDescripcion("Juegos físicos y digitales");

        Categoria actualizada = categoriaRepository.save(categoria.orElseThrow());
        assertEquals("Videojuegos", actualizada.getCategoria());
        assertEquals("Juegos físicos y digitales", actualizada.getDescripcion());
    }

    @Test
    public void testCategoriaDelete() {
        // Crear una categoría temporal para la prueba
        Categoria nueva = new Categoria();
        nueva.setCategoria("Temporal");
        nueva.setDescripcion("Categoría de prueba temporal");

        // Guardar la categoría en la BD
        Categoria guardada = categoriaRepository.save(nueva);

        // Eliminar la categoría recién creada
        categoriaRepository.deleteById(guardada.getIdCategoria());

        // Validar que ya no exista
        assertFalse(categoriaRepository.existsById(guardada.getIdCategoria()));
    }
}
