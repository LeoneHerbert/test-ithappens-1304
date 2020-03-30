CREATE TABLE endereco (
  id int(11) NOT NULL AUTO_INCREMENT,
  cep varchar(8) DEFAULT NULL,
  cidade varchar(70) DEFAULT NULL,
  complemento varchar(100) DEFAULT NULL,
  logradouro varchar(100) DEFAULT NULL,
  numero varchar(10) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL,
  filial_id int(11) NOT NULL,
  FOREIGN KEY(filial_id) REFERENCES filial(id),
  PRIMARY KEY (id, filial_id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into endereco(filial_id, cep, cidade, complemento, logradouro, numero, uf) values (1, "65074115", "São Luís", "Cohama", "Av. Daniel de la Touche","73A", "MA");
insert into endereco(filial_id, cep, cidade, complemento, logradouro, numero, uf) values (60, "65053550", "São José de Ribamar", "Cohatrac I", "Av. Contorno Sul, Quadra 6","23", "MA");