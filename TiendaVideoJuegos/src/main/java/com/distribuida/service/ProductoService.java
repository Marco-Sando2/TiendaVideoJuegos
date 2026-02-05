package com.distribuida.service;

import com.distribuida.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findOne(int id);

    Producto save(Producto producto);

    Producto update(int id, Producto producto);

    Producto update(Producto producto);

    void delete(int id);
}
