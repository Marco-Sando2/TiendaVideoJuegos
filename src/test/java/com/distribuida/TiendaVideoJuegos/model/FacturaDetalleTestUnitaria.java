package com.distribuida.TiendaVideoJuegos.model;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacturaDetalleTestUnitaria {

    private FacturaDetalle facturaDetalle;

    @BeforeEach
    public void setUp() {
        Factura factura = new Factura();
        factura.setIdFactura(1);

        Producto producto = new Producto();
        producto.setIdProducto(1);

        facturaDetalle = new FacturaDetalle(
                81,
                1,
                59.99,
                factura,
                producto
        );
    }

    @Test
    public void testFacturaDetalleConstructor() {
        assertAll("Validar datos del constructor - FacturaDetalle",
                () -> assertEquals(81, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(1, facturaDetalle.getCantidad()),
                () -> assertEquals(59.99, facturaDetalle.getSubtotal()),
                () -> assertEquals(1, facturaDetalle.getFactura().getIdFactura()),
                () -> assertEquals(1, facturaDetalle.getProducto().getIdProducto())
        );
    }

    /*@Test
    public void testFacturaDetalleSetters() {
        facturaDetalle.setIdFacturaDetalla(22);
        facturaDetalle.setCantidad("Cableado");
        accesorios.setC("Switch");
        accesorios.setMarca("Razer");
        accesorios.setColor("Negro");
        accesorios.setConexion("USB");

        assertAll("Validar datos modificados - Accesorios",
                () -> assertEquals(22, accesorios.getIdProducto()),
                () -> assertEquals("Cableado", accesorios.getConectividad()),
                () -> assertEquals("Switch", accesorios.getCompatibilidad()),
                () -> assertEquals("Razer", accesorios.getMarca()),
                () -> assertEquals("Negro", accesorios.getColor()),
                () -> assertEquals("USB", accesorios.getConexion())
        );
    }

    @Test
    public void testAutorToString() {
        String str = accesorios.toString();
        assertAll("Validar contenido de toString - Accesorios",
                () -> assertTrue(str.contains("21")),
                () -> assertTrue(str.contains("Inalámbrico")),
                () -> assertTrue(str.contains("PS5")),
                () -> assertTrue(str.contains("Sony")),
                () -> assertTrue(str.contains("Blanco")),
                () -> assertTrue(str.contains("USB-C"))
        );
    }

}*/

}
