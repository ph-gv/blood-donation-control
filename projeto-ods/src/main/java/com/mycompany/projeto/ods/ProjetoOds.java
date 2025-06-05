package com.mycompany.projeto.ods;

import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.view.TelaLogin;
import javax.swing.SwingUtilities;

public class ProjetoOds {
    public static void main(String[] args) {
        // Inicia a aplicação na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Configura o look and feel do sistema operacional
                javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
                );
                
                // Inicia a tela de login
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
                
            } catch (Exception e) {
                System.err.println("Erro ao iniciar a aplicação: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
