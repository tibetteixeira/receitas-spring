DROP DATABASE IF EXISTS minhasreceitas;

CREATE DATABASE minhasreceitas;

CREATE TABLE categoria (
    id INTEGER NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    CONSTRAINT pk_categoria PRIMARY KEY (id)
);

CREATE TABLE unidade (
    sigla VARCHAR(3) NOT NULL,
    descricao VARCHAR(20) NOT NULL,
    CONSTRAINT pk_unidade PRIMARY KEY (sigla)
);

CREATE TABLE produto (
    id INTEGER NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    CONSTRAINT pk_produto PRIMARY KEY (id)
);

CREATE TABLE usuario (
    id INTEGER NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    data_exclusao TIMESTAMP,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE receita (
    id INTEGER NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    tempo_preparo INTEGER NOT NULL,
    porcao INTEGER NOT NULL,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    data_exclusao TIMESTAMP,
    id_usuario INTEGER NOT NULL,
    id_categoria INTEGER,
    CONSTRAINT pk_receita PRIMARY KEY (id),
    CONSTRAINT fk_receita_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT fk_receita_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);

CREATE TABLE ingrediente (
    id INTEGER NOT NULL,
    quantidade NUMERIC(11,2) NOT NULL,
    sigla_unidade VARCHAR(3) NOT NULL,
    id_produto INTEGER NOT NULL,
    CONSTRAINT pk_ingrediente PRIMARY KEY (id),
    CONSTRAINT fk_ingrediente_produto FOREIGN KEY (id_produto) REFERENCES produto(id),
    CONSTRAINT fk_ingrediente_unidade FOREIGN KEY (sigla_unidade) REFERENCES unidade(sigla)
);

CREATE TABLE ingrediente_receita (
    id_ingrediente INTEGER NOT NULL,
    id_receita INTEGER NOT NULL,
    CONSTRAINT fk_ingrediente_receita_ingrediente FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id),
    CONSTRAINT fk_ingrediente_receita_receita FOREIGN KEY (id_receita) REFERENCES receita(id)
);

CREATE TABLE avaliacao_receita (
    id_receita INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    score INTEGER NOT NULL,
    CONSTRAINT pk_avaliacao_receita PRIMARY KEY (id_usuario, id_receita),
    CONSTRAINT fk_avaliacao_receita_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_avaliacao_receita_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE comentario (
    id INTEGER NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    comentario VARCHAR(255) NOT NULL,
    id_receita INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    data_inclucao TIMESTAMP,
    data_exclusao TIMESTAMP,
    CONSTRAINT pk_comentario PRIMARY KEY (id),
    CONSTRAINT fk_comentario_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_comentario_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE modo_preparo (
    ordem INTEGER NOT NULL,
    id_receita INTEGER NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    CONSTRAINT pk_modo_preparo PRIMARY KEY (id_receita, ordem),
    CONSTRAINT fk_modo_preparo_receita FOREIGN KEY (id_receita) REFERENCES receita(id)
);

CREATE TABLE receitas_favoritas (
    id_receita INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    CONSTRAINT fk_receitas_favoritas_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_receitas_favoritas_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
