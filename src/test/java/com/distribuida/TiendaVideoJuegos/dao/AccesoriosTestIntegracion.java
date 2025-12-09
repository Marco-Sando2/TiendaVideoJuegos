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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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



}


