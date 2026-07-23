CREATE DATABASE IF NOT EXISTS usuarios_docker;
USE usuarios_docker;

CREATE TABLE usuario_table(
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    /* Removi os UNIQUE de nome e email temporáriamente */
    nome_usuario VARCHAR(75) NOT NULL ,
    email_usuario VARCHAR(100) NOT NULL ,
    password_usuario VARCHAR(250) NOT NULL,
    url_profile_picture VARCHAR(300) UNIQUE
);git