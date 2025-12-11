package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepository.findAll();
    }

    @Override
    public Optional<FacturaDetalle> findOne(int id) {
        return facturaDetalleRepository.findById(id);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle detalle) {
        return facturaDetalleRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle detalle) {
        if (!facturaDetalleRepository.existsById(id)) {
            return null;
        }
        detalle.setIdFacturaDetalle(id);
        return facturaDetalleRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(FacturaDetalle detalle) {
        int id = detalle.getIdFacturaDetalle();
        if (!facturaDetalleRepository.existsById(id)) {
            return null;
        }
        return facturaDetalleRepository.save(detalle);
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
        }
    }
}
