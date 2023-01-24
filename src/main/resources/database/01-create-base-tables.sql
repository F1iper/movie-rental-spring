--liquibase formatted sql
--changeset fliper:1

CREATE TABLE IF NOT EXISTS app_user (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30),
username VARCHAR(30),
password VARCHAR(255)
);

--changeset fliper:2

CREATE TABLE IF NOT EXISTS role (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL
);

--changeset fliper:3

CREATE TABLE IF NOT EXISTS app_user_roles (
id BIGINT NOT NULL FOREIGN KEY app_user(id) REFERENCES app_user(id),
role_id BIGINT NOT NULL FOREIGN KEY (role_id) REFERENCES role(id)
);
