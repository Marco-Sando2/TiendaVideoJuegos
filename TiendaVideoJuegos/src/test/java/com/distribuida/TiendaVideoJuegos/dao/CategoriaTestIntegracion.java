package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
        assertEquals("Videojuegos", categoria.orElse(null).getCategoria());
        System.out.println("Categoría encontrada: " + categoria.orElse(null));
    }

    @Test
    public void testCategoriaSave() {
        Categoria categoria = new Categoria(0, "Consolas", "PlayStation, Xbox y Nintendo Switch");
        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        assertNotNull(categoriaGuardada);
        assertEquals("Consolas", categoriaGuardada.getCategoria());
        assertEquals("PlayStation, Xbox y Nintendo Switch", categoriaGuardada.getDescripcion());
    }

    @Test
    public void testCategoriaUpdate() {
        Optional<Categoria> categoria = categoriaRepository.findById(3);
        assertTrue(categoria.isPresent());

        categoria.orElse(null).setCategoria("Accesorios");
        categoria.orElse(null).setDescripcion("Mandos, auriculares y periféricos gamer");

        Categoria categoriaActualizada = categoriaRepository.save(categoria.orElse(null));
        assertNotNull(categoriaActualizada);
        assertEquals("Accesorios", categoriaActualizada.getCategoria());
        assertEquals("Mandos, auriculares y periféricos gamer", categoriaActualizada.getDescripcion());
    }

    @Test
    public void testCategoriaDelete() {
        int idCategoria = 5;

        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
        }

        assertFalse(categoriaRepository.existsById(idCategoria));
    }
}
