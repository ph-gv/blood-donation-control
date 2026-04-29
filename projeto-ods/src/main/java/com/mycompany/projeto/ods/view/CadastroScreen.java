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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        lblTipoSanguineo3 = new javax.swing.JLabel();
        lblTipoSanguineo4 = new javax.swing.JLabel();

        jTextField1.setForeground(new java.awt.Color(70, 73, 55));
        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(70, 73, 55));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblSenha.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblSenha.setText("Senha:");

        lblDataNascimento.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento:");

        lblCPF.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblCPF.setText("CPF:");

        lblTipoSanguineo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblTipoSanguineo.setText("Seu tipo sanguíneo:");

        txtNome.setBackground(new java.awt.Color(204, 204, 204));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCpf.setBackground(new java.awt.Color(204, 204, 204));
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(204, 204, 204));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        cmbTipoSanguineo.setBackground(new java.awt.Color(70, 73, 55));
        cmbTipoSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        cmbTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoSanguineoActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(232, 160, 154));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(192, 57, 43));
        btnSalvar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("CADASTRAR");
        btnSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        fmtDataNascimento.setBackground(new java.awt.Color(204, 204, 204));
        fmtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataNascimentoActionPerformed(evt);
            }
        });

        lblTipoSanguineo1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblTipoSanguineo1.setText("Cadastro");
        lblTipoSanguineo1.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo1.setName(""); // NOI18N

        lblTipoSanguineo2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblTipoSanguineo2.setText("<html>Uma pequena doação<br> é o começo<br> da vida de alguém<br></html>");
        lblTipoSanguineo2.setToolTipText("");
        lblTipoSanguineo2.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo2.setName(""); // NOI18N

        lblTipoSanguineo3.setFont(new java.awt.Font("Segoe UI Semibold", 2, 18)); // NOI18N
        lblTipoSanguineo3.setForeground(new java.awt.Color(192, 57, 43));
        lblTipoSanguineo3.setText("DOE SANGUE, DOE VIDAS");
        lblTipoSanguineo3.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo3.setName(""); // NOI18N

        lblTipoSanguineo4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblTipoSanguineo4.setText("Cadastre-se e seja você um novo doador!");
        lblTipoSanguineo4.setMaximumSize(new java.awt.Dimension(100, 16));
        lblTipoSanguineo4.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTipoSanguineo)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento)
                    .addComponent(fmtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtCpf)
                    .addComponent(cmbTipoSanguineo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoSanguineo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoSanguineo3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(lblTipoSanguineo4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(lblTipoSanguineo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTipoSanguineo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTipoSanguineo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCPF)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblTipoSanguineo))
                    .addComponent(lblTipoSanguineo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDataNascimento)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblTipoSanguineo3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSenha)))
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

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
    private javax.swing.JLabel lblTipoSanguineo3;
    private javax.swing.JLabel lblTipoSanguineo4;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
