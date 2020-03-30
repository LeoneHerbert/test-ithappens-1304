CREATE TABLE pedido_estoque (
        id int(11) NOT NULL AUTO_INCREMENT,
        forma_de_pagamento ENUM ('AVISTA','BOLETO','CARTAO') NOT NULL,
        observacao_entrega varchar(100) NOT NULL,
        tipo_do_pedido ENUM ('SAIDA','ENTRADA')  NOT NULL,
        filial_id INT,
        cliente_id INT,
        usuario_id INT,
        FOREIGN KEY(filial_id) REFERENCES filial(id),
        FOREIGN KEY(cliente_id) REFERENCES cliente(id),
        FOREIGN KEY(usuario_id) REFERENCES usuario(id),
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into pedido_estoque (forma_de_pagamento, observacao_entrega, tipo_do_pedido, cliente_id, filial_id, usuario_id)
values ("AVISTA", "Entregar de 14h em diante", "SAIDA", 1, 1, 1);

insert into pedido_estoque (forma_de_pagamento, observacao_entrega, tipo_do_pedido, cliente_id, filial_id, usuario_id)
values ("CARTAO", "Entregar a partir de 9h da manhã", "SAIDA", 1, 1, 1);

insert into pedido_estoque (forma_de_pagamento, observacao_entrega, tipo_do_pedido, cliente_id, filial_id, usuario_id)
values ("AVISTA", "Entregar a partir de 10h da manhã", "SAIDA", 1, 1, 1);

insert into pedido_estoque (forma_de_pagamento, observacao_entrega, tipo_do_pedido, cliente_id, filial_id, usuario_id)
values ("BOLETO", "Entregar a partir de 11h da manhã", "SAIDA", 1, 1, 1);

insert into pedido_estoque (forma_de_pagamento, observacao_entrega, tipo_do_pedido, cliente_id, filial_id, usuario_id)
values ("AVISTA", "Entregar de 13h em diante", "SAIDA", 1, 1, 1);