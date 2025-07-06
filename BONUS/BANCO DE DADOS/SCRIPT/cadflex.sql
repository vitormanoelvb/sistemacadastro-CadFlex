-- Criação do banco de dados
CREATE DATABASE cadflex;
USE cadflex;

-- Tabela principal de produtos
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(20) NOT NULL, -- 'digital' ou 'fisico'
    categoria VARCHAR(50),
    observacao TEXT
);

-- Tabela para produtos físicos
CREATE TABLE produto_fisico (
    id INT PRIMARY KEY,
    peso DECIMAL(10, 2) NOT NULL,
    dimensoes VARCHAR(100),
    FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE
);

-- Tabela para produtos digitais
CREATE TABLE produto_digital (
    id INT PRIMARY KEY,
    tamanho_arquivo_mb DECIMAL(10, 2) NOT NULL,
    formato VARCHAR(50),
    FOREIGN KEY (id) REFERENCES produto(id) ON DELETE CASCADE
);

-- Tabela de usuários (login e registro)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    genero ENUM('Masculino', 'Feminino') NOT NULL
);

-- Usuario e Privilegio
CREATE USER 'vitor'@'localhost' IDENTIFIED BY 'cadflex123';
GRANT ALL PRIVILEGES ON cadflex.* TO 'vitor'@'localhost';

-- Inserts de usuários de teste
INSERT INTO usuarios (nome, email, senha, genero) VALUES
('Vitor Manoel Vidal Braz', 'vitor@cadflex.com', '1234', 'Masculino'),
('Joana Silva', 'joana@cadflex.com', 'abcd', 'Feminino');

-- Inserts de produtos
-- Produto Físico
INSERT INTO produto (nome, preco, tipo, categoria, observacao) VALUES
('Notebook Dell', 3500.00, 'fisico', 'Eletrônicos', 'Tela 15.6" - 16GB RAM');
INSERT INTO produto_fisico (id, peso, dimensoes) VALUES
(LAST_INSERT_ID(), 2.30, '38cm x 25cm x 2cm');

-- Produto Digital
INSERT INTO produto (nome, preco, tipo, categoria, observacao) VALUES
('Curso de Java', 199.90, 'digital', 'Educação', 'Curso completo com certificado');
INSERT INTO produto_digital (id, tamanho_arquivo_mb, formato) VALUES
(LAST_INSERT_ID(), 1200.00, 'MP4');

-- Produto Físico
INSERT INTO produto (nome, preco, tipo, categoria, observacao) VALUES
('Livro POO', 59.90, 'fisico', 'Livros', 'Programação Orientada a Objetos');
INSERT INTO produto_fisico (id, peso, dimensoes) VALUES
(LAST_INSERT_ID(), 0.80, '21cm x 15cm x 3cm');

-- Produto Digital
INSERT INTO produto (nome, preco, tipo, categoria, observacao) VALUES
('Template HTML Responsivo', 39.90, 'digital', 'Web', 'HTML/CSS/JS prontos para uso');
INSERT INTO produto_digital (id, tamanho_arquivo_mb, formato) VALUES
(LAST_INSERT_ID(), 15.20, 'ZIP');

SELECT id, nome FROM produto;

