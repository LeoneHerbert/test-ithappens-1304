CREATE TABLE produto (
        id INT (11) NOT NULL AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        codigo_de_barras INT (255) NOT NULL UNIQUE,
        descricao VARCHAR (255) NOT NULL UNIQUE,
        sequencial VARCHAR (255) NOT NULL UNIQUE,
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;