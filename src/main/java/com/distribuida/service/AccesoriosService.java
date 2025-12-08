package com.distribuida.service;

import com.distribuida.model.Accesorios;

import java.util.List;
import java.util.Optional;

public interface AccesoriosService {

    List<Accesorios> findAll();

    Optional<Accesorios> findOne(int id);

    Accesorios save(Accesorios accesorios);

    Accesorios update(int id, Accesorios accesorios);

    Accesorios update(Accesorios accesorios);

    void delete(int id);
}
