--liquibase formatted sql

--changeset zhuganov:1
create type status as enum ('WAITING', 'APPROVED', 'REJECTED', 'CANCELED');

--changeset zhuganov:2
create table if not exists users
(
    id    bigserial primary key,
    name  varchar(255)        not null,
    email varchar(512) unique not null
);

--changeset zhuganov:3
create table if not exists item_request
(
    id           bigserial primary key,
    description  varchar(4000)               not null,
    created      timestamp without time zone not null,
    requester_id bigint references users (id)
);

--changeset zhuganov:4
create table if not exists item
(
    id          bigserial primary key,
    name        varchar(255),
    description varchar(4000),
    available   boolean,
    owner_id    bigint not null references users (id),
    request_id  bigint references item_request (id),
    UNIQUE (owner_id, name)
);

--changeset zhuganov:5
create table if not exists booking
(
    id              bigserial primary key,
    start_date_time timestamp without time zone not null,
    end_date_time   timestamp without time zone not null,
    --approved        boolean                     not null, --вариант практикума
    --canceled        boolean                     not null, --вариант практикума
    status          status                      not null,
    item_id         bigint references item (id),
    booker_id       bigint references users (id)
);

--changeset zhuganov:6
create table if not exists comment
(
    id        bigserial primary key,
    text      varchar(4000)               not null,
    created   timestamp without time zone not null,
    item_id   bigint references item (id),
    author_id bigint references users (id)
);

