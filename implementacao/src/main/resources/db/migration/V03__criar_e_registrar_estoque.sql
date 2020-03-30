CREATE TABLE estoque (
  quantidade_produtos INT NOT NULL,
  filial_id INT NOT NULL,
  produto_id INT NOT NULL,

  KEY (filial_id),
  PRIMARY KEY (produto_id),

  CONSTRAINT fkEstoque_filialId FOREIGN KEY (filial_id)
    REFERENCES filial(id),
  CONSTRAINT fkEstoque_produtoId FOREIGN KEY (produto_id)
    REFERENCES produto(id)

)engine=InnoDB DEFAULT CHARSET=utf8;

insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 1, 1000);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 2, 1000);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 3, 2000);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 4, 60);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 8, 5000);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (1, 7993, 100);

insert into estoque (filial_id, produto_id, quantidade_produtos) values (60, 5, 200);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (60, 6, 3000);
insert into estoque (filial_id, produto_id, quantidade_produtos) values (60, 7, 400);