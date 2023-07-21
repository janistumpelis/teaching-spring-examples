--liquibase formatted sql

--changeset janis:2

CREATE TABLE contact_info
(
    id   serial PRIMARY KEY,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);