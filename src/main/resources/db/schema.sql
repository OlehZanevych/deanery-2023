DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE faculties
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(64)  NOT NULL UNIQUE,
    website VARCHAR(24)  NOT NULL,
    email   VARCHAR(32)  NOT NULL,
    phone   VARCHAR(32)  NOT NULL,
    address VARCHAR(128) NOT NULL,
    info    TEXT
);