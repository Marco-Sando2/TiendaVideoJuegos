package com.distribuida.service;

import com.distribuida.dao.VideojuegosRepository;
import com.distribuida.model.Videojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @Override
    public List<Videojuego> findAll() {
        return videojuegosRepository.findAll();
    }

    @Override
    public Optional<Videojuego> findOne(int id) {
        return videojuegosRepository.findById(id);
    }

    @Override
    public Videojuego save(Videojuego videojuego) {
        return videojuegosRepository.save(videojuego);
    }

    @Override
    public Videojuego update(int id, Videojuego videojuego) {
        if (!videojuegosRepository.existsById(id)) {
            return null;
        }
        videojuego.setIdProducto(id);
        return videojuegosRepository.save(videojuego);
    }

    @Override
    public Videojuego update(Videojuego videojuego) {
        int id = videojuego.getIdProducto();
        if (!videojuegosRepository.existsById(id)) {
            return null;
        }
        return videojuegosRepository.save(videojuego);
    }

    @Override
    public void delete(int id) {
        if (videojuegosRepository.existsById(id)) {
            videojuegosRepository.deleteById(id);
        }
    }
}
