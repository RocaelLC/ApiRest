package com.example.demo.Service;

import com.example.demo.model.Producto;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto findById(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        productoRepository.deleteById(id);
    }
}