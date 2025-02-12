FROM openjdk:21-jdk-slim
LABEL authors="jhon"

WORKDIR /product-service

# Copiar el archivo JAR de la aplicación al contenedor
COPY build/libs/product-service-1.0-SNAPSHOT.jar product-service.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8083

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "product-service.jar"]