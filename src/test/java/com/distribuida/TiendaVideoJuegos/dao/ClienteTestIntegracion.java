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
    public void testClienteFindAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item: clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void testClienteFindOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertNotNull(cliente.isPresent());
        assertEquals("Carlos",cliente.orElse(null).getNombre());
        assertEquals("Mendoza",cliente.orElse(null).getApellido());
        System.out.println(cliente);

    }

    @Test
    public void testClienteSave(){
        Cliente cliente = new Cliente(1,"0102030405","Carlos","Mendoza","Av.América 123","0981234567","carlos.m@gmail.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("0102030405", clienteGuardado.getCedula());
        assertEquals("Carlos", clienteGuardado.getNombre());
    }

    @Test
    public void testClienteActualizar(){
        Optional <Cliente> cliente = clienteRepository.findById(4);

        cliente.orElse(null).setCedula("172839456");
        cliente.orElse(null).setNombre("Juan88");
        cliente.orElse(null).setApellido("Taipe88");
        cliente.orElse(null).setDireccion("Taipe88");
        cliente.orElse(null).setTelefono("0936251488");
        cliente.orElse(null).setCorreo("coreoo888@correeo.com");
        clienteRepository.save(cliente.orElse(null));

    }

  /*  @Test
    public void testClienteDelete() {
        if (clienteRepository.existsById(5)) {
            clienteRepository.deleteById(5);
        }
        assertFalse(clienteRepository.existsById(5));*/



}
