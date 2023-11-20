CREATE TABLE Cliente (
    id serial PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    CEP CHAR(9),
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(20),
    bairro VARCHAR(60),
    municipio VARCHAR(60),
    UF CHAR(2),
    data_de_cadastro TIMESTAMPTZ NOT NULL,
    ativo BOOLEAN NOT NULL
);
CREATE TABLE Pedido (
    id serial PRIMARY KEY,
    cliente INTEGER REFERENCES Cliente(id) NOT NULL,
    data_do_pedido TIMESTAMPTZ NOT NULL,
    data_da_entrega TIMESTAMPTZ NOT NULL,
    valor_total_do_pedido NUMERIC,
    situacao ENUM ('ATIVO', 'CANCELADO', 'ENTREGUE') NOT NULL
);
CREATE TABLE Produto (
    id serial PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_de_cadastro TIMESTAMPTZ NOT NULL
);
CREATE TABLE Item_de_Pedido (
    id serial PRIMARY KEY,
    pedido INTEGER REFERENCES Pedido(id) NOT NULL,
    produto INTEGER REFERENCES Produto(id) NOT NULL,
    quantidade NUMERIC NOT NULL,
    valor_unitario NUMERIC NOT NULL,
    valor_total NUMERIC NOT NULL
);
