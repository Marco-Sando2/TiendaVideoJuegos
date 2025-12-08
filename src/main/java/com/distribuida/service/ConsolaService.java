package com.distribuida.service;

import com.distribuida.model.Consola;

import java.util.List;
import java.util.Optional;

public interface ConsolaService {

    List<Consola> findAll();

    Optional<Consola> findOne(int id);

    Consola save(Consola consola);

    Consola update(int id, Consola consola);

    Consola update(Consola consola);

    void delete(int id);
}
