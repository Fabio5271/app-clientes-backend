CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    uf VARCHAR(50) NOT NULL,
    compl_endrc VARCHAR(150)
);

CREATE TABLE email (
    id BIGSERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL REFERENCES clientes(id),
    endereco VARCHAR(100) NOT NULL
);

CREATE TABLE telefone (
    id BIGSERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL REFERENCES clientes(id),
    numero VARCHAR(11) NOT NULL,
    tipo VARCHAR(30) NOT NULL
);