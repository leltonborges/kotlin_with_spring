CREATE TABLE TB_TOPICO
(
    id    bigint not null auto_increment not null,
    titulo  varchar(50) not null,
    mensagem  varchar(50) not null,
    data_criacao DATETIME not null,
    id_curso bigint not null,
    id_autor bigint not null,
    constraint pk_topico_tb_usuario_topico primary key (id),
    constraint fk_topico_tb_curso_topico foreign key(id_curso) references TB_CURSO(id),
    constraint fk_topico_tb_autor_topico foreign key(id_autor) references TB_USUARIO(id)
);