package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
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
        Cliente cliente = new Cliente(1, "0102030405", "Carlos", "Mendoza", "Av.América 123", "0981234567", "carlos.m@gmail.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("0102030405", clienteGuardado.getCedula());
        assertEquals("Carlos", clienteGuardado.getNombre());
    }

    @Test
    public void testClienteActualizar() {
        Optional<Cliente> cliente2 = clienteRepository.findById(4);

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
        // Crear un cliente temporal para la prueba
        Cliente nuevo = new Cliente();
        nuevo.setCedula("9999999999");
        nuevo.setNombre("Temporal");
        nuevo.setApellido("Prueba");
        nuevo.setDireccion("Dirección temporal");
        nuevo.setTelefono("0000000000");
        nuevo.setCorreo("temp@test.com");

        // Guardar el cliente en la BD
        Cliente guardado = clienteRepository.save(nuevo);

        // Eliminar el cliente recién creado
        clienteRepository.deleteById(guardado.getIdCliente());

        // Validar que ya no exista
        assertFalse(clienteRepository.existsById(guardado.getIdCliente()));
    }

}