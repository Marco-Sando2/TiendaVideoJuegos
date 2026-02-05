package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaTestUnitaria {

    private Factura factura;

    @BeforeEach
    public void setUp() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);

        factura = new Factura(
                1,
                "F001",
                new Date(2024 - 1900, 0, 5), // 2024-01-05
                120.0,
                14.4,
                134.4,
                cliente
        );
    }

    @Test
    public void testFacturaConstructor() {
        assertAll("Validar datos del constructor - Factura",
                () -> assertEquals(1, factura.getIdFactura()),
                () -> assertEquals("F001", factura.getNumFactura()),
                () -> assertEquals(120.0, factura.getTotalNeto()),
                () -> assertEquals(14.4, factura.getIva()),
                () -> assertEquals(134.4, factura.getTotal()),
                () -> assertEquals(1, factura.getCliente().getIdCliente())
        );
    }

    @Test
    public void testFacturaSetters() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(2);

        factura.setIdFactura(2);
        factura.setNumFactura("F002");
        factura.setFecha(new Date(2024 - 1900, 0, 6)); // 2024-01-06
        factura.setTotalNeto(89.99);
        factura.setIva(10.8);
        factura.setTotal(100.79);
        factura.setCliente(cliente);

        assertAll("Validar datos modificados - Factura",
                () -> assertEquals(2, factura.getIdFactura()),
                () -> assertEquals("F002", factura.getNumFactura()),
                () -> assertEquals(89.99, factura.getTotalNeto()),
                () -> assertEquals(10.8, factura.getIva()),
                () -> assertEquals(100.79, factura.getTotal()),
                () -> assertEquals(2, factura.getCliente().getIdCliente())
        );
    }

    @Test
    public void testFacturaToString() {
        String str = factura.toString();
        assertAll("Validar contenido de toString - Factura",
                () -> assertTrue(str.contains("F001")),
                () -> assertTrue(str.contains("134.4")),
                () -> assertTrue(str.contains("1"))
        );
    }
}

