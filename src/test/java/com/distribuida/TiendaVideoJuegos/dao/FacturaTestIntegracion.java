package com.distribuida.TiendaVideoJuegos.dao;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Factura;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFacturaFindAll() {
        List<Factura> facturas = facturaRepository.findAll();
        assertNotNull(facturas);
        assertTrue(facturas.size() > 0);
        facturas.forEach(System.out::println);
    }

    @Test
    public void testFacturaFindOne() {
        Optional<Factura> factura = facturaRepository.findById(1);
        assertTrue(factura.isPresent());
        assertEquals("F001", factura.orElseThrow().getNumFactura());
        System.out.println(factura);
    }

    @Test
    public void testFacturaSave() {
        Cliente cliente = clienteRepository.findById(1).orElseThrow();

        Factura nuevaFactura = new Factura(
                0,
                "FAC-100",
                new Date(),
                100.00,
                12.00,
                112.00,
                cliente
        );

        Factura guardada = facturaRepository.save(nuevaFactura);

        assertNotNull(guardada.getIdFactura());
        assertEquals("FAC-100", guardada.getNumFactura());
        assertEquals(cliente.getIdCliente(), guardada.getCliente().getIdCliente());
    }

    @Test
    public void testFacturaActualizar() {
        Optional<Factura> factura = facturaRepository.findById(2);
        factura.orElseThrow().setTotalNeto(200.00);
        factura.orElseThrow().setIva(24.00);
        factura.orElseThrow().setTotal(224.00);

        Factura actualizada = facturaRepository.save(factura.orElseThrow());
        assertEquals(200.00, actualizada.getTotalNeto());
        assertEquals(224.00, actualizada.getTotal());
    }

    @Test
    public void testFacturaDelete() {
        if (facturaRepository.existsById(79)) {
            facturaRepository.deleteById(79);
        }
        assertFalse(facturaRepository.existsById(79));
    }
}
