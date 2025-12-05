package com.distribuida.dao;

import com.distribuida.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer>{
}
