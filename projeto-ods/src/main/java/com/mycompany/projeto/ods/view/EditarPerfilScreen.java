package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Objects;

public class EditarPerfilScreen extends javax.swing.JFrame {

    private final Doador usuario;
    private final DoadorDAO dao = new DoadorDAO();

    /**
     * Construtor de teste isolado (não carrega usuário real).
     */
    public EditarPerfilScreen() {
        this.usuario = null;
        initComponents();
        configuraMaskData();
    }

    /**
     * Construtor principal recebe o doador logado e pré-carrega campos.
     */
    public EditarPerfilScreen(Doador usuario) {
        this.usuario = Objects.requireNonNull(usuario);
        initComponents();
        configuraMaskData();
        populaCampos();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

        lblTitulo.setText("EDITAR PERFIL");

        lblNome.setText("Nome:");

        lblCpf.setText("CPF:");

        lblData.setText("Data de Nascimento");

        lblTipoSanguineo.setText("Tipo Sanguíneo:");

        lblSenha.setText("Senha:");

        txtNomePerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePerfilActionPerformed(evt);
            }
        });

        txtCpfPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfPerfilActionPerformed(evt);
            }
        });

        cmbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        cmbTipoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPerfilActionPerformed(evt);
            }
        });

        txtSenhaPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaPerfilActionPerformed(evt);
            }
        });

        fmtDataPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataPerfilActionPerformed(evt);
            }
        });

        btnVoltarPerfil.setText("VOLTAR");
        btnVoltarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarPerfilActionPerformed(evt);
            }
        });

        btnSalvarPerfil.setText("SALVAR");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltarPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarPerfil))
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomePerfil)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCpfPerfil)
                    .addComponent(lblTipoSanguineo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipoPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSenhaPerfil)
                    .addComponent(fmtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpfPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTipoSanguineo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fmtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarPerfil)
                    .addComponent(btnSalvarPerfil))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Preenche os campos com os dados atuais do usuário.
     */
    private void populaCampos() {
        txtNomePerfil.setText(usuario.getNome());
        txtCpfPerfil.setText(usuario.getCpf());
        cmbTipoPerfil.setSelectedItem(usuario.getTipoSanguineo());

        // Exibir data no formato BR (dd/MM/yyyy)
        DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fmtDataPerfil.setText(usuario.getDataNascimento().format(fmtBR));
    }

    /**
     * Configura a máscara de data (DD/MM/AAAA) no fmtDataPerfil.
     */
    private void configuraMaskData() {
        try {
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.setPlaceholderCharacter('_');
            fmtDataPerfil.setFormatterFactory(new DefaultFormatterFactory(mf));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void txtNomePerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePerfilActionPerformed

    }//GEN-LAST:event_txtNomePerfilActionPerformed

    private void txtCpfPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfPerfilActionPerformed

    }//GEN-LAST:event_txtCpfPerfilActionPerformed

    private void cmbTipoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPerfilActionPerformed

    }//GEN-LAST:event_cmbTipoPerfilActionPerformed

    private void fmtDataPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtDataPerfilActionPerformed

    }//GEN-LAST:event_fmtDataPerfilActionPerformed

    private void txtSenhaPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaPerfilActionPerformed

    }//GEN-LAST:event_txtSenhaPerfilActionPerformed

    private void btnVoltarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarPerfilActionPerformed
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarPerfilActionPerformed

    private void btnSalvarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPerfilActionPerformed
         // Coleta valores
        String nome = txtNomePerfil.getText().trim();
        String tipo = (String) cmbTipoPerfil.getSelectedItem();
        String dataStr = fmtDataPerfil.getText().trim();
        char[] senhaChars = txtSenhaPerfil.getPassword();
        String senha = new String(senhaChars);

        // Validações básicas
        if (nome.isEmpty() || tipo == null || dataStr.contains("_")) {
            JOptionPane.showMessageDialog(
                this,
                "Preencha todos os campos (nome, tipo, data).",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (senha.length() > 0 && senha.length() < 8) {
            JOptionPane.showMessageDialog(
                this,
                "Senha deve ter no mínimo 8 caracteres ou ficar vazia para não alterar.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE
            );
            txtSenhaPerfil.requestFocusInWindow();
            return;
        }

        // Converte data de “dd/MM/yyyy” para LocalDate
        LocalDate dataNasc;
        try {
            DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNasc = LocalDate.parse(dataStr, fmtBR);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Data inválida. Use DD/MM/AAAA.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE
            );
            fmtDataPerfil.requestFocusInWindow();
            return;
        }

        // Atualiza o objeto Doador
        usuario.setNome(nome);
        usuario.setTipoSanguineo(tipo);
        usuario.setDataNascimento(dataNasc);
        if (!senha.isEmpty()) {
            usuario.setSenha(senha);
        }

        // Salva no banco
        try {
            dao.atualizar(usuario);
            JOptionPane.showMessageDialog(
                this,
                "Perfil atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            new MenuPrincipal(usuario).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Erro ao atualizar perfil: " + e.getMessage(),
                "Erro no Sistema",
                JOptionPane.ERROR_MESSAGE
            );
        } finally {
            Arrays.fill(senhaChars, '0');
        }
    }//GEN-LAST:event_btnSalvarPerfilActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPerfilScreen().setVisible(true);
            }
        });
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
