CREATE TABLE TB_CURSO(
  id bigint not null auto_increment,
  nome varchar(50) not null,
  categoria varchar(50) not null,
  constraint PK_curso_tb_curso_index primary key(id)
);

INSERT INTO TB_CURSO ( NOME , CATEGORIA )
vaLUES
    ('Kotlin', 'Programação'),
    ('Figma', 'UX'),
    ('Python', 'Data Science'),
    ('Java', 'Programcação'),
    ('React', 'Front End'),
    ('NextJS', 'NodeJS');