create table product
(
    id           integer generated always as identity
        constraint product_pk primary key,
    name         varchar not null,
    manufacturer varchar not null,
    description  text
);

alter table product
    owner to postgres;

create table product_image_location
(
    id         integer generated always as identity
        constraint product_image_location_pk
            primary key,
    url        varchar,
    product_id integer
        constraint product_image_location_product_id_fk
            references product
);

alter table product_image_location
    owner to postgres;
