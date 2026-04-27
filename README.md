# 📖 Sistema de Gestão de Doadores de Sangue

---

## 🩸 Visão Geral

**Sistema de Gestão de Doadores de Sangue** é uma aplicação desktop desenvolvida em Java (Swing) e MySQL, cujo objetivo é facilitar o cadastro de doadores, agendamento de doações, gerenciamento de perfis e acompanhamento de histórico. 🎯

Este projeto também se alinha com os **Objetivos de Desenvolvimento Sustentável (ODS)**, especialmente o **ODS 3: Saúde e Bem-Estar**, já que ajuda a organizar o processo de doação de sangue. 🌍❤️

---

## 📱 Funcionalidades Principais

1. **Cadastro de Doador**

   * Criptografia de senha com BCrypt 🔒
   * Validação de CPF e força de senha
   * Armazenamento seguro de dados pessoais

2. **Autenticação (Login/Logout)**

   * Tela de login com validação de CPF (11 dígitos) e senha
   * Mensagens de erro claras para usuário (CPF inválido, credenciais incorretas)

3. **Menu Principal**

   * Boas-vindas personalizadas (“Bem-vindo, {Nome}!”)
   * Botões de navegação:

     * **Agendar Doação**
     * **Meus Agendamentos**
     * **Editar Perfil**
     * **Sair**

4. **Agendamento de Doação** 🗓️

   * Seleção de hemocentro (3 opções fictícias em São Paulo)
   * Campo de data (DD/MM/AAAA) e horário (HH\:mm) com máscara de entrada
   * Verificação de disponibilidade (impede duplicidade de horário no mesmo local)
   * Armazenamento em tabela `doacoes` com status (`agendado`, `realizado`, `cancelado`)

5. **Visualização e Cancelamento de Agendamentos**

   * Lista todos os agendamentos do doador logado em uma tabela (JTable)
   * Exibe colunas:

     * ID da Doação
     * Nome do Hemocentro
     * Data (DD/MM/AAAA)
     * Horário (HH\:mm)
     * Status (enum)
   * Botão “❌ Cancelar Doação” que altera status para `cancelado` e reflete na tabela

6. **Edição de Perfil**

   * Alterar nome, tipo sanguíneo, data de nascimento e, se desejado, senha (mínimo 8 caracteres)
   * CPF permanece imutável
   * Conversão automática de data para o formato do banco (YYYY-MM-DD)

7. **Segurança e Boas Práticas**

   * Senhas armazenadas como hash BCrypt (salt + iterações)
   * Uso de PreparedStatement para prevenir SQL Injection
   * Try-with-resources para fechamento automático de conexões
   * Máscara de entrada para data e horário (JFormattedTextField + MaskFormatter)
   * Operações de banco executadas em threads separadas para não bloquear UI
   * Layout responsivo: janelas centralizadas (`setLocationRelativeTo(null)`)

---

## 🔧 Tecnologias Utilizadas

| Camada            | Ferramenta / Biblioteca                             |
| ----------------- | --------------------------------------------------- |
| Linguagem         | Java 23                                             |
| Interface Gráfica | Java Swing                                          |
| Banco de Dados    | MySQL (Workbench para modelagem)                    |
| Conexão JDBC      | MySQL Connector/J (versão 8.0.33)                   |
| Criptografia      | jBCrypt (versão 0.3m)                               |
| Mascara de Data   | `javax.swing.JFormattedTextField` + `MaskFormatter` |
| IDE               | NetBeans IDE                                        |

---

## 🗂️ Estrutura de Pacotes

```
src/main/java
└── com.mycompany.projeto.ods
    ├── Main.java                # Classe principal (inicia LoginScreen)
    ├── dao
    │   ├── DoadorDAO.java       # CRUD para tabela doadores + autenticação
    │   ├── HemocentroDAO.java   # Consulta hemocentros (listar, buscarPorNome, buscarPorId)
    │   ├── DoacaoDAO.java       # CRUD para tabela doacoes + verificarDisponibilidade
    ├── model
    │   ├── Doador.java          # Entidade Doador (id, nome, cpf, tipoSanguíneo, dataNascimento, senha)
    │   ├── Hemocentro.java      # Entidade Hemocentro (id, nome, endereco, capacidadeDiaria)
    │   └── Doacao.java          # Entidade Doacao (idDoacao, idDoador, idLocalColeta, data, horario, status)
    ├── util
    │   └── ConexaoBD.java       # Singleton para conexões JDBC com MySQL
    └── view
        ├── LoginScreen.java             # Tela de login
        ├── CadastroScreen.java          # Tela de cadastro de doador
        ├── MenuPrincipal.java           # Dashboard pós-login
        ├── DoacaoScreen.java            # Tela de agendamento
        ├── MinhasDoacoesScreen.java     # Tela de listagem/cancelamento de agendamentos
        └── EditarPerfilScreen.java      # Tela de edição de dados do doador
```

