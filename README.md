# Sistema de Atendimento a Solicitações de Reparos de Falta de Energia

## Universidade Federal Fluminense
### Instituto de Computação - Departamento de Ciência da Computação
#### Disciplina: Desenvolvimento Web Avançado

Este é um sistema para gerenciamento de solicitações de reparos de falta de energia, desenvolvido para a disciplina de Desenvolvimento Web Avançado. O sistema foi implementado utilizando o framework **Spring Boot** com **JPA** e **Swagger** para documentação da API.

## Descrição do Projeto

O sistema simula o atendimento a solicitações de reparos de falta de energia elétrica, com foco em uma distribuidora de energia que gerencia ordens de serviço (OS) relacionadas a clientes regulares e vitais, terceirizadas responsáveis pelo atendimento e equipes alocadas para os reparos.

O sistema possui os seguintes componentes principais:

- **Clientes**: Regulares e Vitais.
- **Ordens de Serviço**: Gerenciamento de solicitações de reparo.
- **Equipes**: Responsáveis por atender as ordens de serviço.
- **Terceirizadas**: Empresas contratadas para realizar os atendimentos.

## Funcionalidades

### 1. **Cadastro de Clientes**
   - **Cliente Regular**: Cadastro de clientes comuns.
   - **Cliente Vital**: Cadastro de clientes vitais com tempo máximo sem energia e código de prioridade.

### 2. **Ordens de Serviço**
   - Abertura de ordens de serviço relacionadas a um ou mais clientes.
   - Visualização de ordens de serviço abertas e encerradas.
   - Filtro de ordens de serviço por prioridade (Alta, Média, Baixa).

### 3. **Gestão de Equipes**
   - Cadastro de equipes.
   - Relacionamento das equipes com as terceirizadas.
   - Consulta por terceirizada e número mínimo de funcionários.

### 4. **Gestão de Terceirizadas**
   - Cadastro de empresas terceirizadas.
   - Filtros por cidade e número de atendimentos realizados.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal utilizado para desenvolver a API RESTful.
- **JPA (Java Persistence API)**: Para modelagem e interação com o banco de dados.
- **Swagger**: Para documentar e testar a API de forma interativa.
- **H2 Database**: Banco de dados em memória utilizado para testes locais.

## Estrutura de Classes

As principais classes do sistema são:

- **Cliente**: Classe abstrata com campos comuns para todos os tipos de clientes.
  - **ClienteRegular**: Representa um cliente comum, com tempo máximo sem energia e código de prioridade.
  - **ClienteVital**: Representa um cliente vital, com tempo máximo sem energia e código de prioridade.

- **OrdemServico**: Classe que representa as ordens de serviço abertas para reparo de falta de energia, associando clientes a uma ordem.

- **Equipe**: Equipes responsáveis pelo atendimento das ordens de serviço, vinculadas a terceirizadas.

- **Terceirizada**: Empresas contratadas pela distribuidora para realizar o atendimento, com um número de atendimentos realizados.

## Endpoints da API

A API está documentada com o Swagger e os seguintes endpoints estão disponíveis:

### Clientes
- **POST /clientes**: Cadastrar cliente regular.
- **POST /clientes/vital**: Cadastrar cliente vital.
- **GET /clientes/cpf/{cpf}**: Buscar cliente por CPF.
- **GET /clientes/com-ordens**: Listar clientes com ordens de serviço.
- **GET /clientes/vital/tempo-maximo/{tempoMaximo}**: Listar clientes vitais por tempo máximo sem energia.

### Ordens de Serviço
- **POST /ordens-servico**: Criar ordem de serviço.
- **GET /ordens-servico/abertas**: Listar ordens de serviço abertas.
- **GET /ordens-servico/encerradas**: Listar ordens de serviço encerradas.
- **GET /ordens-servico/prioridade-alta**: Listar ordens de serviço de alta prioridade.
- **GET /ordens-servico/{codigo}**: Buscar ordem de serviço por código.

### Equipes
- **POST /equipes**: Cadastrar equipe.
- **GET /equipes/terceirizada/{codigo}**: Listar equipes por terceirizada.
- **GET /equipes/funcionarios/{minFuncionarios}**: Listar equipes com número mínimo de funcionários.

### Terceirizadas
- **POST /terceirizadas**: Cadastrar terceirizada.
- **GET /terceirizadas/cidade/{cidade}**: Listar terceirizadas por cidade.
- **GET /terceirizadas/min-atendimentos/{minAtendimentos}**: Listar terceirizadas com número mínimo de atendimentos.
- **GET /terceirizadas/{codigo}**: Buscar terceirizada por código.

## Execução

Para rodar o projeto localmente, siga os passos abaixo:

1. **Clone o repositório**:

   ```bash
   https://github.com/JHONHP7/sistema-energia
