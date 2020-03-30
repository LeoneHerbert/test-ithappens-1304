CREATE TABLE itens_pedido (
        id INT(11) NOT NULL AUTO_INCREMENT,
        quantidade INT (11) NOT NULL,
        status_item ENUM ('ATIVO','CANCELADO','PROCESSADO') NOT NULL,
        valor_unitario_item DECIMAL (19,2) NOT NULL,
        pedido_estoque_id INT,
        produto_id INT,
        FOREIGN KEY(pedido_estoque_id) REFERENCES pedido_estoque(id),
        FOREIGN KEY(produto_id) REFERENCES produto(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (1, 1, 4, "ATIVO", 3.00);
insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (1, 2, 3, "ATIVO", 4.00);
insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (2, 3, 10, "ATIVO", 5.70);
insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (3, 4, 12, "ATIVO", 2.25);
insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (4, 7993, 12, "ATIVO", 11.50);
insert into itens_pedido(pedido_estoque_id, produto_id, quantidade, status_item, valor_unitario_item) values (5, 6, 4, "ATIVO", 11.50);
