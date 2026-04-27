package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class EditarPerfilScreen extends javax.swing.JFrame {

    private final Doador usuario;
    private final DoadorDAO dao = new DoadorDAO();

    public EditarPerfilScreen() {
        this.usuario = null;
        initComponents();
        setLocationRelativeTo(null);
        configuraMaskData();
    }

    public EditarPerfilScreen(Doador usuario) {
        this.usuario = Objects.requireNonNull(usuario);
        initComponents();
        setLocationRelativeTo(null);
        configuraMaskData();
        populaCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblTipoSanguineo = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtNomePerfil = new javax.swing.JTextField();
        txtCpfPerfil = new javax.swing.JTextField();
        cmbTipoPerfil = new javax.swing.JComboBox<>();
        txtSenhaPerfil = new javax.swing.JPasswordField();
        fmtDataPerfil = new javax.swing.JFormattedTextField();
        btnVoltarPerfil = new javax.swing.JButton();
        btnSalvarPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 12));
        lblTitulo.setText("EDITAR PERFIL");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNome.setText("Nome:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblCpf.setText("CPF:");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblData.setText("Data de Nascimento:");

        lblTipoSanguineo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTipoSanguineo.setText("Tipo Sanguíneo:");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 3, 12));
        lblSenha.setText("Nova Senha:");

        txtNomePerfil.setBackground(new java.awt.Color(232, 160, 154));
        txtNomePerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePerfilActionPerformed(evt);
            }
        });

        txtCpfPerfil.setBackground(new java.awt.Color(232, 160, 154));
        txtCpfPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfPerfilActionPerformed(evt);
            }
        });

        cmbTipoPerfil.setBackground(new java.awt.Color(232, 160, 154));
        cmbTipoPerfil.setForeground(new java.awt.Color(44, 44, 42));
        cmbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        cmbTipoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPerfilActionPerformed(evt);
            }
        });

        txtSenhaPerfil.setBackground(new java.awt.Color(232, 160, 154));
        txtSenhaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaPerfilActionPerformed(evt);
            }
        });

        fmtDataPerfil.setBackground(new java.awt.Color(232, 160, 154));
        fmtDataPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataPerfilActionPerformed(evt);
            }
        });

        btnVoltarPerfil.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarPerfil.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnVoltarPerfil.setText("VOLTAR");
        btnVoltarPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarPerfilActionPerformed(evt);
            }
        });

        btnSalvarPerfil.setBackground(new java.awt.Color(46, 139, 87));
        btnSalvarPerfil.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnSalvarPerfil.setText("SALVAR");
        btnSalvarPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(205, Short.MAX_VALUE)
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNomePerfil)
                                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCpfPerfil)
                                        .addComponent(lblTipoSanguineo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbTipoPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSenhaPerfil)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnVoltarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        135, Short.MAX_VALUE)
                                                .addComponent(btnSalvarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fmtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lblCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpfPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblTipoSanguineo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenhaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSalvarPerfil)
                                        .addComponent(btnVoltarPerfil))
                                .addContainerGap(23, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populaCampos() {
        txtNomePerfil.setText(usuario.getNome());
        txtNomePerfil.setEditable(false);
        txtNomePerfil.setBackground(new java.awt.Color(200, 200, 200));

        txtCpfPerfil.setText(usuario.getCpf());
        txtCpfPerfil.setEditable(false);
        txtCpfPerfil.setBackground(new java.awt.Color(200, 200, 200));

        cmbTipoPerfil.setSelectedItem(usuario.getTipoSanguineo());
        cmbTipoPerfil.setEnabled(false);
        cmbTipoPerfil.setBackground(new java.awt.Color(200, 200, 200));

        DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fmtDataPerfil.setText(usuario.getDataNascimento().format(fmtBR));
        fmtDataPerfil.setEditable(false);
        fmtDataPerfil.setBackground(new java.awt.Color(200, 200, 200));
    }

    private void configuraMaskData() {
        try {
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.setPlaceholderCharacter('_');
            fmtDataPerfil.setFormatterFactory(new DefaultFormatterFactory(mf));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void txtNomePerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomePerfilActionPerformed
    }// GEN-LAST:event_txtNomePerfilActionPerformed

    private void txtCpfPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCpfPerfilActionPerformed
    }// GEN-LAST:event_txtCpfPerfilActionPerformed

    private void cmbTipoPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbTipoPerfilActionPerformed
    }// GEN-LAST:event_cmbTipoPerfilActionPerformed

    private void fmtDataPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fmtDataPerfilActionPerformed
    }// GEN-LAST:event_fmtDataPerfilActionPerformed

    private void txtSenhaPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSenhaPerfilActionPerformed
    }// GEN-LAST:event_txtSenhaPerfilActionPerformed

    private void btnVoltarPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarPerfilActionPerformed
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true);
        }
        this.dispose();
    }// GEN-LAST:event_btnVoltarPerfilActionPerformed

    private void btnSalvarPerfilActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarPerfilActionPerformed
        char[] senhaChars = txtSenhaPerfil.getPassword();
        String senha = new String(senhaChars);

        if (senha.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Digite uma nova senha.",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (senha.length() < 8) {
            JOptionPane.showMessageDialog(
                    this,
                    "Senha deve ter no mínimo 8 caracteres.",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            txtSenhaPerfil.requestFocusInWindow();
            return;
        }

        usuario.setSenha(senha);

        try {
            dao.atualizar(usuario);
            JOptionPane.showMessageDialog(
                    this,
                    "Senha atualizada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            new MenuPrincipal(usuario).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao atualizar senha: " + e.getMessage(),
                    "Erro no Sistema",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            Arrays.fill(senhaChars, '0');
        }
    }// GEN-LAST:event_btnSalvarPerfilActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditarPerfilScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarPerfil;
    private javax.swing.JButton btnVoltarPerfil;
    private javax.swing.JComboBox<String> cmbTipoPerfil;
    private javax.swing.JFormattedTextField fmtDataPerfil;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipoSanguineo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCpfPerfil;
    private javax.swing.JTextField txtNomePerfil;
    private javax.swing.JPasswordField txtSenhaPerfil;
    // End of variables declaration//GEN-END:variables
}