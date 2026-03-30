package com.mycompany.projeto.ods.util;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    private static final Logger LOG = Logger.getLogger(ConexaoBD.class.getName());
 
    // O arquivo sangue.db será criado na pasta raiz do projeto (onde fica o pom.xml).
    // Qualquer membro do grupo que clonar o repositório terá o banco gerado
    // automaticamente na primeira execução, sem precisar instalar nada.
    private static final String URL = "jdbc:sqlite:sangue.db";
 
    /**
     * Abre e retorna uma nova conexão com o banco SQLite.
     *
     * O PRAGMA foreign_keys = ON é necessário porque o SQLite desabilita
     * a verificação de chaves estrangeiras por padrão. Sem ele, seria possível
     * inserir uma doação com id_doador inexistente sem nenhum erro.
     *
     * @throws BancoDadosException se não for possível abrir a conexão
     */
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            // Ativa checagem de chaves estrangeiras para esta conexão
            try (Statement st = conn.createStatement()) {
                st.execute("PRAGMA foreign_keys = ON");
            }
            return conn;
        } catch (SQLException e) {
            throw new BancoDadosException(
                "Não foi possível conectar ao banco de dados: " + e.getMessage(), e
            );
        }
    }
    
     public static void inicializarBanco() {
        LOG.info("Inicializando banco de dados SQLite em: " + URL);
 
        try (Connection conn = getConnection();
             InputStream is = ConexaoBD.class.getResourceAsStream("/sql/schema.sql")) {
 
            if (is == null) {
                throw new BancoDadosException(
                    "Arquivo schema.sql não encontrado em src/main/resources/sql/"
                );
            }
 
            String sqlCompleto = new String(is.readAllBytes(), StandardCharsets.UTF_8);
 
            // Divide o script em comandos individuais usando o ";" como separador.
            // Filtra linhas de comentário (--) e strings vazias para evitar erros
            // ao tentar executar um comando vazio no JDBC do SQLite.
            try (Statement st = conn.createStatement()) {
                for (String bloco : sqlCompleto.split(";")) {
                    // Remove comentários linha a linha dentro de cada bloco
                    StringBuilder cmdLimpo = new StringBuilder();
                    for (String linha : bloco.split("\n")) {
                        String trimmed = linha.trim();
                        if (!trimmed.startsWith("--") && !trimmed.isEmpty()) {
                            cmdLimpo.append(linha).append("\n");
                        }
                    }
                    String cmd = cmdLimpo.toString().trim();
                    if (!cmd.isEmpty()) {
                        st.execute(cmd);
                    }
                }
            }
 
            LOG.info("Banco de dados inicializado com sucesso.");
 
        } catch (IOException e) {
            throw new BancoDadosException("Erro ao ler schema.sql: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao executar schema.sql: " + e.getMessage(), e);
        }
    }
}