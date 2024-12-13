package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/{cliId}")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto, @PathVariable Long cliId) {
        try {
            Producto nuevoProducto = productoService.createProducto(producto, cliId);
            return ResponseEntity.ok(nuevoProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
            // Usa el Optional para verificar si el producto fue actualizado
            Optional<Producto> updatedProducto = productoService.updateProducto(id, productoDetails);

            return updatedProducto.map(ResponseEntity::ok) // Si el producto existe, devuelve un 200 con el producto actualizado
                    .orElse(ResponseEntity.notFound().build()); // Si no existe, devuelve un 404

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        return productoService.deleteProducto(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
