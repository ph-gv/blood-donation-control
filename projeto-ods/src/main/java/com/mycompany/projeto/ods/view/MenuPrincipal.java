package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.model.Doador;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    
    private final Doador usuario; //Armazena o usuário logado
    
    public MenuPrincipal(Doador usuario) {
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        lblBoasVindas1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblBoasVindas.setText("Olá, Seja muito(a) Bem-Vindo(a)");

        btnAgendar.setBackground(new java.awt.Color(46, 139, 87));
        btnAgendar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("Agendar Doação");
        btnAgendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnMeusAgendamentos.setBackground(new java.awt.Color(46, 139, 87));
        btnMeusAgendamentos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnMeusAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        btnMeusAgendamentos.setText("Meus Agendamentos");
        btnMeusAgendamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMeusAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeusAgendamentosActionPerformed(evt);
            }
        });

        btnEditarPerfil.setBackground(new java.awt.Color(46, 139, 87));
        btnEditarPerfil.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnEditarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPerfil.setText("Editar Perfil");
        btnEditarPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(192, 57, 43));
        btnSair.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setText("\n");

        lblBoasVindas1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblBoasVindas1.setText("Conheça uma forma simples e rápida de agendar sua doação de sangue.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMeusAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(btnEditarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblBoasVindas1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lblBoasVindas)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(lblBoasVindas)
                .addGap(18, 18, 18)
                .addComponent(lblBoasVindas1)
                .addGap(27, 27, 27)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblBoasVindas1;
    // End of variables declaration//GEN-END:variables
}
