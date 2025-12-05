package com.distribuida.dao;

import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsolaRepository extends JpaRepository<Cliente, Integer> {
}
