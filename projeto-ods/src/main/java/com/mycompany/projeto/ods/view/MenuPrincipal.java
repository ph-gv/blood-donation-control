package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.model.Doador;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    
    private final Doador usuario; //Armazena o usuário logado
    
    public MenuPrincipal(Doador usuario) {
        this.usuario = usuario;
        initComponents();
        exibirBoasVindas();
    }
    
    private void exibirBoasVindas(){
        lblBoasVindas.setText("Bem-Vindo, " + usuario.getNome() + "!");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBoasVindas = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        btnMeusAgendamentos = new javax.swing.JButton();
        btnEditarPerfil = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBoasVindas.setText("Bem-Vindo!");

        btnAgendar.setText("Agendar Doação");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnMeusAgendamentos.setText("Meus Agendamentos");
        btnMeusAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeusAgendamentosActionPerformed(evt);
            }
        });

        btnEditarPerfil.setText("Editar Perfil");
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBoasVindas)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnMeusAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblBoasVindas)
                .addGap(18, 18, 18)
                .addComponent(btnAgendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMeusAgendamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handler do botão “Agendar Doação”.
     * Abre a tela de agendamento (DoacaoScreen) e fecha este menu.
     */
    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        DoacaoScreen telaDoacao = new DoacaoScreen(usuario);
        telaDoacao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendarActionPerformed

     /**
     * Handler do botão “Editar Perfil”.
     * Abre a tela de edição de perfil (EditarPerfilScreen) e fecha este menu.
     */
    private void btnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPerfilActionPerformed
        EditarPerfilScreen telaEditar = new EditarPerfilScreen(usuario);
        telaEditar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditarPerfilActionPerformed

    /**
     * Handler do botão “Minhas Doações”.
     * Abre a tela que lista as doações (MinhasDoacoesScreen) e fecha este menu.
     */
    private void btnMeusAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeusAgendamentosActionPerformed
        MinhasDoacoesScreen telaMinhasDoacoes = new MinhasDoacoesScreen(usuario);
        telaMinhasDoacoes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMeusAgendamentosActionPerformed

    /**
     * Handler do botão “Sair do Sistema”.
     * Pergunta confirmação e, se confirmado, volta para a tela de login.
     */
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair do sistema?",
            "Confirmação de Saída",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            new LoginScreen().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    
    public static void main(String args[]) {
        // Usuário teste:
        Doador usuarioTeste = new Doador();
        usuarioTeste.setId(1);
        usuarioTeste.setNome("João Silva");
        usuarioTeste.setCpf("12345678901");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(usuarioTeste).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnEditarPerfil;
    private javax.swing.JButton btnMeusAgendamentos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblBoasVindas;
    // End of variables declaration//GEN-END:variables
}
