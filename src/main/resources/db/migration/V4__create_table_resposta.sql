CREATE TABLE TB_RESPOSTA
(
    id    bigint not null auto_increment not null,
    mensagem  varchar(50) not null,
    data_criacao DATETIME not null,
    id_autor bigint not null,
    id_topico bigint not null,
    solucao BOOLEAN not null,
    constraint pk_resposta_tb_usuario_resposta primary key (id),
    constraint fk_resposta_tb_curso_resposta foreign key(id_autor) references TB_USUARIO(id),
    constraint fk_resposta_tb_topico_resposta foreign key(id_topico) references TB_TOPICO(id)
);