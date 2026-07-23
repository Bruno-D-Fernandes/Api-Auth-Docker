
# Imagem que já em com Maven e com a jdk
FROM maven:3.9.16-eclipse-temurin-17 AS build

# Direto que vamos trabalhar
WORKDIR /app

#Já está relativo ao diretorio
COPY pom.xml .
COPY mvnw .
COPY .mvn/ .mvn

# Baixa as dependencias maven
RUN ./mvnw dependency:go-offline

COPY src ./src

#Gera o JAR
RUN ./mvnw clean package -DskipTests -B

#Aqui pra baixo já é "do zero"
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]