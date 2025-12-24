FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el JAR ya compilado por Jenkins
COPY target/todolist-1.0.0.jar app.jar

# Puerto de la aplicación
EXPOSE 8081

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
