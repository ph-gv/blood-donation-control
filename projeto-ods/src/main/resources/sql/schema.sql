-- Tabela de doadores
CREATE TABLE IF NOT EXISTS doadores (
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    nome             VARCHAR(120)  NOT NULL,
    cpf              VARCHAR(11)   NOT NULL UNIQUE,
    tipo_sanguineo   VARCHAR(3)    NOT NULL,
    data_nascimento  TEXT          NOT NULL,
    senha            VARCHAR(255)  NOT NULL
);
 
-- Tabela de locais de coleta (hemocentros)
CREATE TABLE IF NOT EXISTS locais_coleta (
    id                INTEGER PRIMARY KEY AUTOINCREMENT,
    nome              VARCHAR(200) NOT NULL,
    endereco          VARCHAR(250) NOT NULL,
    capacidade_diaria INTEGER      NOT NULL
);
 
-- Tabela de doações/agendamentos
CREATE TABLE IF NOT EXISTS doacoes (
    id_doacao       INTEGER PRIMARY KEY AUTOINCREMENT,
    id_doador       INTEGER NOT NULL,
    id_local_coleta INTEGER NOT NULL,
    data            TEXT    NOT NULL,
    horario         TEXT    NOT NULL,
    status          TEXT    NOT NULL DEFAULT 'agendado',
    created_at      TEXT    DEFAULT (datetime('now')),
    FOREIGN KEY (id_doador)       REFERENCES doadores(id),
    FOREIGN KEY (id_local_coleta) REFERENCES locais_coleta(id)
);
 
-- Hemocentros de exemplo
-- INSERT OR IGNORE garante que os dados só são inseridos se o ID ainda não existir,
-- evitando duplicações caso o banco já exista e o schema seja re-executado.
INSERT OR IGNORE INTO locais_coleta (id, nome, endereco, capacidade_diaria) VALUES
    (1, 'Hemocentro da Santa Casa', 'Rua 1', 5),
    (2, 'Hemocentro São Lucas',     'Rua 2', 3),
    (3, 'Hemocentro UNIFESP',       'Rua 3', 7);