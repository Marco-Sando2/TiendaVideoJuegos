package com.distribuida.service;

import com.distribuida.dao.ConsolaRepository;
import com.distribuida.model.Consola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsolaServiceImpl implements ConsolaService {

    @Autowired
    private ConsolaRepository consolaRepository;

    @Override
    public List<Consola> findAll() {
        return consolaRepository.findAll();
    }

    @Override
    public Optional<Consola> findOne(int id) {
        return consolaRepository.findById(id);
    }

    @Override
    public Consola save(Consola consola) {
        return consolaRepository.save(consola);
    }

    @Override
    public Consola update(int id, Consola consola) {
        if (!consolaRepository.existsById(id)) {
            return null;
        }
        consola.setIdConsola(id);
        return consolaRepository.save(consola);
    }

    @Override
    public Consola update(Consola consola) {
        int id = consola.getIdConsola();
        if (!consolaRepository.existsById(id)) {
            return null;
        }
        return consolaRepository.save(consola);
    }

    @Override
    public void delete(int id) {
        if (consolaRepository.existsById(id)) {
            consolaRepository.deleteById(id);
        }
    }
}
