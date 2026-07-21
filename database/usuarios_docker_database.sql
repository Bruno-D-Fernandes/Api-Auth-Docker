CREATE DATABASE IF NOT EXISTS usuarios_docker;
USE usuarios_docker;

CREATE TABLE usuario_table(
	id INT PRIMARY KEY NOT NULL,
    nome_usuario VARCHAR(75) NOT NULL UNIQUE,
    email_usuario VARCHAR(100) NOT NULL UNIQUE,
    password_usuario VARCHAR(250) NOT NULL,
    url_profile_picture VARCHAR(300) UNIQUE
);g