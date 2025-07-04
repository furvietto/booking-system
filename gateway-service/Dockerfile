# Usa l'immagine Java base
FROM eclipse-temurin:17-jdk-alpine

# Crea directory e imposta la working dir
WORKDIR /app

# Copia il file JAR generato da Maven
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta del gateway
EXPOSE 8080

# Comando di avvio
ENTRYPOINT ["java", "-jar", "app.jar"]