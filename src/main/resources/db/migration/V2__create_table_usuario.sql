CREATE TABLE TB_USUARIO
(
    id    bigint not null auto_increment,
    nome  varchar(50) not null,
    email varchar(50) not null,
    constraint PK_usuario_tb_usuario_index primary key (id)
);

INSERT INTO TB_USUARIO (NOME, EMAIL)
VALUES ('Lia', 'lia@example.com'),
       ('Bia', 'bia@example.com'),
       ('Alex', 'alex@example.com'),
       ('Bob', 'bob@example.com'),
       ('Marcus', 'marcus@example.com'),
       ('Maria', 'maria@example.com');