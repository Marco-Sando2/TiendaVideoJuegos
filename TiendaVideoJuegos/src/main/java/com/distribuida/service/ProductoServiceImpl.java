package com.distribuida.service;

import com.distribuida.dao.ProductoRepository;
import com.distribuida.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findOne(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(int id, Producto producto) {
        if (!productoRepository.existsById(id)) {
            return null;
        }
        producto.setIdProducto(id);
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        int id = producto.getIdProducto();
        if (!productoRepository.existsById(id)) {
            return null;
        }
        return productoRepository.save(producto);
    }

    @Override
    public void delete(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
    }
}
