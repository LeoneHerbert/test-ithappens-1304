CREATE TABLE estoque (
        id INT NOT NULL AUTO_INCREMENT,
        filial_id INT UNIQUE,
        PRIMARY KEY(id),
        FOREIGN KEY(filial_id) REFERENCES filial(id)
) engine=InnoDB DEFAULT CHARSET=utf8;