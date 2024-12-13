package com.example.demo.repository;
import com.example.demo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para obtener clientes con productos
    @Query("SELECT c FROM Cliente c JOIN FETCH c.productos")
    List<Cliente> findAllWithProducts();
}
