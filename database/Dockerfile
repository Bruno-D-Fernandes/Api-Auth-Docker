FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=rootPassword
ENV MYSQL_USER=Bruno
ENV MYSQL_PASSWORD=BrunoPassword

COPY ./usuarios.sql /docker-entrypoint-initdb.d/usuarios.sql
