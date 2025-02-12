FROM openjdk:21-jdk-slim
LABEL authors="jhon"

WORKDIR /company-service

# Copiar el archivo JAR de la aplicación al contenedor
COPY build/libs/company-services-1.0-SNAPSHOT.jar company-service.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "company-service.jar"]