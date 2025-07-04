# Usa l'immagine di base ufficiale di OpenJDK
FROM eclipse-temurin:17-jdk-alpine

# Crea la directory dell'app
WORKDIR /app

# Copia il file jar costruito
COPY target/booking-service-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta del servizio
EXPOSE 8081

# Comando di avvio del container
ENTRYPOINT ["java", "-jar", "app.jar"]