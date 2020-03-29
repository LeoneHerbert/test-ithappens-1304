CREATE TABLE pedido_estoque (
        id int(11) NOT NULL AUTO_INCREMENT,
        forma_de_pagamento varchar(255) NOT NULL,
        observacao_entrega varchar(255) NOT NULL,
        tipo_do_pedido varchar(255) NOT NULL,
        filial_id INT UNIQUE,
        cliente_id INT UNIQUE,
        usuario_id INT UNIQUE,
        itens_pedido_id INT UNIQUE,
        estoque_id INT UNIQUE,
        FOREIGN KEY(filial_id) REFERENCES filial(id),
        FOREIGN KEY(cliente_id) REFERENCES cliente(id),
        FOREIGN KEY(usuario_id) REFERENCES usuario(id),
        FOREIGN KEY(itens_pedido_id) REFERENCES itens_pedido(id),
        FOREIGN KEY(estoque_id) REFERENCES estoque(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;