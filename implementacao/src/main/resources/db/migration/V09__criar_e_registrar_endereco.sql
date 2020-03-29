CREATE TABLE endereco (
  id int(11) NOT NULL AUTO_INCREMENT,
  cep varchar(8) DEFAULT NULL,
  cidade varchar(255) DEFAULT NULL,
  complemento varchar(255) DEFAULT NULL,
  logradouro varchar(255) DEFAULT NULL,
  numero varchar(255) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL,
  filial_id int(11) NOT NULL,
  FOREIGN KEY(filial_id) REFERENCES filial(id),
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;