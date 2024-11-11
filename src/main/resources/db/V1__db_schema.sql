-- Criação da tabela terceirizada (primeiro)
CREATE TABLE terceirizada (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    numero_atendimentos INT NOT NULL CHECK (numero_atendimentos >= 0)
);

-- Criação da tabela equipe (depois de terceirizada)
CREATE TABLE equipe (
    codigo SERIAL PRIMARY KEY,
    terceirizada_codigo INT NOT NULL,
    quantidade_funcionarios INT NOT NULL CHECK (quantidade_funcionarios > 0),
    FOREIGN KEY (terceirizada_codigo) REFERENCES terceirizada (codigo)
);

-- Criação da tabela cliente (não depende de outras tabelas)
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    endereco TEXT NOT NULL,
    tipo_cliente VARCHAR(10) NOT NULL CHECK (tipo_cliente IN ('REGULAR', 'VITAL')),
    tempo_maximo_sem_energia INT CHECK (tempo_maximo_sem_energia >= 1),
    codigo_prioridade INT CHECK (codigo_prioridade BETWEEN 1 AND 3)
);

-- Inserir um índice para busca rápida pelo CPF
CREATE INDEX idx_cliente_cpf ON cliente (cpf);

-- Criação da tabela ordem_servico (depois de equipe)
CREATE TABLE ordem_servico (
    codigo SERIAL PRIMARY KEY,
    data_hora_abertura TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_hora_encerramento TIMESTAMP,
    codigo_prioridade INT CHECK (codigo_prioridade BETWEEN 1 AND 3),
    equipe_codigo INT NOT NULL,
    FOREIGN KEY (equipe_codigo) REFERENCES equipe (codigo)
);

-- Tabela de associação entre cliente e ordem de serviço
CREATE TABLE ordem_cliente (
    ordem_id INT NOT NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (ordem_id, cliente_id),
    FOREIGN KEY (ordem_id) REFERENCES ordem_servico (codigo),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);
