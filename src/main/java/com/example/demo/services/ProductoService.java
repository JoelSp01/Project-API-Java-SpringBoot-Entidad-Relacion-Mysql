package com.example.demo.services;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductosRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> updateProducto(Long id, Producto productoDetails) {
        return productoRepository.findById(id).map(producto -> {
            producto.setProdNombre(productoDetails.getProdNombre());
            producto.setProdDescripcion(productoDetails.getProdDescripcion());
            producto.setProdPrecio(productoDetails.getProdPrecio());
            producto.setProdStock(productoDetails.getProdStock());
            return productoRepository.save(producto);
        });
    }

    public boolean deleteProducto(Long id) {
        return productoRepository.findById(id).map(producto -> {
            productoRepository.delete(producto);
            return true;
        }).orElse(false);
    }
}
