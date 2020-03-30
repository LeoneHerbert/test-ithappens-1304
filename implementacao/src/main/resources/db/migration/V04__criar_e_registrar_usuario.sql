CREATE TABLE usuario (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(255) NOT NULL,
             cpf VARCHAR(11) NOT NULL UNIQUE,
             login varchar(255) NOT NULL UNIQUE,
             senha varchar(255) NOT NULL,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;