---

## 📦 Instalação e Execução

1. **Pré-requisitos**

   * Java JDK 23 ou superior
   * Maven 3.8.x
   * MySQL Server (crie o schema `sangue` antes de rodar)

2. **Clonar o repositório**

   ```bash
   git clone https://github.com/seu-usuario/sistema-doadores-sangue.git
   cd sistema-doadores-sangue
   ```

3. **Configurar Banco de Dados**

   * Abra o MySQL Workbench e execute o script abaixo para criar as tabelas:

     ```sql
     DROP DATABASE IF EXISTS sangue;
     CREATE DATABASE sangue;
     USE sangue;

     CREATE TABLE doadores (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(120) NOT NULL,
       cpf VARCHAR(11) UNIQUE NOT NULL,
       tipo_sanguineo VARCHAR(3) NOT NULL,
       data_nascimento DATE NOT NULL,
       senha VARCHAR(255) NOT NULL
     );

     CREATE TABLE locais_coleta (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(200) NOT NULL,
       endereco VARCHAR(250) NOT NULL,
       capacidade_diaria INT NOT NULL
     );

     CREATE TABLE doacoes (
       id_doacao INT AUTO_INCREMENT PRIMARY KEY,
       id_doador INT NOT NULL,
       id_local_coleta INT NOT NULL,
       data DATE NOT NULL,
       horario TIME NOT NULL,
       status ENUM('agendado','realizado','cancelado') DEFAULT 'agendado',
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (id_doador) REFERENCES doadores(id),
       FOREIGN KEY (id_local_coleta) REFERENCES locais_coleta(id)
     );
     ```

   * **Inserir hemocentros de exemplo**:

     ```sql
     INSERT INTO locais_coleta (nome, endereco, capacidade_diaria) VALUES
       ('Hemocentro Central', 'Rua Marquês de Itu, 579, Vila Buarque, São Paulo – SP', 50),
       ('Hemocentro São Lucas', 'Rua Barão de Iguape, 212, Liberdade, São Paulo – SP', 40),
       ('Hemocentro UNIFESP', 'Rua Dr. Diogo de Faria, 824, Vila Clementino, São Paulo – SP', 30);
     ```

4. **Compilar o projeto com Maven**

   ```bash
   mvn clean install
   ```

5. **Executar a aplicação**

   ```bash
   mvn exec:java -Dexec.mainClass="com.mycompany.projeto.ods.Main"
   ```

   > A janela de Login abrirá, e a partir daí você poderá navegar pelas demais telas.

---

## 📖 Estrutura do Banco de Dados

### Tabela: `doadores`

| Coluna            | Tipo         | Descrição                                 |
| ----------------- | ------------ | ----------------------------------------- |
| `id`              | INT PK AI    | Identificador único de cada doador        |
| `nome`            | VARCHAR(120) | Nome completo do doador                   |
| `cpf`             | VARCHAR(11)  | CPF (11 dígitos, sem formatação) – UNIQUE |
| `tipo_sanguineo`  | VARCHAR(3)   | Ex.: A+, O–, AB+                          |
| `data_nascimento` | DATE         | Data no formato YYYY-MM-DD                |
| `senha`           | VARCHAR(255) | Hash BCrypt da senha                      |

---

### Tabela: `locais_coleta`

| Coluna              | Tipo         | Descrição                            |
| ------------------- | ------------ | ------------------------------------ |
| `id`                | INT PK AI    | Identificador único do hemocentro    |
| `nome`              | VARCHAR(200) | Nome do hemocentro                   |
| `endereco`          | VARCHAR(250) | Endereço completo                    |
| `capacidade_diaria` | INT          | Quantidade máxima de doações por dia |

---

### Tabela: `doacoes`

