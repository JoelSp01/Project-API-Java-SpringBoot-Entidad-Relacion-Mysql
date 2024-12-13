package com.example.demo.services;

import com.example.demo.DTO.ClienteDto;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();  // Recuperas los clientes desde la base de datos
        List<ClienteDto> clientesDto = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDto clienteDto = new ClienteDto(
                    cliente.getCliId(),
                    cliente.getCliNombre(),
                    cliente.getCliApellido(),
                    cliente.getCliCedula()
            );
            clientesDto.add(clienteDto);
        }

        return clientesDto;
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteDto crearCliente(ClienteDto clienteDto) {
        // Convertir ClienteDto a Cliente
        Cliente cliente = new Cliente();
        cliente.setCliNombre(clienteDto.getCliNombre());
        cliente.setCliApellido(clienteDto.getCliApellido());
        cliente.setCliCedula(clienteDto.getCliCedula());

        // Guardar en la base de datos
        Cliente clienteCreado = clienteRepository.save(cliente);

        // Convertir Cliente de vuelta a ClienteDto
        return new ClienteDto(
                clienteCreado.getCliId(),
                clienteCreado.getCliNombre(),
                clienteCreado.getCliApellido(),
                clienteCreado.getCliCedula()
        );
    }


    public Optional<Cliente> actualizarCliente(Long id, Cliente clienteDetalles) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setCliNombre(clienteDetalles.getCliNombre());
            cliente.setCliApellido(clienteDetalles.getCliApellido());
            cliente.setCliCedula(clienteDetalles.getCliCedula());
            return clienteRepository.save(cliente);
        });
    }

    public boolean eliminarCliente(Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
    }

    // Método para obtener clientes con productos
    public List<Cliente> listarClientesConProductos() {
        return clienteRepository.findAllWithProducts();
    }
}
