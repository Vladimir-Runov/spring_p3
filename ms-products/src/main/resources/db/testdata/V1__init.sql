create table users
(
    id         bigserial primary key,
    username      varchar(255) not null unique,
    password      varchar(255) not null,
    email      varchar(255) not null

);
create table roles (
  id           bigserial primary key (id),
  name      varchar(255) not null unique,
  created_at timestamp default current_timestamp

);
create table users_roles (
  user_id           bigint not null references users (id),
  role_id           bigint not null references roles (id),
  primary key (user_id,role_id)
);

insert into roles (name) values ('ROLE_USER'),('ROLE_ADMIN');
insert into users (username,password,email) values
('userAdmin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'userAdmin@gmail.com'),
('user',    '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'userAdmin@gmail.com');

insert into users_roles (user_id,role_id) values (1,1),(2,2);

create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values ('Bread', 24),
       ('Milk', 65),
       ('Cheese', 320),
       ('Cheese2', 322),
       ('Cheese3', 323),
       ('Cheese4', 324),
       ('Cheese5', 325),
       ('Cheese6', 326),
       ('Cheese7', 327),
       ('Cheese8', 328),
       ('Cheese9', 328),
       ('Cheese10', 328),
       ('Cheese11', 328),
       ('Cheese12', 328),
       ('Cheese13', 328),
       ('Cheese14', 328),
       ('Cheese15', 328);
