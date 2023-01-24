--liquibase formatted sql
--changeset fliper:1
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');

--changeset fliper:2
INSERT INTO app_user (name, username, password) VALUES ('John Doe', 'testuser', 'password123');

--changeset fliper:3
INSERT INTO app_user_roles (id, role_id) VALUES (1, 1);