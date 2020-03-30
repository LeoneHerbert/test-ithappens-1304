CREATE TABLE cliente (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(255) NOT NULL,
             cpf VARCHAR(11) NOT NULL UNIQUE,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;