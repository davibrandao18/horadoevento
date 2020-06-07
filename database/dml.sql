## usuario
INSERT INTO usuario (cpf, username, nome, email, senha, linkedin, foto)
VALUES ('00000000001', 'amanda', 'Amanda Larissa', 'amandalarissa@gmail.com', 'Senha123', 'https://linkedin.com/in/amandalarissa', null),
('00000000002', 'maicon', 'Maicon Souza', 'maiconsouza@gmail.com', 'Senha123', 'https://linkedin.com/in/maiconsouza', null),
('00000000003', 'willian', 'Willian Ferrari', 'willianferrari@hgmail.com', 'Senha123', 'www.linkedin/in/willianferrari', null),
('00000000004', 'ingrid', 'Ingrid Carpes', 'ingridcarpes@gmail.com', 'Senha123', 'www.linkedin/in/ingridcarpes', null),
('00000000005', 'davi', 'Davi Brandão', 'davibrandao@gmail.com', 'Senha123', 'www.linkedin/in/davibrandao', null);


## empresa
INSERT INTO empresa (cnpj, username, nome, cidade, estado, pais, senha, email, linkedin, foto)
VALUES ('00000000000001', 'epicgames', 'Epic Games', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'epicgames@epicgames.com', 'https://linkedin.com/in/epicgames', null),
('00000000000002', 'ibmbrasil', 'IBM', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'ibmbrasil@ibm.com', 'https://linkedin.com/in/ibmbrasil', null),
('00000000000003', 'samsung', 'Samsung', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'samsung@samsung.com', 'www.linkedin/in/samsung', null),
('00000000000004', 'amazon', 'Amazon', 'Curitiba', 'Parana', 'Brasil', 'Senha123', 'amazon@amazon.com', 'www.linkedin/in/amazon', null),
('00000000000005', 'cisco', 'Cisco', 'São Paulo', 'PR', 'Brasil', 'Senha123', 'cisco@cisco.com.com', 'www.linkedin/in/cisco', null);


## tag
INSERT INTO tag (nome)
VALUES ('Desenvolvimento'), ('Design'), ('Infraestrutura'), ('Games');


## evento
INSERT INTO evento (id, data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)
VALUES (1, '2020-05-29 15:30:00', 'Av. Brigadeiro Faria Lima, 100', 'Evento voltato para gamers', 120, 100, 'João Silva', 'Mega campeonato de COD','00000000000001'),
(2, '2020-02-03 10:00:00', 'Av. Angelica, 100', 'Evento voltado para a área de segurança da informação', 150, 350, 'Antonio Gonçalves', 'Segurança de TI','00000000000002'),
(3, '2020-09-14 12:00:00', 'Rua São Paulo, 100', 'Evento voltado para desenvolvimento mobile', 180, 200, 'Marina Silva', 'Desenvolvimento Mobile','00000000000003');


## tag_evento
INSERT INTO tag_evento(id, fk_tag_id, fk_evento_id)
VALUES (1, 1, 1), (2, 2, 2), (3, 3, 3);


## tag_usuario
INSERT INTO tag_usuario (fk_tag_id, fk_usuario_cpf)
VALUES (1, '00000000001'), (2, '00000000002');


## AREA DE TESTES
SELECT* FROM usuario;
SELECT* FROM empresa;
SELECT* FROM evento;
SELECT* FROM inscricao;
SELECT* FROM tag;
SELECT* FROM tag_evento;
SELECT* FROM tag_usuario;

SELECT id FROM inscricao WHERE fk_usuario_cpf= 0000000005;
select t.* , if(te.fk_evento_id=7, true, false) as checado
from tag t left outer join tag_evento te
on  t.id = te.fk_tag_id;

select t.* ,
(select 1
from tag_evento t1
where t1.fk_evento_id = 5
and t1.fk_tag_id = t.id) as checked
from tag t;

select t.* ,
(select 1 from tag_usuario t1
where t1.fk_usuario_cpf = 0000000005
and t1.fk_tag_id = t.id) as checked
from tag t;

select fk_evento_id from tag_evento where fk_tag_id = 2;
select evento.* from evento where evento.id in (select fk_evento_id from tag_evento where fk_tag_id = 2);

select evento.* from evento where evento.id in (select fk_evento_id from tag_evento where fk_tag_id 
in (select fk_tag_id from tag_usuario where fk_usuario_cpf = 0000000001));
