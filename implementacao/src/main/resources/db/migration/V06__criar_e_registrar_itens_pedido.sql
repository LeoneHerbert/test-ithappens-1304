CREATE TABLE itens_pedido (
        id INT(11) NOT NULL AUTO_INCREMENT,
        pedido_estoque_id INT UNIQUE,
        FOREIGN KEY(pedido_estoque_id) REFERENCES pedido_estoque(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;