| Coluna            | Tipo                        | Descrição                                                     |
| ----------------- | --------------------------- | ------------------------------------------------------------- |
| `id_doacao`       | INT PK AI                   | Identificador único do agendamento                            |
| `id_doador`       | INT FK → doadores(id)       | Chave estrangeira para o doador                               |
| `id_local_coleta` | INT FK → locais\_coleta(id) | Chave estrangeira para o hemocentro                           |
| `data`            | DATE                        | Data da doação (YYYY-MM-DD)                                   |
| `horario`         | TIME                        | Horário da doação (HH\:mm\:ss)                                |
| `status`          | ENUM                        | ‘agendado’, ‘realizado’, ‘cancelado’ (padrão: ‘agendado’)     |
| `created_at`      | TIMESTAMP                   | Data/Hora de criação do registro (padrão: CURRENT\_TIMESTAMP) |

---

## 📐 Arquitetura e Padrões

1. **MVC (Model-View-Controller)**

   * **Model**: Classes em `com.mycompany.projeto.ods.model` (Doador, Hemocentro, Doacao).
   * **View**: Classes em `com.mycompany.projeto.ods.view` (telas Swing).
   * **Controller/DAO**: Classes em `com.mycompany.projeto.ods.dao` (DoadorDAO, HemocentroDAO, DoacaoDAO).

2. **Segurança**

   * Senhas criptografadas com BCrypt (`org.mindrot.jbcrypt.BCrypt`) antes de salvar no BD.
   * Uso de `PreparedStatement` para evitar SQL injection.
   * Máscaras de input em data/horário para evitar formatação inválida.

3. **Threads para operações de BD**

   * No login, a autenticação ocorre dentro de `new Thread(...)` para não travar a UI.
   * Boa prática mantida: UI responsiva, sem congelamento durante consultas.

4. **Boas Práticas de UI**

   * Todas as janelas usam `setLocationRelativeTo(null)` para **centralizar** na tela do usuário.
   * Uso de `JFormattedTextField` + `MaskFormatter` para garantir somente números em data/horário.
   * Botões estilizados com cores (`setBackground`, `setForeground`, `setFont`, `setOpaque(true)`).

---

## 👥 Time e Contribuidores

* **Colaboradores**:
  * Nome: *Pedro Vieira*
  * E-mail: *[pedro.vieira02006@gmail.com](mailto:pedro.vieira02006@gmail.com)*

  * Nome: *Nicholas Saraiva*
  * E-mail: *[nicholas.saraivam@gmail.com](mailto:nicholas.saraivam@gmail.com)*

  * Nome: *Augusto Souza*
  * E-mail: *[augustorock2003@gmail.com](mailto:augustorock2003@gmail.com)*

  * Nome: *Miguel Carvalho*
  * E-mail: *[miguelcarvalhodossantos17@gmail.com](mailto:miguelcarvalhodossantos17@gmail.com)*

  * Nome: *Gabriel Afonso*
  * E-mail: *[afonsogabriel546@gmail.com](mailto:afonsogabriel546@gmail.com)*

  * Nome: *Raul Lopes*
  * E-mail: *[lopesnunesdasilvar@gmail.com](mailto:lopesnunesdasilvar@gmail.com)*

**Como contribuir**

1. Faça um fork deste repositório.
2. Crie sua branch para a feature ou correção (`git checkout -b feature/nome-da-feature`).
3. Faça commit das alterações (`git commit -m "Descrição da mudança"`).
4. Envie para o branch original (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**.
Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🤝 Sobre a Ligação com os ODS

🌟 Este sistema contribui diretamente para o **ODS 3 – Saúde e Bem-Estar**, pois:

* **Aumenta a eficiência** no gerenciamento de doadores de sangue, facilitando o agendamento de doações e reduzindo a falta de hemoderivados nos hospitais.
* **Promove a segurança** ao validar dados do doador (CPF, data de nascimento) e ao armazenar senhas criptografadas.
* **Facilita o acesso** de voluntários (doadores) a informações sobre hemocentros, datas disponíveis e histórico de doações, incentivando a participação na cadeia de doação.
* **Impacto social**: ao centralizar doações, ajuda a salvar vidas e diminuir as barreiras para acesso ao sangue, alinhando-se com metas de reduzir surtos, doenças e melhorar a saúde comunitária.

---

## 🎉 Agradecimentos

* Agradecemos às equipes que desenvolvem bibliotecas essenciais como **jBCrypt**, **MySQL Connector/J** e **Swing**.
* Obrigado ao time de desenvolvedores, testadores e à comunidade que apoia iniciativas de software livre e soluções para saúde pública.

---

> “Doe sangue, doe vida!” 🩸❤️