CREATE TABLE estoque (
  quantidade_produtos INT NOT NULL,
  filial_id INT NOT NULL,
  produto_id INT NOT NULL,

  PRIMARY KEY (filial_id, produto_id),

  CONSTRAINT fkEstoque_filialId FOREIGN KEY (filial_id)
    REFERENCES filial(id),
  CONSTRAINT fkEstoque_produtoId FOREIGN KEY (produto_id)
    REFERENCES produto(id)

)engine=InnoDB DEFAULT CHARSET=utf8;