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

    @Test
    public void testFacturaDetalleSetters() {
        Factura factura = new Factura();
        factura.setIdFactura(1);

        Producto producto = new Producto();
        producto.setIdProducto(21);

        facturaDetalle.setIdFacturaDetalle(82);
        facturaDetalle.setCantidad(2);
        facturaDetalle.setSubtotal(119.98);
        facturaDetalle.setFactura(factura);
        facturaDetalle.setProducto(producto);

        assertAll("Validar datos modificados - FacturaDetalle",
                () -> assertEquals(82, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(2, facturaDetalle.getCantidad()),
                () -> assertEquals(119.98, facturaDetalle.getSubtotal()),
                () -> assertEquals(1, facturaDetalle.getFactura().getIdFactura()),
                () -> assertEquals(21, facturaDetalle.getProducto().getIdProducto())
        );
    }

    @Test
    public void testFacturaDetalleToString() {
        String str = facturaDetalle.toString();
        assertAll("Validar contenido de toString - FacturaDetalle",
                () -> assertTrue(str.contains("81")),
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("59.99")),
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("1"))
        );
    }

}

