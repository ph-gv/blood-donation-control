# 🩸 Blood Donation Control

Sistema desktop de gerenciamento de doadores de sangue, desenvolvido em Java com interface Swing e banco de dados SQLite.

> Projeto acadêmico da Universidade São Judas Tadeu — Unidade Curricular: Projetos e Processos de TI (2026.1)  
> Alinhado ao **ODS 3 – Saúde e Bem-Estar** da ONU.

---

## Funcionalidades

- **Cadastro de doador** com validação de CPF e criptografia de senha (BCrypt)
- **Login / Logout** com autenticação segura e validação de entradas
- **Agendamento de doação** com verificação de disponibilidade de horário
- **Reagendamento** — alteração de data, horário e hemocentro
- **Cancelamento de agendamentos**
- **Geração de comprovante em PDF** com dados do doador, agendamento e hemocentro
- **Edição de perfil** (senha)
- **Empacotamento para distribuição** (`.jar` e `.bat`)

---

## Tecnologias

| Camada            | Tecnologia             |
|-------------------|------------------------|
| Linguagem         | Java 23                |
| Interface gráfica | Java Swing             |
| Banco de dados    | SQLite (arquivo único) |
| Criptografia      | jBCrypt 0.3m           |
| Versionamento     | Git / GitHub           |
| Build             | Maven                  |
| IDE               | NetBeans               |

> **Nota:** o projeto foi migrado de MySQL para SQLite na Sprint 1, eliminando a necessidade de um servidor de banco de dados externo.

---

## Estrutura do Projeto
src/main/java/com/mycompany/projeto/ods/
├── Main.java
├── dao/
│   ├── DoadorDAO.java
│   ├── HemocentroDAO.java
│   └── DoacaoDAO.java
├── model/
│   ├── Doador.java
│   ├── Hemocentro.java
│   └── Doacao.java
├── util/
│   └── ConexaoBD.java
└── view/
├── LoginScreen.java
├── CadastroScreen.java
├── MenuPrincipal.java
├── DoacaoScreen.java
├── MinhasDoacoesScreen.java
└── EditarPerfilScreen.java

---

## Pré-requisitos

- Java JDK 23+
- Maven 3.8+

> O banco de dados SQLite (`sangue.db`) é criado automaticamente na primeira execução — nenhuma instalação adicional necessária.

---

## Instalação e Execução

**1. Clone o repositório**

```bash
git clone https://github.com/ph-gv/blood-donation-control.git
cd blood-donation-control
```

**2. Compile**

```bash
mvn clean install
```

**3. Execute**

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.projeto.ods.Main"
```

Ou use o executável gerado em `target/` (`.jar` / `.bat`).

---

## Arquitetura

O projeto segue o padrão **MVC**:

- **Model** — entidades `Doador`, `Hemocentro` e `Doacao`
- **View** — telas Swing em `view/`
- **DAO** — acesso ao banco em `dao/`, usando `PreparedStatement` e `try-with-resources`

Práticas de segurança aplicadas:

- Senhas armazenadas como hash BCrypt
- Queries parametrizadas (prevenção de SQL Injection)
- Operações de banco em threads separadas para não bloquear a UI
- Validação de entradas em todas as telas

---

## Histórico de Sprints

| Sprint | Entrega |
|--------|---------|
| 1 | Migração de MySQL para SQLite; revisão de front-end |
| 2 | Tratamento de exceções, segurança de dados, padronização visual das telas principais |
| 3 | Funcionalidade de reagendamento com calendário e confirmação por ação |
| 4 | Geração de comprovante de agendamento em PDF |
| 5 | Consolidação, correção de bugs e empacotamento final (`.jar` / `.bat`) |

---

## Contribuindo

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b feature/minha-feature`
3. Commit suas mudanças: `git commit -m "feat: descrição"`
4. Push: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

## Autores

| Nome             | RA         |
|------------------|------------|
| Pedro Vieira     | 825153306  |
| Amanda Rodrigues | 825153198  |
| Rafael Sousa     | 825222822  |
| João Favoche     | 825155532  |

---

