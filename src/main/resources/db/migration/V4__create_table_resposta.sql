CREATE TABLE TB_RESPOSTA
(
    ID    bigint not null auto_increment,
    MENSAGEM  varchar(50) not null,
    DATA_CRIACAO DATETIME not null,
    ID_AUTOR bigint not null,
    ID_TOPICO bigint not null,
    SOLUCAO BOOLEAN not null,
    constraint pk_resposta_tb_usuario_resposta primary key (ID),
    constraint fk_resposta_tb_curso_resposta foreign key(ID_AUTOR) references TB_USUARIO(ID),
    constraint fk_resposta_tb_topico_resposta foreign key(ID_TOPICO) references TB_TOPICO(ID)
);