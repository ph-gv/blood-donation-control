package com.mycompany.projeto.ods;
 
import com.mycompany.projeto.ods.util.BancoDadosException;
import com.mycompany.projeto.ods.util.ConexaoBD;
import com.mycompany.projeto.ods.view.LoginScreen;
 
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
 
/**
 * Ponto de entrada da aplicação.
 *
 * A ordem de execução aqui é importante:
 *
 *   1. inicializarBanco() — cria as tabelas no SQLite se ainda não existirem
 *      e insere os hemocentros de exemplo. Isso DEVE acontecer antes de qualquer
 *      tela ser exibida, pois as Views disparam consultas ao banco logo no construtor
 *      (por exemplo, DoacaoScreen.carregaHemocentros() é chamado em initComponents).
 *      Se o banco não estiver pronto nesse momento, a aplicação lançaria exceção
 *      já na tela de login.
 *
 *   2. SwingUtilities.invokeLater() — garante que toda criação de componentes
 *      Swing ocorra na Event Dispatch Thread (EDT), que é o requisito de thread-safety
 *      do Swing. Isso já existia no código original e está correto.
 *
 * Se a inicialização do banco falhar (arquivo sem permissão de escrita, disco cheio,
 * schema.sql ausente no JAR, etc.), o usuário recebe uma mensagem clara e a aplicação
 * encerra de forma controlada com System.exit(1), em vez de explodir com uma
 * NullPointerException ou StackOverflowError sem contexto.
 */
public class Main {
    public static void main(String[] args) {
 
        // --- PASSO 1: Inicializar o banco ANTES de qualquer tela ---
        try {
            ConexaoBD.inicializarBanco();
        } catch (BancoDadosException e) {
            // Exibe mensagem amigável e encerra — não há como continuar sem banco
            JOptionPane.showMessageDialog(
                null,
                "Erro ao inicializar o banco de dados:\n" + e.getMessage() +
                "\n\nVerifique se o arquivo sangue.db tem permissão de escrita" +
                "\nou se o schema.sql está presente em src/main/resources/sql/.",
                "Erro Fatal de Inicialização",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }
 
        // --- PASSO 2: Abrir a tela de login na EDT ---
        SwingUtilities.invokeLater(() -> {
            // Tenta aplicar o Look & Feel Nimbus para uma aparência mais moderna.
            // Se não estiver disponível na JVM do usuário, a aplicação continua
            // normalmente com o Look & Feel padrão do sistema operacional.
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info :
                        javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                // Silencioso — Look & Feel é cosmético, não crítico
            }
 
            new LoginScreen().setVisible(true);
        });
    }
}