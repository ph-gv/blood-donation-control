package com.mycompany.projeto.ods;

import com.mycompany.projeto.ods.util.BancoDadosException;
import com.mycompany.projeto.ods.util.ConexaoBD;
import com.mycompany.projeto.ods.view.LoginScreen;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        try {
            ConexaoBD.inicializarBanco();
        } catch (BancoDadosException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inicializar o banco de dados:\n" + e.getMessage() +
                            "\n\nVerifique se o arquivo sangue.db tem permissão de escrita" +
                            "\nou se o schema.sql está presente em src/main/resources/sql/.",
                    "Erro Fatal de Inicialização",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                // Silencioso
            }

            new LoginScreen().setVisible(true);
        });
    }
}