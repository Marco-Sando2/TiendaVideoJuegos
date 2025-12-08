package com.distribuida.service;

import com.distribuida.model.Videojuego;

import java.util.List;
import java.util.Optional;

public interface VideojuegoService {

    List<Videojuego> findAll();

    Optional<Videojuego> findOne(int id);

    Videojuego save(Videojuego videojuego);

    Videojuego update(int id, Videojuego videojuego);

    Videojuego update(Videojuego videojuego);

    void delete(int id);
}
