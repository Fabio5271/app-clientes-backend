CREATE TABLE papeis (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome_usu VARCHAR(30) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE usuarios_papeis (
    usuario_id BIGINT REFERENCES usuarios(id),
    papel_id BIGINT REFERENCES papeis(id),
    PRIMARY KEY (usuario_id, papel_id)
);