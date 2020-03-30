CREATE TABLE filial (
             id INT NOT NULL AUTO_INCREMENT,
             nome VARCHAR(100) NOT NULL,
             PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into filial (nome) values("Mateus Cohama");
insert into filial (id, nome) values(60, "Mateus Cohatrac");