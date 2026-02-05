package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findOne(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return null;
        }
        cliente.setIdCliente(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        int id = cliente.getIdCliente();
        if (!clienteRepository.existsById(id)) {
            return null;
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
    }
}
