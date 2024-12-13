package com.example.demo.services;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductosRepository productoRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto createProducto(Producto producto, Long cliId) {
        Optional<Cliente> cliente = clienteRepository.findById(cliId);
        if (cliente.isPresent()) {
            producto.setCliente(cliente.get());
            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Cliente con ID " + cliId + " no encontrado.");
        }
    }

    public Optional<Producto> updateProducto(Long id, Producto productoDetails) {
        return productoRepository.findById(id).map(producto -> {
            producto.setProdNombre(productoDetails.getProdNombre());
            producto.setProdDescripcion(productoDetails.getProdDescripcion());
            producto.setProdPrecio(productoDetails.getProdPrecio());
            producto.setProdStock(productoDetails.getProdStock());

            // Si el cliId está presente, actualizar el cliente asociado
            if (productoDetails.getCliente() != null && productoDetails.getCliente().getCliId() != null) {
                Optional<Cliente> cliente = clienteRepository.findById(productoDetails.getCliente().getCliId());
                if (cliente.isPresent()) {
                    producto.setCliente(cliente.get());
                } else {
                    throw new RuntimeException("Cliente con ID " + productoDetails.getCliente().getCliId() + " no encontrado.");
                }
            }

            return productoRepository.save(producto);
        });
    }


    public boolean deleteProducto(Long id) {
        return productoRepository.findById(id).map(producto -> {
            productoRepository.delete(producto);
            return true;
        }).orElse(false);
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

}
