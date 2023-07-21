--liquibase formatted sql

--changeset janis:1

CREATE TABLE employee
(
    id   serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);