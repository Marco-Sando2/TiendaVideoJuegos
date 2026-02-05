package com.distribuida.controller;

import com.distribuida.model.Producto;
import com.distribuida.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findOne(@PathVariable int id){
        return productoService.findOne(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto producto1 = productoService.save(producto);
        return ResponseEntity.ok(producto1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable int id, @RequestBody Producto producto){
        Producto producto1 = productoService.update(id, producto);
        if(producto1 ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
