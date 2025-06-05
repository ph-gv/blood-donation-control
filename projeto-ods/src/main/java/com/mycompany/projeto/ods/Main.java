package com.mycompany.projeto.ods;

import com.mycompany.projeto.ods.view.LoginScreen;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Garante que todas as operações de UI rodem na Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Abre a tela de login
            new LoginScreen().setVisible(true);
        });
    }
}