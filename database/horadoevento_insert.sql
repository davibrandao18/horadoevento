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

insert into usuario 
(cpf, username, nome, email, senha, linkedin)
values
('12365478100', 'joaosilba', 'joao da silva', 'joao@gmail.com', '123joao', 'www.linkedin/joao'),
('15975346588', 'mariasantos', 'maria dos santos', 'maria@gmail.com', '321maria', 'www.linkedin/maria'),
('95135748266', 'pedroalves', 'pedro alves', 'pedro@gmail.com', '213pedro', 'www.linkedin/pedro');

select * from usuario;

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

insert into empresa
(cnpj, username, nome, cidade, estado, pais, senha, email, linkedin)
values
('15975345687952', 'mbi', 'mbi', 'sao paulo', 'sao paulo', 'brasil', 'mbi321', 'mbi@empresa.com', 'www.linkedin/mbi'),
('78945612365491', 'io', 'io', 'curitiba', 'parana', 'brasil', 'io456', 'io@empresa.com', 'www.linkedin/io'),
('74185296398745', 'xilften', 'xilften', 'detroit', 'michigan', 'eua', 'xilften89', 'xilften@empresa.com', 'www.linkedin/xilften');

select * from empresa;

CREATE TABLE tag(
	id serial,
    nome varchar(40)
);

insert into tag 
(nome)
values
('tag1'),
('tag2'),
('tag3');

select * from tag;

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

insert into evento 
(data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo)
values
('2020-02-03', 'goias', 'evento super bacana', '02:00:00', '350', 'joao silva', 'evento bacana'),
('2020-09-14', 'sao paulo', 'evento 2.0 do evento bacana', '06:00:00', '54', 'marina silva', 'evento 2.0');

select * from evento;

CREATE TABLE tag_evento(
	id serial,
    fk_tag_id bigint unsigned,
    fk_evento_id bigint unsigned,
    foreign key (fk_tag_id) references tag(id),
    foreign key (fk_evento_id) references evento(id)
);

CREATE TABLE isncricao(
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