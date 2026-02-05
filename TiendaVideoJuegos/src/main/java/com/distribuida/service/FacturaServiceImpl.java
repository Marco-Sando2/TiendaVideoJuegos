package com.distribuida.service;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findOne(int id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura update(int id, Factura factura) {
        if (!facturaRepository.existsById(id)) {
            return null;
        }
        factura.setIdFactura(id);
        return facturaRepository.save(factura);
    }

    @Override
    public Factura update(Factura factura) {
        int id = factura.getIdFactura();
        if (!facturaRepository.existsById(id)) {
            return null;
        }
        return facturaRepository.save(factura);
    }

    @Override
    public void delete(int id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
        }
    }
}
