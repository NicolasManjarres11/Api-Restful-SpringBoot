# 📚 API RESTful - Sistema de Gestión de Biblioteca

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Descripción

API RESTful desarrollada con Spring Boot para la gestión de una biblioteca. Esta aplicación permite realizar operaciones CRUD completas sobre libros, incluyendo funcionalidades específicas como préstamos y búsquedas avanzadas.

## ✨ Características

- **CRUD Completo**: Crear, leer, actualizar y eliminar libros
- **Sistema de Préstamos**: Gestionar el estado de préstamo de los libros
- **Búsqueda Avanzada**: Buscar libros por título o autor
- **Validación de Datos**: Validación automática de entradas
- **Documentación API**: Swagger/OpenAPI integrado
- **Base de Datos PostgreSQL**: Persistencia robusta de datos
- **Manejo de Excepciones**: Gestión personalizada de errores

## 🛠️ Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5.0** - Framework de desarrollo
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos
- **Lombok** - Reducción de código boilerplate
- **Hibernate Validator** - Validación de datos
- **SpringDoc OpenAPI** - Documentación de API
- **Maven** - Gestión de dependencias

## 📦 Prerrequisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado:

- **Java 21** o superior
- **Maven 3.8+**
- **PostgreSQL 15+**
- **Git**

## 🚀 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/NicolasManjarres11/Api-Restful-SpringBoot.git
cd apirestful-springboot
```

### 2. Configurar Base de Datos

1. **Crear base de datos PostgreSQL:**
```sql
CREATE DATABASE librarydb;
```

2. **Configurar credenciales** en `src/main/resources/application.properties`:
```properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

### 3. Ejecutar la Aplicación

```bash
# Compilar y ejecutar con Maven
mvn spring-boot:run

# O alternativamente
mvn clean install
java -jar target/apirestful-springboot-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: `http://localhost:8080`

## 📖 Documentación de la API

### Swagger UI
Accede a la documentación interactiva de la API en:
```
http://localhost:8080/swagger-ui.html
```

### Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/libros` | Obtener todos los libros |
| `GET` | `/api/libros/{id}` | Obtener libro por ID |
| `GET` | `/api/libros/buscar?searchTerm={term}` | Buscar libros por título o autor |
| `POST` | `/api/libros` | Crear nuevo libro |
| `PUT` | `/api/libros/{id}` | Actualizar libro existente |
| `DELETE` | `/api/libros/{id}` | Eliminar libro |
| `POST` | `/api/libros/{id}/prestar` | Prestar libro |

### Estructura de Datos

#### BookRequest (Entrada)
```json
{
  "title": "Don Quijote de la Mancha",
  "author": "Miguel de Cervantes",
  "isbn": "545-736-232",
  "releaseDate": "2006-03-25",
  "genre": "Drama"
}
```

#### BookResponse (Salida)
```json
{
  "id": 17,
  "title": "Don Quijote de la Mancha",
  "author": "Miguel de Cervantes",
  "isbn": "545-736-232",
  "releaseDate": "2006-03-25",
  "genre": "Drama",
  "state": "DISPONIBLE"
}
```

## 🔧 Configuración

### Variables de Entorno

Puedes configurar las siguientes variables en `application.properties`:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb
spring.datasource.username=postgres
spring.datasource.password=admin123

# Configuración JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/devsenior/nmanja/apirestful_springboot/
│   │       ├── controllers/
│   │       │   └── LibraryController.java
│   │       ├── models/
│   │       │   ├── dto/
│   │       │   │   ├── BookRequest.java
│   │       │   │   └── BookResponse.java
│   │       │   └── entities/
│   │       │       └── Book.java
│   │       ├── repositories/
│   │       │   └── LibraryRepository.java
│   │       ├── services/
│   │       │   ├── LibraryService.java
│   │       │   └── impl/
│   │       │       └── LibraryServiceImpl.java
│   │       └── exceptions/
│   │           ├── BookAlreadyLentException.java
│   │           ├── BookNotFoundById.java
│   │           └── NotBookFoundsException.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/devsenior/nmanja/apirestful_springboot/
            └── ApirestfulSpringbootApplicationTests.java
```

## 🐛 Manejo de Errores

La API incluye manejo personalizado de excepciones:

- **400 Bad Request**: Datos de entrada inválidos
- **404 Not Found**: Libro no encontrado
- **500 Internal Server Error**: Libro ya prestado


## 🙏 Agradecimientos

- Spring Boot Team por el excelente framework
- PostgreSQL por la base de datos robusta
- Comunidad de desarrolladores Dev Senior, por la asesoria y el conocimiento brindado para el desarrollo del proyecto.

---

⭐ Si este proyecto te ha sido útil, ¡no olvides darle una estrella! 
