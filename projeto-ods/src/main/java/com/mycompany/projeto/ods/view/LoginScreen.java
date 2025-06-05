package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;
import javax.swing.*;
import java.util.Arrays;

public class LoginScreen extends javax.swing.JFrame {

    public LoginScreen() {
        initComponents();
        //Muda o foco para o campo de CPF
        txtCpf.requestFocusInWindow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCpf = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelCpf.setText("CPF:");

        jLabelSenha.setText("Senha:");

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

        btnLogin.setText("ENTRAR");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(jLabelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabelCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCadastrar))
                .addContainerGap(101, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
