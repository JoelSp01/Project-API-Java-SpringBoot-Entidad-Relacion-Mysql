//package com.example.demo.entity;
//
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ProductoTest {
//
//    @Test
//    void testProductoGettersAndSetters() {
//        // Crear una instancia de Producto
//        Producto producto = new Producto();
//
//        // Establecer valores para los atributos
//        producto.setId(1L);
//        producto.setNombre("Laptop");
//        producto.setDescripcion("Laptop de alta gama con procesador i7");
//        producto.setPrecio(BigDecimal.valueOf(1500.75));
//        producto.setStock(20);
//
//        // Verificar valores usando los getters
//        assertAll(
//                () -> assertEquals(1L, producto.getId(), "El ID debe ser 1"),
//                () -> assertEquals("Laptop", producto.getNombre(), "El nombre debe ser 'Laptop'"),
//                () -> assertEquals("Laptop de alta gama con procesador i7", producto.getDescripcion(), "La descripción no coincide"),
//                () -> assertEquals(BigDecimal.valueOf(1500.75), producto.getPrecio(), "El precio debe ser 1500.75"),
//                () -> assertEquals(20, producto.getStock(), "El stock debe ser 20")
//        );
//    }
//}
