CREATE DATABASE horadoevento;

USE horadoevento;

CREATE TABLE usuario(
	cpf varchar(11) primary key,
    username varchar(30) unique not null,
    nome varchar(255) not null,
    email varchar(100) unique not null,
    senha varchar(100) not null,
    linkedin varchar(100),
    foto longblob
);

CREATE TABLE empresa(
	cnpj varchar(14) primary key,
    username varchar(30) unique not null,
    nome varchar(255) not null,
    cidade varchar(50) not null,
    estado varchar(50) not null,
    pais varchar(50) not null,
    senha varchar(100) unique not null,
    email varchar(100) unique not null,
    linkedin varchar(100),
    foto longblob
);

CREATE TABLE tag(
	id serial,
    nome varchar(40)
);

CREATE TABLE tag_usuario(
	id serial,
    fk_tag_id bigint unsigned,
    fk_usuario_cpf varchar(11),
    foreign key (fk_tag_id) references tag(id),
    foreign key (fk_usuario_cpf) references usuario(cpf)
);

CREATE TABLE evento(
	id serial,
    data_hora datetime not null,
    localizacao varchar(255) not null,
    descricao text not null,
    duracao time not null,
    quantidade_vagas smallint not null,
    palestrante varchar(255) not null,
    titulo varchar(255) not null,
	fk_empresa_cnpj varchar(14),
    foreign key (fk_empresa_cnpj) references empresa(cnpj) 
);

CREATE TABLE tag_evento(
	id serial,
    fk_tag_id bigint unsigned,
    fk_evento_id bigint unsigned,
    foreign key (fk_tag_id) references tag(id),
    foreign key (fk_evento_id) references evento(id)
);

CREATE TABLE incricao(
	id serial,
    fk_usuario_cpf varchar(11),
    fk_evento_id bigint unsigned,
    foreign key (fk_usuario_cpf) references usuario(cpf),
    foreign key (fk_evento_id) references evento(id)
);

CREATE TABLE certificado(
	id serial,
    fk_usuario_cpf varchar(11),
    fk_evento_id bigint unsigned,
    quantidade_minutos int,
    foreign key (fk_usuario_cpf) references usuario(cpf),
    foreign key (fk_evento_id) references evento(id)
);

CREATE TABLE empresa_usuario(
	id serial,
    fk_usuario_cpf varchar(11),
    fk_empresa_cnpj varchar(14),
    foreign key (fk_usuario_cpf) references usuario(cpf),
    foreign key (fk_empresa_cnpj) references empresa(cnpj)
);

## INSERTS

INSERT INTO usuario (cpf, username, nome, email, senha, linkedin, foto)
VALUES ('00000000001', 'teste', 'Teste Usuário', 'teste@hde.com', 'Senha123', 'https://linkedin.com/in/teste', null),
('00000000002', 'usuario1', 'Usuario1', 'usuario1@hde.com', 'Senha123', 'https://linkedin.com/in/usuario1', null);

INSERT INTO empresa (cnpj, username, nome, cidade, estado, pais, senha, email, linkedin, foto)
VALUES ('00000000000001', 'teste', 'Teste Empresa', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'teste@hde.com', 'https://linkedin.com/in/teste', null),
('00000000000002', 'empresa1', 'Empresa1', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'empresa1@hde.com', 'https://linkedin.com/in/empresa1', null);

INSERT INTO tag (id, nome)
VALUES (1, 'tag1'), (2, 'tag2');

INSERT INTO evento (data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)
VALUES ('2020-05-29', 'Rua Davi Gamer Br, 100', 'Evento voltato para gamers de todas as idades', '14:25:00', '100', 'Hayash', 'Mega campeonato de COD','00000000000001');

INSERT INTO tag_usuario (id, fk_tag_id, fk_usuario_cpf)
VALUES (1, 1, '00000000001'), (2, 2, '00000000002');

-- USE horadoevento; 
-- DROP DATABASE horadoevento;
-- SELECT* FROM usuario;
