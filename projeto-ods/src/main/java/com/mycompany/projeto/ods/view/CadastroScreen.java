package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;
import java.text.ParseException;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class CadastroScreen extends javax.swing.JFrame {

    public CadastroScreen() {
        initComponents();
        setLocationRelativeTo(null);
        configuraFormatters();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblTipoSanguineo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cmbTipoSanguineo = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        fmtDataNascimento = new javax.swing.JFormattedTextField();
        lblTipoSanguineo1 = new javax.swing.JLabel();
        lblTipoSanguineo2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(232, 160, 154));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSenha.setText("Senha:");

        lblDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento:");

        lblCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCPF.setText("CPF:");

        lblTipoSanguineo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipoSanguineo.setText("Seu tipo Sanguíneo:");

        txtNome.setBackground(new java.awt.Color(232, 160, 154));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCpf.setBackground(new java.awt.Color(232, 160, 154));
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(232, 160, 154));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        cmbTipoSanguineo.setBackground(new java.awt.Color(232, 160, 154));
        cmbTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        cmbTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoSanguineoActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(192, 57, 43));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnSalvar.setText("CADASTRAR");
        btnSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        fmtDataNascimento.setBackground(new java.awt.Color(232, 160, 154));
        fmtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataNascimentoActionPerformed(evt);
            }
        });

        lblTipoSanguineo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipoSanguineo1.setText("Cadastro");
        lblTipoSanguineo1.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo1.setName(""); // NOI18N

        lblTipoSanguineo2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipoSanguineo2.setText("Cadastre-se e seja você um novo doador!");
        lblTipoSanguineo2.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo2.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(181, 181, 181)
                                                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(80, 80, 80)
                                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(lblCPF,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(txtNome,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                158,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(lblNome,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                43,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(106, 106, 106)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblTipoSanguineo)
                                                                                        .addComponent(cmbTipoSanguineo,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                131,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(lblDataNascimento)
                                                                        .addComponent(lblSenha,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                115,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(txtSenha,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        283, Short.MAX_VALUE)
                                                                                .addComponent(fmtDataNascimento,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtCpf,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(300, 300, 300)
                                                                .addComponent(lblTipoSanguineo1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(lblTipoSanguineo2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(276, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblTipoSanguineo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(lblTipoSanguineo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNome)
                                        .addComponent(lblTipoSanguineo))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(lblCPF)
                                .addGap(18, 18, 18)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDataNascimento)
                                .addGap(18, 18, 18)
                                .addComponent(fmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeActionPerformed
        txtCpf.requestFocusInWindow();
    }// GEN-LAST:event_txtNomeActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSenhaActionPerformed
        btnSalvarActionPerformed(evt);
    }// GEN-LAST:event_txtSenhaActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCpfActionPerformed
        cmbTipoSanguineo.requestFocusInWindow();
    }// GEN-LAST:event_txtCpfActionPerformed

    private void cmbTipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbTipoSanguineoActionPerformed
        fmtDataNascimento.requestFocusInWindow();
    }// GEN-LAST:event_cmbTipoSanguineoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        new LoginScreen().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed
        // Coleta dados dos campos
        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().replaceAll("\\D", "");
        String tipo = (String) cmbTipoSanguineo.getSelectedItem();
        String dataStr = fmtDataNascimento.getText().trim();
        char[] senhaChars = txtSenha.getPassword();
        String senha = new String(senhaChars);

        // Validações
        if (nome.isEmpty() || cpf.length() != 11 || tipo == null || dataStr.isEmpty() || senha.length() < 8) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos corretamente:\n" +
                            "- Nome não pode ficar vazio\n" +
                            "- CPF deve ter 11 dígitos\n" +
                            "- Selecione tipo sanguíneo\n" +
                            "- Data no formato correto (DD-MM-AAAA)\n" +
                            "- Senha mínimo 8 caracteres",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3) Converter “DD/MM/AAAA” para LocalDate
        DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc;
        try {
            dataNasc = LocalDate.parse(dataStr, fmtBR);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,
                    "Formato de data inválido. Use DD/MM/AAAA.",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            fmtDataNascimento.requestFocusInWindow();
            return;
        }

        try {
            DoadorDAO dao = new DoadorDAO();
            if (dao.verificarCpfExistente(cpf)) {
                JOptionPane.showMessageDialog(this,
                        "CPF já cadastrado!",
                        "Erro de Cadastro",
                        JOptionPane.ERROR_MESSAGE);
                txtCpf.requestFocusInWindow();
                return;
            }

            Doador novo = new Doador();
            novo.setNome(nome);
            novo.setCpf(cpf);
            novo.setTipoSanguineo(tipo);
            novo.setDataNascimento(dataNasc);
            novo.setSenha(senha);

            dao.salvar(novo);
            JOptionPane.showMessageDialog(this,
                    "Cadastro realizado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            new LoginScreen().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar no banco: " + e.getMessage(),
                    "Erro no Sistema",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            Arrays.fill(senhaChars, '0');
        }
    }// GEN-LAST:event_btnSalvarActionPerformed

    private void fmtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fmtDataNascimentoActionPerformed
        txtSenha.requestFocusInWindow();
    }// GEN-LAST:event_fmtDataNascimentoActionPerformed

    private void configuraFormatters() {
        try {
            // Máscara para data: DD/MM/AAAA
            MaskFormatter mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            fmtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mfData));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Se não encontrar, segue com o default
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbTipoSanguineo;
    private javax.swing.JFormattedTextField fmtDataNascimento;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipoSanguineo;
    private javax.swing.JLabel lblTipoSanguineo1;
    private javax.swing.JLabel lblTipoSanguineo2;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
