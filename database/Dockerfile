FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=RootPassword
ENV MYSQL_USER=Bruno
ENV MYSQL_PASSWORD=BrunoPassword
ENV MYSQL_DATABASE=usuarios_docker

COPY ./usuarios_docker_database.sql /docker-entrypoint-initdb.d/usuarios_docker_database.sql

