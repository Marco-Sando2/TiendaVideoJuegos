package com.distribuida.service;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findOne(int id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(int id, Categoria categoria) {
        if (!categoriaRepository.existsById(id)) {
            return null;
        }
        categoria.setIdCategoria(id);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        int id = categoria.getIdCategoria();
        if (!categoriaRepository.existsById(id)) {
            return null;
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void delete(int id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        }
    }
}
