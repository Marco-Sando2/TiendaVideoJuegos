package com.distribuida.dao;

import com.distribuida.model.Cliente;
import com.distribuida.model.Consola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsolaRepository extends JpaRepository<Consola, Integer> {
}
