--
-- insert into usuario (nome_completo, funcao, email, senha) values ('Joana da Silva', 'VOLUNTARIO', 'joana.silva@email.com', 'Senha@1');
-- insert into usuario (nome_completo, funcao, email, senha) values ('Carlos Mendes', 'PROFISSIONAL', 'carlos@email.com', 'Senha@2');
-- insert into usuario (nome_completo, funcao, email, senha) values ('Ana Souza', 'VOLUNTARIO', 'ana@email.com', 'Senha@3');
-- insert into usuario (nome_completo, funcao, email, senha) values ('Marcos Lima', 'ADMIN', 'marcos@email.com', 'Senha@4');
-- insert into usuario (nome_completo, funcao, email, senha) values ('João Pedro Diniz', 'PROFISSIONAL', 'jpdiniz@email.com', 'Senha@10');
--
--
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('BAIXA', 'Gripe leve', 1, '2025-05-30', 3);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('ALTA', 'Pressão arterial elevada', 5, '2025-05-30', 1);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('MEDIA', 'Dor abdominal moderada', 3, '2025-05-30', 2);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('ALTA', 'Fratura exposta', 5, '2025-05-29', 4);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('MEDIA', 'Febre e tosse', 2, '2025-05-29', 5);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('BAIXA', 'Dor de cabeça', 1, '2025-05-29', 6);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('ALTA', 'Dificuldade respiratória', 5, '2025-05-28', 7);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('MEDIA', 'Corte superficial', 2, '2025-05-28', 8);
-- INSERT INTO triagem (prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES ('BAIXA', 'Dor nas costas leve', 1, '2025-05-28', 9);
--
--
--
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Ana Souza', 30, 'F', 1);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Carlos Lima', 45, 'M', 2);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Bruno Silva', 25, 'M', 3);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Juliana Alves', 60, 'F', 4);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Igor Mendes', 33, 'M', 5);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Patrícia Costa', 52, 'F', 6);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Renato Dias', 40, 'M', 7);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Fernanda Rocha', 27, 'F', 8);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Sam Lee', 38, 'I', 9);
-- INSERT INTO Vitima (nome, idade, sexo, id_triagem) VALUES ('Alex Kim', 22, 'I', 10);
--
-- Inserts for the Usuario table
INSERT INTO Usuario (id_user, nome_completo, funcao, email, senha) VALUES (1, 'Ana Clara Silveira Souza', 'ADMIN', 'ana.souza@example.com', 'Senha@12');
INSERT INTO Usuario (id_user, nome_completo, funcao, email, senha) VALUES (2, 'Bruno Henrique Costa Lima', 'PROFISSIONAL', 'bruno.lima@example.com', 'Senha#13');

-- Inserts for the Triagem table
-- Assuming id_usuario 1 and 2 exist from the Usuario inserts
INSERT INTO Triagem (id_triagem, prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES (1, 'ALTA', 'Grave, necessita de cirurgia imediata', 1, TO_DATE('2025-06-01', 'YYYY-MM-DD'), 1);
INSERT INTO Triagem (id_triagem, prioridade, estado_saude, classificacao, data_triagem, id_usuario) VALUES (2, 'MEDIA', 'Estável, mas com fratura no braço', 2, TO_DATE('2025-06-02', 'YYYY-MM-DD'), 2);

-- Inserts for the Vitima table
-- Assuming id_triagem 1 and 2 exist from the Triagem inserts
INSERT INTO Vitima (id_vitima, nome, idade, sexo, id_triagem) VALUES (1, 'Carlos Eduardo Santos', 45, 'M', 1);
INSERT INTO Vitima (id_vitima, nome, idade, sexo, id_triagem) VALUES (2, 'Diana Rodrigues Pereira', 28, 'F', 2);
