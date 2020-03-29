CREATE TABLE item (
        id INT (11) NOT NULL AUTO_INCREMENT,
        quantidade INT (11) NOT NULL,
        status_item VARCHAR (255) NOT NULL,
        valor_unitario DECIMAL (19,2) NOT NULL,
        estoque_id INT UNIQUE,
        itens_pedido_id INT UNIQUE,
        produto_id INT UNIQUE,
        FOREIGN KEY(estoque_id) REFERENCES estoque(id),
        FOREIGN KEY(itens_pedido_id) REFERENCES itens_pedido(id),
        FOREIGN KEY(produto_id) REFERENCES produto(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;