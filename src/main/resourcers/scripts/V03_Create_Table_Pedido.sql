CREATE TABLE pedido (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO pedido (id, descricao) values (1, 'KIT Camiseta Tam M');
INSERT INTO pedido (id, descricao) values (2, '1x Bola Copa 2014');
INSERT INTO pedido (id, descricao) values (3, 'Cleveland Cavaliers 19/20');
