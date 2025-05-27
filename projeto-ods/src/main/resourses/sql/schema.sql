-- Remove o banco de dados se existir (cuidado em ambientes de produção!)
DROP DATABASE IF EXISTS sangue;

-- Cria o banco de dados
CREATE DATABASE sangue;

-- Seleciona o banco
USE sangue;

-- Remove tabelas se já existirem (ordem correta por dependências)
DROP TABLE IF EXISTS doacoes;
DROP TABLE IF EXISTS doadores;
DROP TABLE IF EXISTS locais_coleta;

-- Criação da tabela 'doadores'
CREATE TABLE doadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL, -- Adicionei UNIQUE para evitar CPFs duplicados
    tipo_sanguineo VARCHAR(3) NOT NULL,
    data_nascimento DATE NOT NULL,
    senha VARCHAR(255) NOT NULL -- Aumentei para 255 (hash BCrypt)
);

-- Criação da tabela 'locais_coleta'
CREATE TABLE locais_coleta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    endereco VARCHAR(250) NOT NULL,
    capacidade_diaria INT NOT NULL
);

-- Criação da tabela 'doacoes'
CREATE TABLE doacoes (
    id_doacao INT AUTO_INCREMENT PRIMARY KEY,
    id_doador INT NOT NULL,
    id_local_coleta INT NOT NULL,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    status ENUM('agendado', 'realizado', 'cancelado') DEFAULT 'agendado',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_doador) REFERENCES doadores(id),
    FOREIGN KEY (id_local_coleta) REFERENCES locais_coleta(id)
);
