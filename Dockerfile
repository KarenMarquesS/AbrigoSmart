# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia os arquivos do projeto
COPY pom.xml .
COPY src ./src

# Compila o projeto e gera o JAR
RUN mvn clean package 

# Etapa 2: Imagem leve para execução
FROM eclipse-temurin:17-jdk-alpine

#Cria o usuário não root  'devforge'
RUN adduser -h /home/devforge -s /bin/bash -D devforge

# Define o diretório para o não root
WORKDIR /home/devforge

# Copia do .jar gerado no build
COPY --from=builder /app/target/AbrigoSmart-0.0.1-SNAPSHOT.jar app.jar

# Altera a permissão do .jar para o usuario
USER devforge

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]




