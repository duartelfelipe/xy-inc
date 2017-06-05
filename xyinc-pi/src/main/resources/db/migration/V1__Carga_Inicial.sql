--criacao de tabela para armazenar pontos de interesse
CREATE TABLE ponto_interesse(
    pi_codigo integer NOT NULL AUTO_INCREMENT,
    pi_nome varchar(50) NOT NULL,
    pi_coord_x integer NOT NULL,
    pi_coord_y integer NOT NULL,
	CONSTRAINT pk_ponto_interese PRIMARY KEY (pi_codigo)
);

--carga inicial da tabela 'ponto_interesse'
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Lanchonete', 27, 12);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Posto', 31, 18);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Joalheria', 15, 12);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Floricultura', 19, 21);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Pub', 12, 8);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Supermercado', 23, 6);
--INSERT INTO ponto_interesse (pi_nome, pi_coord_x, pi_coord_y) VALUES('Churrascaria', 28, 2);