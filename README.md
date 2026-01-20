EventVantage | High-Performance Event Management System


EventVantage es una plataforma Fullstack diseñada para la gestión de reservas de eventos de alta demanda. El núcleo del proyecto es un backend robusto construido con Java 21 y Spring Boot 3, enfocado en la integridad de datos, seguridad y escalabilidad.

🛠️ Tecnologías Principales

Backend: Java 21, Spring Boot 3.4+, Spring Security (JWT).

Base de Datos: MySQL 8 con persistencia mediante Spring Data JPA.

Migraciones: Flyway para el control de versiones del esquema de base de datos.

Documentación: Swagger UI / OpenAPI 3 para la exploración interactiva de la API.

Calidad: JUnit 5, Mockito y validación de datos con Jakarta Bean Validation.

🌟 Características Destacadas

Arquitectura Limpia: Implementación basada en capas (Controller, Service, Repository) con separación estricta de responsabilidades.

Gestión de Concurrencia: Uso de Optimistic Locking (@Version) para garantizar la integridad en reservas simultáneas.

Transacciones ACID: Garantía de atomicidad en procesos críticos como pagos y asignación de tickets mediante @Transactional.

Manejo Global de Excepciones: Sistema centralizado de errores con respuestas JSON consistentes y códigos de estado HTTP semánticos.

Seguridad: Autenticación y autorización Stateless, lista para integración con clientes frontend (Angular/React).

Validación Robusta: Validación de entrada de datos en la capa DTO para asegurar la calidad de la información antes de procesarla.

📈 Flujo de Trabajo (Git Workflow)

Este proyecto utiliza GitHub Flow:

Main Branch: Código estable y listo para producción.

Feature Branches: Desarrollo aislado de nuevas funcionalidades mediante Pull Requests.

Conventional Commits: Historial de cambios estandarizado para facilitar la legibilidad y el mantenimiento.

🔧 Configuración Local

Clonar el repositorio.

Configurar las credenciales de MySQL en src/main/resources/application.properties.

Ejecutar ./mvnw spring-boot:run.

Acceder a la documentación en http://localhost:8080/swagger-ui.html.

💡 Por qué este proyecto es relevante

EventVantage demuestra el dominio de patrones de diseño empresariales y la capacidad de resolver problemas complejos de sincronización de datos y seguridad, habilidades críticas para cualquier rol de Backend Developer Senior en 2026.