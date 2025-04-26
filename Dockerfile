# Usar una imagen base de Maven para compilar y ejecutar la aplicación
FROM maven:3.8.6-openjdk-17 AS builder

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Construir la aplicación y generar el archivo JAR
RUN mvn clean package -DskipTests

# --------------------------------------
# Crear una imagen ligera para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la imagen de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8863

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar",,"--spring.config.location=application.properties"]
