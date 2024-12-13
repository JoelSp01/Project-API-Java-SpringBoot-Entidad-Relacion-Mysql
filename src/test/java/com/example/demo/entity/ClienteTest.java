//package com.example.demo.entity;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ClienteTest {
//
//    @Test
//    void test() {
//        Cliente cliente = new Cliente();
//
//        // Configuramos los valores usando los setters
//        cliente.setId(1L);
//        cliente.setNombre("Juan");
//        cliente.setApellido("Pérez");
//        cliente.setCedula("1234567890");
//
//        // Realizamos las aserciones para verificar los valores usando los getters
//        assertAll(
//                () -> assertEquals(1L, cliente.getId(), "El ID no coincide"),
//                () -> assertEquals("Juan", cliente.getNombre(), "El nombre no coincide"),
//                () -> assertEquals("Pérez", cliente.getApellido(), "El apellido no coincide"),
//                () -> assertEquals("1234567890", cliente.getCedula(), "La cédula no coincide")
//        );
//    }
//}
