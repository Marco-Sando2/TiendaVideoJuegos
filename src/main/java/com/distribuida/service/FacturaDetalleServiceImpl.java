package com.distribuida.service;

import com.distribuida.dao.FacturaDetallRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetallRepository facturaDetallRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetallRepository.findAll();
    }

    @Override
    public Optional<FacturaDetalle> findOne(int id) {
        return facturaDetallRepository.findById(id);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle detalle) {
        return facturaDetallRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle detalle) {
        if (!facturaDetallRepository.existsById(id)) {
            return null;
        }
        detalle.setIdFacturaDetalla(id);
        return facturaDetallRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(FacturaDetalle detalle) {
        int id = detalle.getIdFacturaDetalla();
        if (!facturaDetallRepository.existsById(id)) {
            return null;
        }
        return facturaDetallRepository.save(detalle);
    }

    @Override
    public void delete(int id) {
        if (facturaDetallRepository.existsById(id)) {
            facturaDetallRepository.deleteById(id);
        }
    }
}
