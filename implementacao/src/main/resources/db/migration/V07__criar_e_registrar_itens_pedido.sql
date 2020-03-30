CREATE TABLE itens_pedido (
        id INT(11) NOT NULL AUTO_INCREMENT,
        quantidade INT (11) NOT NULL,
        status_item VARCHAR (20) NOT NULL,
        valor_unitario_item DECIMAL (19,2) NOT NULL,
        pedido_estoque_id INT,
        produto_id INT,
        FOREIGN KEY(pedido_estoque_id) REFERENCES pedido_estoque(id),
        FOREIGN KEY(produto_id) REFERENCES produto(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;