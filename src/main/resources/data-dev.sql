insert into cliente(id, ativo, bairro, cep, complemento, data_cadastro, logradouro, municipio,
nome, numero, uf)
values (nextval('hibernate_sequence'), true, 'Jaguaré', '12345678', 'ap 1', current_timestamp(), 'Rua Abc', 'São Paulo', 'AC', '999', 'SP');

insert into cliente(id, ativo, bairro, cep, complemento, data_cadastro, logradouro, municipio,
nome, numero, uf)
values (nextval('hibernate_sequence'), true, 'Jaguaré', '12345678', 'ap 1', current_timestamp(), 'Rua Abc', 'São Paulo', 'DC', '999', 'SP');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 1500.50, 'ATIVO');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 2000.90, 'ENTREGUE');

insert into pedido(id, cliente_id, data_pedido, data_entrega, valor_total, situacao)
values (nextval('hibernate_sequence'), 1, current_timestamp(), current_timestamp(), 500.00, 'CANCELADO');

insert into produto(id, ativo, nome, dataDeCadastro)
values (nextval('hibernate_sequence'), true, 'PS5', current_timestamp());

insert into produto(id, ativo, nome, dataDeCadastro)
values (nextval('hibernate_sequence'), true, 'iPhone 15', current_timestamp());

insert into produto(id, ativo, nome, dataDeCadastro)
values (nextval('hibernate_sequence'), true, 'Macbook M1', current_timestamp());
