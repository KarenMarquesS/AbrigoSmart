# Construindo o Container com a aplicação java

# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Criação do usuário
RUN adduser -h /home/devforge -s /bin/bash -D devforge

WORKDIR /app

# Troca para o usuário não-root 'devforge'
USER devforge

# Copia os arquivos do projeto
COPY pom.xml .

COPY src ./src

# Compila o projeto e gera o JAR
RUN mvn clean package 

# Etapa 2: Imagem leve para execução
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho na imagem final
WORKDIR /app

#Cria o usuário não root  'devforge'
RUN adduser -D -h /home/devforge -s /bin/bash devforge

# Copia o JAR gerado na etapa de build
COPY --from=builder /app/target/AbrigoSmart-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pelo Spring Boot 
EXPOSE 8080

# Variável de ambiente opcional 
ENV SERVER_PORT=8080

# Define o usuário que irá executar o comando ENTRYPOINT
USER devforge

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]




