## usuario
INSERT INTO usuario (cpf, username, nome, email, senha, linkedin, foto)
VALUES ('00000000001', 'teste', 'Teste Usuário', 'teste@hde.com', 'Senha123', 'https://linkedin.com/in/teste', null),
('00000000002', 'usuario1', 'Usuario1', 'usuario1@hde.com', 'Senha123', 'https://linkedin.com/in/usuario1', null),
('00000000003', 'joaosilva', 'Joao da Silva', 'joao@hde.com', 'Senha123', 'www.linkedin/joao', null),
('00000000004', 'mariasantos', 'Maria dos Santos', 'maria@hde.com', 'Senha123', 'www.linkedin/maria', null),
('00000000005', 'pedroalves', 'Pedro Alves', 'pedro@hde.com', 'Senha123', 'www.linkedin/pedro', null);


## empresa
INSERT INTO empresa (cnpj, username, nome, cidade, estado, pais, senha, email, linkedin, foto)
VALUES ('00000000000001', 'teste', 'Teste Empresa', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'teste@hde.com', 'https://linkedin.com/in/teste', null),
('00000000000002', 'empresa1', 'Empresa1', 'São Paulo', 'SP', 'Brasil', 'Senha123', 'empresa1@hde.com', 'https://linkedin.com/in/empresa1', null),
('00000000000003', 'mbi', 'mbi', 'sao paulo', 'sao paulo', 'brasil', 'Senha123', 'mbi@empresa.com', 'www.linkedin/mbi', null),
('00000000000004', 'io', 'io', 'curitiba', 'parana', 'brasil', 'Senha123', 'io@empresa.com', 'www.linkedin/io', null),
('00000000000005', 'xilften', 'xilften', 'detroit', 'michigan', 'eua', 'Senha123', 'xilften@empresa.com', 'www.linkedin/xilften', null);


## tag
INSERT INTO tag (id, nome)
VALUES (1, 'tag1'), (2, 'tag2'), (3, 'tag3'), (4, 'tag4'), (5, 'tag5');


## evento
INSERT INTO evento (id, data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)
VALUES (1, '2020-05-29 15:30:00', 'Rua Davi Gamer Br, 100', 'Evento voltato para gamers de todas as idades', '02:30:00', '100', 'Hayash', 'Mega campeonato de COD','00000000000001'),
(1, '2020-02-03 10:00:00', 'rua goias, 100', 'Evento Super Bacana', '01:30:00', '350', 'joao silva', 'evento bacana','00000000000002'),
(1, '2020-09-14 12:00:00', 'rua sao paulo, 100', 'Super Evento 2.0 do Evento Super Bacana', '02:00:00', '54', 'marina silva', 'evento 2.0','00000000000003');


## tag_evento
INSERT INTO tag_evento(id, fk_tag_id, fk_evento_id)
VALUES (1, 1, 1), (2, 2, 2), (3, 3, 3);


## tag_usuario
INSERT INTO tag_usuario (fk_tag_id, fk_usuario_cpf)
VALUES (1, '00000000001'), (2, '00000000002');


## AREA DE TESTES
-- SELECT* FROM usuario;
-- SELECT* FROM empresa;
-- SELECT* FROM evento;