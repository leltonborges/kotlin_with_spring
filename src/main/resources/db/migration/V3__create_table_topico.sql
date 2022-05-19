CREATE TABLE TB_TOPICO
(
    ID    bigint not null auto_increment,
    TITULO  varchar(50) not null,
    MENSAGEM  varchar(50) not null,
    STATUS  varchar(50) not null,
    DATA_CRIACAO DATETIME not null,
    ID_CURSO bigint not null,
    ID_AUTOR bigint not null,
    constraint pk_topico_tb_usuario_topico primary key (ID),
    constraint fk_topico_tb_curso_topico foreign key(ID_CURSO) references TB_CURSO(ID),
    constraint fk_topico_tb_autor_topico foreign key(ID_AUTOR) references TB_USUARIO(ID)
);