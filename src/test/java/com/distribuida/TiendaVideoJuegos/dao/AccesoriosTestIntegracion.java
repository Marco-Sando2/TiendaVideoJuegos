package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.AccesoriosRepository;
import com.distribuida.model.Accesorios;
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

public class AccesoriosTestIntegracion {
    @Autowired
private AccesoriosRepository accesoriosRepository;

    @Test
    public void testAccesoriosFindAll (){
        List<Accesorios> accesorios = accesoriosRepository.findAll();
        assertNotNull(accesorios);
        assertTrue(accesorios.size() > 0);
        accesorios.forEach(System.out::println);
    }

    @Test
    public void testAccesoriosFindOne() {
        Optional<Accesorios> accesorio = accesoriosRepository.findById(21);
        assertTrue(accesorio.isPresent());
        assertEquals("Sony", accesorio.orElse(null).getMarca());
        System.out.println(accesorio);
    }

    @Test
    public void testAccesoriosSave() {
        Accesorios nuevoAccesorio = new Accesorios(
                21,"Inalámbrico", "PS5", "Sony", "Blanco", "USB-C"
        );
        Accesorios guardado = accesoriosRepository.save(nuevoAccesorio);
        assertNotNull(guardado.getIdProducto());
        assertEquals("Sony", guardado.getMarca());
    }

    @Test
    public void testAccesoriosActualizar() {
        Optional<Accesorios> accesorio = accesoriosRepository.findById(30);
        accesorio.orElseThrow().setColor("Rojo");
        accesorio.orElseThrow().setConexion("HDMI");

        Accesorios actualizado = accesoriosRepository.save(accesorio.orElseThrow());
        assertEquals("Rojo", actualizado.getColor());
        assertEquals("HDMI", actualizado.getConexion());
    }

    @Test
    public void testAccesoriosDelete() {
        if (accesoriosRepository.existsById(30)) {
            accesoriosRepository.deleteById(30);
        }
        assertFalse(accesoriosRepository.existsById(30));
    }



}


