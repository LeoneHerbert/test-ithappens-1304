use controle_de_estoque;
select * from filial;
select * from endereco;
select * from produto;
select * from estoque;
select * from cliente;
select* from usuario;
select * from pedido_estoque;
select * from itens_pedido;

/* Consulta 1*/

select produto_id, p.nome 
	from estoque e 
		inner join produto p on e.produto_id = p.id 
where quantidade_produtos >= 100;

/* Consulta 2*/

select e.filial_id, p.nome, e.quantidade_produtos from produto p inner join estoque e on p.id = e.produto_id
where e.filial_id = 60;

/* Consulta 3*/

select * 
	from pedido_estoque p_estoque 
		inner join itens_pedido itens_p on p_estoque.id = itens_p.pedido_estoque_id 
where produto_id = 7993;

/* Consulta 4*/

select id, forma_de_pagamento from pedido_estoque order by forma_de_pagamento asc;

/* Não consegui compreender Consulta 5: Escrever um consulta para sumarizar e bater os valores da capa do pedido com os valores dos itens do pedido*/

/* Consulta 6*/

select p_estoque.id, itens_p.id, SUM(quantidade) AS quantidadeTotal
	from pedido_estoque p_estoque 
		inner join itens_pedido itens_p on p_estoque.id = itens_p.pedido_estoque_id 
group by pedido_estoque_id
having (quantidadeTotal > 10);
