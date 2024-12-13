package com.example.demo.controller;

import com.example.demo.DTO.ClienteDto;
import com.example.demo.entity.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<ClienteDto> listarClientes() {
        return clienteService.listarClientes();
    }

    // Obtener cliente por ID (retorna ClienteDto)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(c -> ResponseEntity.ok(new ClienteDto(
                        c.getCliId(),
                        c.getCliNombre(),
                        c.getCliApellido(),
                        c.getCliCedula())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

@GetMapping("/con-productos")
public List<Cliente> listarClientesConProductos() {
    return clienteService.listarClientesConProductos();
}

    @PostMapping
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto clienteCreado = clienteService.crearCliente(clienteDto);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }


    // Actualizar cliente existente (retorna ClienteDto)
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        Optional<Cliente> clienteActualizado = clienteService.actualizarCliente(id, clienteDetalles);
        return clienteActualizado.map(cliente -> {
            ClienteDto clienteDto = new ClienteDto(
                    cliente.getCliId(),
                    cliente.getCliNombre(),
                    cliente.getCliApellido(),
                    cliente.getCliCedula()
            );
            return ResponseEntity.ok(clienteDto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        boolean eliminado = clienteService.eliminarCliente(id);
        return eliminado ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
