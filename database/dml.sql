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
VALUES (1, '2020-07-05 15:30:00', 'Av. Brigadeiro Faria Lima, 100', 'Evento voltato para gamers', 120, 100, 'João Silva', 'Mega campeonato de COD','00000000000001'),
(2, '2020-08-05 10:00:00', 'Av. Angelica, 100', 'As organizações reconhecem que são os dados que alimentam a transformação digital, por isso estão procurando novas maneiras de utilizar todo o valor de seus dados e acelerar sua jornada para a IA. Nesta sessão, descubra com Marcelo Braga e Guilherme Brasil, os quatro passos para avançar com Inteligência Artificial e conheça o caso real da Softplan, que transformou a tecnologia para o setor da construção civil com a ajuda do IBM Watson.', 150, 350, 'Antonio Gonçalves', 'AI em quatro passos','00000000000002'),
(3, '2020-08-09 11:00:00', 'Av. Angelica, 100', 'Quem é o real agente da transformação digital e de que modo isso é realizado? Na Jornada para Cloud, mais do que mover e modernizar sistemas, é fundamental implementar uma nova cultura na forma de trabalho das pessoas. Nesta palestra - Rodolfo Linhares, Cloud Services Leader da IBM - apresenta como ferramentas e metodologias como Design Thinking, Agile e DevOps são essencias para nortear um novo e integrado modo de trabalho - promovendo um reskilling dos profissionais de TI.', 150, 350, 'Antonio Gonçalves', 'As rotas são múltiplas mas o caminho é cloud','00000000000002'),
(4, '2020-09-10 11:00:00', 'Av. Angelica, 100', 'Cloud é o grande viabilizador e acelerador da transformação digital que vem ocorrendo no mercado. Entretanto, estudos apontam que 80% dos workloads das empresas ainda não foi para a nuvem. Nesta palestra - David Farrell, General Manager de IBM Cloud - apresenta os inibidores para levar aplicações mais críticas para a nuvem, quais são os principais casos de uso em empresas que já adotaram a nuvem e os princípios que definem nossa abordagem para Cloud: Híbrida, Multicloud, Aberta, Segura e Gerenciável', 150, 350, 'David Farrell,', 'O futuro é open','00000000000002'),
(5, '2020-10-15 10:00:00', 'Av. Angelica, 100', 'Nessa palestra Martha Gabriel conta um pouco como a Inteligência Artificial será nos próximo anos. Confira também as palestras das trilhas que tivemos durante o Think Summit Brasil 2019', 150, 350, 'Martha Gabriel', 'IA Insights sobre onde estamos e para onde vamos','00000000000002'),
(10, '2020-08-01 11:00:00', 'Av. Angelica, 100', 'Evento voltado para a área de segurança da informação', 150, 350, 'Antonio Gonçalves', 'Segurança de TI','00000000000002'),
(11, '2020-09-14 12:00:00', 'Rua São Paulo, 100', 'Evento voltado para desenvolvimento mobile', 180, 200, 'Marina Silva', 'Desenvolvimento Mobile','00000000000003');


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
in (select fk_tag_id from tag_usuario where fk_usuario_cpf = 0000000005));
