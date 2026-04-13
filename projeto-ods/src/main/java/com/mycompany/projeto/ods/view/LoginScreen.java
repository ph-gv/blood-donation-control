package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;
import javax.swing.*;
import java.util.Arrays;

public class LoginScreen extends javax.swing.JFrame {

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(null);
        //Muda o foco para o campo de CPF
        txtCpf.requestFocusInWindow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelSenha1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(232, 160, 154));

        jLabelCpf.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelCpf.setText("Olá Seja Bem-Vindo(a)");

        jLabelSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");

        txtCpf.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(192, 57, 43));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("ENTRAR");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(232, 160, 154));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabelSenha1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelSenha1.setText("Login:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelCpf)
                        .addComponent(jLabelSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(jLabelCpf)
                .addGap(18, 18, 18)
                .addComponent(jLabelSenha1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        txtSenha.requestFocusInWindow();
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        btnLogin.setEnabled(false);
        btnCadastrar.setEnabled(false);
        
        new Thread(() -> {
            String cpf = txtCpf.getText().replaceAll("\\D", "");
            char[] senhaChars = txtSenha.getPassword();
            String senha = new String(senhaChars);

            // Validações
            if (cpf.length() != 11) {
                SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(this, "CPF inválido. Deve conter 11 dígitos.")
                );
                SwingUtilities.invokeLater(() -> {
                    txtCpf.requestFocusInWindow();
                    btnLogin.setEnabled(true);
                    btnCadastrar.setEnabled(true);
                });
                Arrays.fill(senhaChars, '0');
                return;
            }
            if (senha.isEmpty()) {
                SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(this, "Digite a senha.")
                );
                SwingUtilities.invokeLater(() -> {
                    txtSenha.requestFocusInWindow();
                    btnLogin.setEnabled(true);
                    btnCadastrar.setEnabled(true);
                });
                Arrays.fill(senhaChars, '0');
                return;
            }

            try {
                DoadorDAO dao = new DoadorDAO();
                Doador usuario = dao.autenticar(cpf, senha);

                SwingUtilities.invokeLater(() -> {
                    if (usuario != null) {
                        JOptionPane.showMessageDialog(this, "Bem-vindo, " + usuario.getNome() + "!");
                        abrirMenuPrincipal(usuario);
                    } else {
                        JOptionPane.showMessageDialog(this, "CPF ou senha incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
                        txtSenha.setText("");
                        txtSenha.requestFocusInWindow();
                        btnLogin.setEnabled(true);
                        btnCadastrar.setEnabled(true);
                    }
                });
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Erro ao conectar com o banco: " + ex.getMessage(), "Erro no Sistema", JOptionPane.ERROR_MESSAGE);
                    btnLogin.setEnabled(true);
                    btnCadastrar.setEnabled(true);
                });
            }

            Arrays.fill(senhaChars, '0');
        }).start();
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // Abre a tela de cadastro e fecha esta
        new CadastroScreen().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void abrirMenuPrincipal(Doador usuario) {
        new MenuPrincipal(usuario).setVisible(true);
        this.dispose();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelSenha1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
