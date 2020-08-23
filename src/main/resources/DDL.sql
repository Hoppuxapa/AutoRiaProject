create schema if not exists public;

create database Database with owner postgres;

comment on schema public is 'public schema';

alter schema public owner to postgres;


Drop TABLE users CASCADE ;


CREATE TABLE users
(
    id            serial,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100),
    age           int CHECK (age > 0),
    login         VARCHAR(20)  NOT NULL,
    email         VARCHAR(100) NOT NULL,
    password      VARCHAR(60)  NOT NULL,
    register_time bigint,
    user_status   VARCHAR(25),
    PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    user_id        serial,
    user_role VARCHAR(25),
    CONSTRAINT user_role_pkey PRIMARY KEY (user_id),
        FOREIGN KEY (user_id)
        REFERENCES users (id)
);

alter table users
    owner to postgres;


