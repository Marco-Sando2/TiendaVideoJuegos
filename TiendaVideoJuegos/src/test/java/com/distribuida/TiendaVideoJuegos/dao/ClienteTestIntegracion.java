package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class ClienteTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testClienteFindAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item : clientes) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testClienteFindOne() {
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertNotNull(cliente.isPresent());
        assertEquals("Carlos", cliente.orElse(null).getNombre());
        assertEquals("Mendoza", cliente.orElse(null).getApellido());
        System.out.println(cliente);

    }

    @Test
    public void testClienteSave() {
        Cliente cliente = new Cliente(0, "0102030405", "Carlos", "Mendoza", "Av.América 123", "0981234567", "carlos.m@gmail.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("0102030405", clienteGuardado.getCedula());
        assertEquals("Carlos", clienteGuardado.getNombre());
    }

    @Test
    public void testClienteActualizar() {
        Optional<Cliente> cliente2 = clienteRepository.findById(84);

        cliente2.orElse(null).setCedula("172839456");
        cliente2.orElse(null).setNombre("Juan88");
        cliente2.orElse(null).setApellido("Taipe88");
        cliente2.orElse(null).setDireccion("Direccion88");
        cliente2.orElse(null).setTelefono("0936251488");
        cliente2.orElse(null).setCorreo("correo88@correeo.com");

        Cliente clienteActualizado = clienteRepository.save(cliente2.orElse(null));

        assertNotNull(clienteActualizado);
        assertEquals("Taipe88", clienteActualizado.getApellido());
        assertEquals("Direccion88", clienteActualizado.getDireccion());
    }

    @Test
    public void testClienteDelete() {

        int idCliente = 85;

        if (clienteRepository.existsById(idCliente)) {
            clienteRepository.deleteById(idCliente);
        }

        assertFalse(clienteRepository.existsById(idCliente));
    }

}