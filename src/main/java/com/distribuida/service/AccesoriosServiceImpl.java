package com.distribuida.service;

import com.distribuida.dao.AccesoriosRepository;
import com.distribuida.model.Accesorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccesoriosServiceImpl implements AccesoriosService {

    @Autowired
    private AccesoriosRepository accesoriosRepository;

    @Override
    public List<Accesorios> findAll() {
        return accesoriosRepository.findAll();
    }

    @Override
    public Optional<Accesorios> findOne(int id) {
        return accesoriosRepository.findById(id);
    }

    @Override
    public Accesorios save(Accesorios accesorios) {
        return accesoriosRepository.save(accesorios);
    }

    @Override
    public Accesorios update(int id, Accesorios accesorios) {
        if (!accesoriosRepository.existsById(id)) {
            return null;
        }
        accesorios.setIdProducto(id);
        return accesoriosRepository.save(accesorios);
    }

    @Override
    public Accesorios update(Accesorios accesorios) {
        int id = accesorios.getIdProducto();
        if (!accesoriosRepository.existsById(id)) {
            return null;
        }
        return accesoriosRepository.save(accesorios);
    }

    @Override
    public void delete(int id) {
        if (accesoriosRepository.existsById(id)) {
            accesoriosRepository.deleteById(id);
        }
    }
}
