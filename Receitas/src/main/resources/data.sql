DROP DATABASE IF EXISTS minhasreceitas;

CREATE DATABASE minhasreceitas;

CREATE TABLE categoria (
    id INTEGER,
    descricao VARCHAR(50),
    CONSTRAINT pk_categoria PRIMARY KEY (id)
);

CREATE TABLE unidade (
    sigla VARCHAR(3),
    descricao VARCHAR(20),
    CONSTRAINT pk_unidade PRIMARY KEY (sigla)
);

CREATE TABLE produto (
    id INTEGER,
    descricao VARCHAR(100),
    CONSTRAINT pk_produto PRIMARY KEY (id)
);

CREATE TABLE usuario (
    id INTEGER,
    senha VARCHAR(255),
    email VARCHAR(100),
    nome VARCHAR(20),
    sobrenome VARCHAR(20),
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    data_exclusao TIMESTAMP,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE receita (
    id INTEGER,
    titulo VARCHAR(100),
    descricao VARCHAR(255),
    tempo_preparo INTEGER,
    porcao INTEGER,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    data_exclusao TIMESTAMP,
    id_usuario INTEGER,
    id_categoria INTEGER,
    CONSTRAINT pk_receita PRIMARY KEY (id),
    CONSTRAINT fk_receita_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT fk_receita_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);

CREATE TABLE ingrediente (
    id INTEGER,
    quantidade NUMERIC(11,2),
    sigla_unidade VARCHAR(3),
    id_produto INTEGER,
    CONSTRAINT pk_ingrediente PRIMARY KEY (id),
    CONSTRAINT fk_ingrediente_produto FOREIGN KEY (id_produto) REFERENCES produto(id),
    CONSTRAINT fk_ingrediente_unidade FOREIGN KEY (sigla_unidade) REFERENCES unidade(sigla)
);

CREATE TABLE avaliacao_receita (
    id_receita INTEGER,
    id_usuario INTEGER,
    score INTEGER,
    CONSTRAINT pk_avaliacao_receita PRIMARY KEY (id_usuario, id_receita),
    CONSTRAINT fk_avaliacao_receita_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_avaliacao_receita_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE comentario (
    id INTEGER,
    titulo VARCHAR(100),
    comentario VARCHAR(255),
    id_receita INTEGER,
    id_usuario INTEGER,
    data_inclucao TIMESTAMP,
    data_exclusao TIMESTAMP,
    CONSTRAINT pk_comentario PRIMARY KEY (id),
    CONSTRAINT fk_comentario_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_comentario_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE modo_preparo (
    ordem INTEGER,
    id_receita INTEGER,
    descricao VARCHAR(255),
    CONSTRAINT pk_modo_preparo PRIMARY KEY (id_receita, ordem),
    CONSTRAINT fk_modo_preparo_receita FOREIGN KEY (id_receita) REFERENCES receita(id)
);

CREATE TABLE receitas_favoritas (
    id_receita INTEGER,
    id_usuario INTEGER,
    CONSTRAINT pk_receitas_favoritas PRIMARY KEY (id_usuario, id_receita),
    CONSTRAINT fk_receitas_favoritas_receita FOREIGN KEY (id_receita) REFERENCES receita(id),
    CONSTRAINT fk_receitas_favoritas_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
