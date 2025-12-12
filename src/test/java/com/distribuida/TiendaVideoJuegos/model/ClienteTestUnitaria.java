package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente(
                1,
                "0102030405",
                "Carlos",
                "Mendoza",
                "Av. América 123",
                "0981234567",
                "carlos.m@gmail.com"
        );
    }

    @Test
    public void testClienteConstructor() {
        assertAll("Validar datos del constructor - Cliente",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("0102030405", cliente.getCedula()),
                () -> assertEquals("Carlos", cliente.getNombre()),
                () -> assertEquals("Mendoza", cliente.getApellido()),
                () -> assertEquals("Av. América 123", cliente.getDireccion()),
                () -> assertEquals("0981234567", cliente.getTelefono()),
                () -> assertEquals("carlos.m@gmail.com", cliente.getCorreo())
        );
    }

    @Test
    public void testClienteSetters() {
        cliente.setIdCliente(2);
        cliente.setCedula("0203040506");
        cliente.setNombre("Luis");
        cliente.setApellido("Pérez");
        cliente.setDireccion("Calle Loja 45");
        cliente.setTelefono("0982345678");
        cliente.setCorreo("luisp@hotmail.com");

        assertAll("Validar datos modificados - Cliente",
                () -> assertEquals(2, cliente.getIdCliente()),
                () -> assertEquals("0203040506", cliente.getCedula()),
                () -> assertEquals("Luis", cliente.getNombre()),
                () -> assertEquals("Pérez", cliente.getApellido()),
                () -> assertEquals("Calle Loja 45", cliente.getDireccion()),
                () -> assertEquals("0982345678", cliente.getTelefono()),
                () -> assertEquals("luisp@hotmail.com", cliente.getCorreo())
        );
    }

    @Test
    public void testClienteToString() {
        String str = cliente.toString();
        assertAll("Validar contenido de toString - Cliente",
                () -> assertTrue(str.contains("Carlos")),
                () -> assertTrue(str.contains("Mendoza")),
                () -> assertTrue(str.contains("0102030405")),
                () -> assertTrue(str.contains("Av. América 123")),
                () -> assertTrue(str.contains("carlos.m@gmail.com"))
        );
    }
}
