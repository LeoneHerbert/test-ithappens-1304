CREATE TABLE produto (
        id INT (11) NOT NULL AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        codigo_de_barras INT (255) NOT NULL UNIQUE,
        descricao VARCHAR (255) NOT NULL UNIQUE,
        sequencial VARCHAR (255) NOT NULL UNIQUE,
        quantidade INT (11) NOT NULL,
        status_item VARCHAR (255) NOT NULL,
        valor_unitario DECIMAL (19,2) NOT NULL,
        estoque_id INT,
        itens_pedido_id INT,
        FOREIGN KEY(estoque_id) REFERENCES estoque(id),
        FOREIGN KEY(itens_pedido_id) REFERENCES itens_pedido(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;