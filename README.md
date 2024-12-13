# Proyecto Spring Boot API - Gestión de Clientes

Este proyecto es una API RESTful construida con **Spring Boot** que permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre una entidad de clientes. La API está conectada a una base de datos y expone varios **endpoints** para interactuar con los datos de los clientes.

---

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para crear la API.
- **Spring Data JPA**: Para la persistencia de datos y gestión de la base de datos.
- **Postman**: Para probar los endpoints de la API.

---

## Endpoints Disponibles

### 1. **GET /clientes**

Obtiene todos los clientes almacenados en la base de datos.

- **Respuesta**: Un array de objetos `Cliente`.

### 2. **GET /clientes/{id}**

Obtiene un cliente específico dado su **id**.

- **Parámetro**: 
  - `id`: El identificador único del cliente.
- **Respuesta**: Un objeto `Cliente` con los detalles del cliente solicitado.

### 3. **POST /clientes**

Crea un nuevo cliente. Los datos del cliente deben enviarse en formato **JSON**.

- **Cuerpo de la solicitud**: Un objeto JSON con los atributos del cliente.

### 4. **PUT /clientes/{id}**

Actualiza los datos de un cliente específico, dado su **id**. Solo se actualizarán los campos proporcionados en el cuerpo de la solicitud.

- **Parámetro**: 
  - `id`: El identificador único del cliente a actualizar.
- **Cuerpo de la solicitud**: Un objeto JSON con los datos actualizados del cliente.

### 5. **DELETE /clientes/{id}**

Elimina un cliente específico, dado su **id**.

- **Parámetro**: 
  - `id`: El identificador único del cliente a eliminar.

---

## Explicación del Proyecto

Este proyecto sigue el patrón **MVC** (Modelo-Vista-Controlador), y está dividido en los siguientes componentes:

### 1. **Entity: Cliente**

La clase `Cliente` representa la estructura de un cliente en la base de datos. Se utiliza para mapear los atributos del cliente a los campos de la tabla correspondiente en la base de datos.

**Principales atributos**:

- `id`: Identificador único del cliente.
- `nombre`: Nombre del cliente.
- `apellido`: Apellido del cliente.
- `cedula`: Cédula o documento de identificación del cliente.

### 2. **Interface: ClienteRepository**

La interfaz `ClienteRepository` extiende `JpaRepository`, lo que le permite acceder a las funcionalidades CRUD predefinidas sin necesidad de escribir código adicional para las operaciones comunes sobre la base de datos, como `findAll()`, `findById()`, y `save()`.

### 3. **Controller: ClienteController**

El `ClienteController` maneja las solicitudes HTTP. Utiliza el `ClienteRepository` para interactuar con la base de datos y realizar operaciones como obtener, crear, actualizar y eliminar clientes.

Cada método en el controlador está asociado con un **endpoint** específico que recibe solicitudes de los clientes y devuelve las respuestas adecuadas. Los métodos utilizan anotaciones como `@GetMapping`, `@PostMapping`, `@PutMapping` y `@DeleteMapping` para definir las rutas y los métodos HTTP que manejarán.

---

## Cómo Probar la API

Para probar los endpoints de esta API, puedes utilizar **Postman** o cualquier herramienta que permita hacer solicitudes HTTP.

1. **GET /clientes**: Obtiene todos los clientes.
2. **GET /clientes/{id}**: Obtiene un cliente específico por su **id**.
3. **POST /clientes**: Crea un nuevo cliente enviando un objeto JSON.
4. **PUT /clientes/{id}**: Actualiza un cliente específico con el **id** correspondiente.
5. **DELETE /clientes/{id}**: Elimina un cliente específico con el **id** correspondiente.
