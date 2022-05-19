CREATE TABLE TB_USUARIO
(
    ID    bigint not null auto_increment,
    NOME  varchar(50) not null,
    EMAIL varchar(50) not null,
    constraint PK_usuario_tb_usuario_index primary key (ID)
);

INSERT INTO TB_USUARIO (NOME, EMAIL)
VALUES ('Lia', 'lia@example.com'),
       ('Bia', 'bia@example.com'),
       ('Alex', 'alex@example.com'),
       ('Bob', 'bob@example.com'),
       ('Marcus', 'marcus@example.com'),
       ('Maria', 'maria@example.com');