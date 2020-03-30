CREATE TABLE produto (
        id INT (11) NOT NULL AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
        codigo_de_barras INT (48) NOT NULL UNIQUE,
        descricao VARCHAR (100) NOT NULL UNIQUE,
        sequencial VARCHAR (100) NOT NULL UNIQUE,
        valor_unitario_produto DECIMAL (19,2) NOT NULL,
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;