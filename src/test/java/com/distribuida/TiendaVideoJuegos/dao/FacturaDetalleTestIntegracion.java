package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.dao.FacturaRepository;
import com.distribuida.dao.ProductoRepository;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Factura;
import com.distribuida.model.Producto;
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
public class FacturaDetalleTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void testFacturaDetalleFindAll() {
        List<FacturaDetalle> detalles = facturaDetalleRepository.findAll();
        assertNotNull(detalles);
        assertTrue(detalles.size() > 0);
        detalles.forEach(System.out::println);
    }

    @Test
    public void testFacturaDetalleFindOne() {
        Optional<FacturaDetalle> detalle = facturaDetalleRepository.findById(81);
        assertTrue(detalle.isPresent());
        assertEquals(1, detalle.orElseThrow().getCantidad());
        System.out.println(detalle);
    }

    @Test
    public void testFacturaDetalleSave() {
        // Recuperar factura y producto existentes
        Factura factura = facturaRepository.findById(1).orElseThrow();
        Producto producto = productoRepository.findById(1).orElseThrow();

        FacturaDetalle nuevoDetalle = new FacturaDetalle(
                81,
                1,
                producto.getPrecio() * 59.99,
                factura,
                producto
        );

        FacturaDetalle guardado = facturaDetalleRepository.save(nuevoDetalle);

        assertNotNull(guardado.getIdFacturaDetalle());
        assertEquals(1, guardado.getCantidad());
        assertEquals(producto.getPrecio() * 59.99, guardado.getSubtotal());
    }

    @Test
    public void testFacturaDetalleActualizar() {
        Optional<FacturaDetalle> detalle = facturaDetalleRepository.findById(160);
        detalle.orElseThrow().setCantidad(5);
        detalle.orElseThrow().setSubtotal(detalle.orElseThrow().getProducto().getPrecio());

        FacturaDetalle actualizado = facturaDetalleRepository.save(detalle.orElseThrow());
        assertEquals(5, actualizado.getCantidad());
    }

    @Test
    public void testFacturaDetalleDelete() {
        if (facturaDetalleRepository.existsById(160)) {
            facturaDetalleRepository.deleteById(160);
        }
        assertFalse(facturaDetalleRepository.existsById(160));
    }
}
