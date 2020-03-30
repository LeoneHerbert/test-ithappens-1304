CREATE TABLE produto (
        id INT (11) NOT NULL AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
        codigo_de_barras VARCHAR (48) NOT NULL UNIQUE,
        descricao VARCHAR (100) NOT NULL UNIQUE,
        sequencial VARCHAR (100) NOT NULL UNIQUE,
        valor_unitario_produto DECIMAL (19,2) NOT NULL,
        PRIMARY KEY(id)
) engine=InnoDB DEFAULT CHARSET=utf8;

insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Arroz Tio Jorge", "123901283213", "Arroz Tio Jorge Branco", "AA56", 3.00);
insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Feijão Tio Jorge", "123901283221", "Feijão Tio Jorge Carioca", "AA58", 4.00);
insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Queijo Mussarela Tirolez", "12390122131832", "Queijo Mussarela Tirolez", "AA300", 5.70);
insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Detergente Ypê", "1239012831232", "Detergente Ypê Clear", "BB3430", 2.25);

insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Farinha Fazenda", "123923432413", "Farinha Branca Fazenda", "AA26", 2.50);
insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Sabão Omo", "1232132283221", "Sabão em pó Omo", "BB238", 10.00);
insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Presunto União", "12312322131832", "Presunto de Peru União", "AA310", 4.30);

insert into produto (nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values ("Álcool líquido", "123123221sd832", "Álcool 70", "BB10", 5.20);

insert into produto (id, nome, codigo_de_barras, descricao, sequencial, valor_unitario_produto)
values (7993, "Suco de Uva Catafesta", "1239012834232", "Suco de Uva Catafesta com cristais de uva", "AA4430", 11.50);

