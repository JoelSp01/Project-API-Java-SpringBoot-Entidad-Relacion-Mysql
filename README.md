# Proyecto Spring Boot API - Gestión de Productos y Clientes

Este proyecto es una API RESTful construida con **Spring Boot** que permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre las entidades de **productos** y **clientes**. La API está conectada a una base de datos y expone varios **endpoints** para interactuar con los datos de clientes y productos.

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

### 6. **GET /productos**

Obtiene todos los productos almacenados en la base de datos.

- **Respuesta**: Un array de objetos `Producto`.

### 7. **GET /productos/{id}**

Obtiene un producto específico dado su **id**.

- **Parámetro**: 
  - `id`: El identificador único del producto.
- **Respuesta**: Un objeto `Producto` con los detalles del producto solicitado.

### 8. **POST /productos/{cliId}**

Crea un nuevo producto y lo asocia a un cliente dado su **cliId**. Los datos del producto deben enviarse en formato **JSON**.

- **Parámetro**: 
  - `cliId`: El identificador único del cliente asociado al producto.
- **Cuerpo de la solicitud**: Un objeto JSON con los atributos del producto.

### 9. **PUT /productos/{id}**

Actualiza los datos de un producto específico, dado su **id**. Solo se actualizarán los campos proporcionados en el cuerpo de la solicitud. También puede actualizar el cliente asociado si se proporciona el `cliId`.

- **Parámetro**: 
  - `id`: El identificador único del producto a actualizar.
- **Cuerpo de la solicitud**: Un objeto JSON con los datos actualizados del producto.

### 10. **DELETE /productos/{id}**

Elimina un producto específico, dado su **id**.

- **Parámetro**: 
  - `id`: El identificador único del producto a eliminar.

### 11. **GET /clientes/{id}/productos**

Obtiene todos los productos asociados a un cliente específico dado su **id**.

- **Parámetro**: 
  - `id`: El identificador único del cliente.
- **Respuesta**: Un array de objetos `Producto` asociados al cliente.

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

### 2. **Entity: Producto**

La clase `Producto` representa la estructura de un producto en la base de datos. Se utiliza para mapear los atributos del producto a los campos de la tabla correspondiente en la base de datos. Cada producto está asociado a un cliente a través del campo `cliente`.

**Principales atributos**:

- `id`: Identificador único del producto.
- `prodNombre`: Nombre del producto.
- `prodDescripcion`: Descripción del producto.
- `prodPrecio`: Precio del producto.
- `prodStock`: Cantidad en stock del producto.
- `cliente`: El cliente al que pertenece el producto.

### 3. **Interface: ClienteRepository**

La interfaz `ClienteRepository` extiende `JpaRepository`, lo que le permite acceder a las funcionalidades CRUD predefinidas sin necesidad de escribir código adicional para las operaciones comunes sobre la base de datos, como `findAll()`, `findById()`, y `save()`.

### 4. **Interface: ProductoRepository**

La interfaz `ProductoRepository` extiende `JpaRepository`, lo que permite realizar las operaciones CRUD sobre los productos. Incluye métodos para obtener productos, guardar nuevos productos, y eliminar productos.

### 5. **Servicio: ClienteService**

La clase `ClienteService` contiene la lógica de negocio relacionada con los clientes. Se encarga de coordinar las operaciones entre el controlador y el repositorio de clientes, además de manejar las excepciones y las respuestas a las solicitudes de los clientes.

### 6. **Servicio: ProductoService**

La clase `ProductoService` contiene la lógica de negocio relacionada con los productos. Se encarga de coordinar las operaciones entre el controlador y el repositorio de productos, además de manejar las excepciones y las respuestas a las solicitudes de los productos.

### 7. **Controller: ClienteController**

El `ClienteController` maneja las solicitudes HTTP para la entidad `Cliente`. Utiliza el `ClienteService` para interactuar con la base de datos y realizar operaciones como obtener, crear, actualizar y eliminar clientes.

### 8. **Controller: ProductoController**

El `ProductoController` maneja las solicitudes HTTP para la entidad `Producto`. Utiliza el `ProductoService` para interactuar con la base de datos y realizar operaciones CRUD sobre los productos. Además, permite ver los productos asociados a un cliente a través del endpoint `/clientes/{id}/productos`.

---

## Cómo Probar la API

Para probar los endpoints de esta API, puedes utilizar **Postman** o cualquier herramienta que permita hacer solicitudes HTTP.

### Clientes:

1. **GET /clientes**: Obtiene todos los clientes.
2. **GET /clientes/{id}**: Obtiene un cliente específico por su **id**.
3. **POST /clientes**: Crea un nuevo cliente enviando un objeto JSON.
4. **PUT /clientes/{id}**: Actualiza un cliente específico con el **id** correspondiente.
5. **DELETE /clientes/{id}**: Elimina un cliente específico con el **id** correspondiente.

### Productos:

1. **GET /productos**: Obtiene todos los productos.
2. **GET /productos/{id}**: Obtiene un producto específico por su **id**.
3. **POST /productos/{cliId}**: Crea un nuevo producto asociado a un cliente enviando un objeto JSON con los atributos del producto.
4. **PUT /productos/{id}**: Actualiza un producto específico con el **id** correspondiente.
5. **DELETE /productos/{id}**: Elimina un producto específico con el **id** correspondiente.

### Productos de un Cliente:

1. **GET /clientes/{id}/productos**: Obtiene todos los productos asociados a un cliente específico por su **id**.

---
