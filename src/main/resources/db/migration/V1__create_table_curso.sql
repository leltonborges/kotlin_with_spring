CREATE TABLE TB_CURSO(
  ID bigint not null auto_increment,
  NOME varchar(50) not null,
  CATEGORIA varchar(50) not null,
  constraint PK_curso_tb_curso_index primary key(ID)
);

INSERT INTO TB_CURSO ( NOME , CATEGORIA )
vaLUES
    ('Kotlin', 'Programação'),
    ('Figma', 'UX'),
    ('Python', 'Data Science'),
    ('Java', 'Programcação'),
    ('React', 'Front End'),
    ('NextJS', 'NodeJS');