CREATE TABLE usuario (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(100) NOT NULL,
             cpf VARCHAR(11) NOT NULL UNIQUE,
             login varchar(100) NOT NULL UNIQUE,
             senha varchar(50) NOT NULL,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into usuario (nome, cpf, login, senha) values ("João","07969024324", "joaoadm", "adminadmin");