package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoacaoDAO;
import com.mycompany.projeto.ods.dao.HemocentroDAO;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.util.GerarPdfAgendamento;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

public class DoacaoScreen extends javax.swing.JFrame {

    private final Doador usuario;

    public DoacaoScreen() {
        this.usuario = null;
        initComponents();
        setLocationRelativeTo(null);
        configuraFormatters();
        carregaHemocentros();
    }

    public DoacaoScreen(Doador usuario) {
        this.usuario = Objects.requireNonNull(usuario);
        initComponents();
        setLocationRelativeTo(null);
        configuraFormatters();
        carregaHemocentros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelecioneLocal = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        cmbHemocentros = new javax.swing.JComboBox<>();
        fmtHora = new javax.swing.JFormattedTextField();
        fmtData = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        lblHora1 = new javax.swing.JLabel();
        lblHora2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelecioneLocal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblSelecioneLocal.setText("Selecione o Local:");

        lblData.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblData.setText("Selecione a Data:");

        lblHora.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblHora.setText("Selecione o Horário:");

        cmbHemocentros.setBackground(new java.awt.Color(204, 204, 204));

        fmtHora.setBackground(new java.awt.Color(204, 204, 204));
        fmtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtHoraActionPerformed(evt);
            }
        });

        fmtData.setBackground(new java.awt.Color(204, 204, 204));
        fmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataActionPerformed(evt);
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

        btnAgendar.setBackground(new java.awt.Color(192, 57, 43));
        btnAgendar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnAgendar.setText("AGENDAR");
        btnAgendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        lblHora1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblHora1.setText("Doação");

        lblHora2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lblHora2.setText("Agende quando você irá fazer sua doação preenchendo abaixo:");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\T-GAMER\\codes\\blood-donation-control\\projeto-ods\\src\\main\\resources\\icons\\heart.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelecioneLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbHemocentros, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHora)
                                    .addComponent(lblData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fmtHora, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fmtData))
                                .addGap(133, 133, 133)))
                        .addComponent(jLabel1)
                        .addGap(108, 108, 108))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(lblHora2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(lblHora1)))
                .addGap(63, 207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lblHora1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHora2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelecioneLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHemocentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblData)
                        .addGap(18, 18, 18)
                        .addComponent(fmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHora))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnAgendar))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgendarActionPerformed
        String nomeSelecionado = (String) cmbHemocentros.getSelectedItem();
        Hemocentro selecionado = new HemocentroDAO().buscarPorNome(nomeSelecionado);
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um hemocentro.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dataStr = fmtData.getText();
        String horaStr = fmtHora.getText();

        LocalDate data;
        LocalTime hora;
        try {
            data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use DD/MM/AAAA.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            fmtData.requestFocusInWindow();
            return;
        }
        try {
            hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Horário inválido. Use HH:mm.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            fmtHora.requestFocusInWindow();
            return;
        }

        if (LocalDateTime.of(data, hora).isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(this, "Não é possível agendar em horário passado.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DoacaoDAO dDao = new DoacaoDAO();
        if (!dDao.verificarDisponibilidade(selecionado.getId(), data, hora)) {
            JOptionPane.showMessageDialog(this, "Horário indisponível neste hemocentro.", "Erro de Disponibilidade",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Doacao nova = new Doacao();
        nova.setIdDoador(usuario != null ? usuario.getId() : 0);
        nova.setIdLocalColeta(selecionado.getId());
        nova.setData(data);
        nova.setHorario(hora);
        nova.setStatus("agendado");

        try {
            dDao.salvar(nova);
            JOptionPane.showMessageDialog(this, "Agendamento confirmado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // GERA O PDF DO COMPROVANTE
            GerarPdfAgendamento.gerar(usuario, nova, selecionado);

            new MenuPrincipal(usuario).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao agendar: " + e.getMessage(), "Erro no Sistema",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnAgendarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarActionPerformed
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true);
        }
        this.dispose();
    }// GEN-LAST:event_btnVoltarActionPerformed

    private void fmtDataActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fmtDataActionPerformed
        fmtHora.requestFocusInWindow();
    }// GEN-LAST:event_fmtDataActionPerformed

    private void fmtHoraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fmtHoraActionPerformed
        btnAgendar.requestFocusInWindow();
    }// GEN-LAST:event_fmtHoraActionPerformed

    private void configuraFormatters() {
        try {
            MaskFormatter mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            fmtData.setFormatterFactory(new DefaultFormatterFactory(mfData));

            MaskFormatter mfHora = new MaskFormatter("##:##");
            mfHora.setPlaceholderCharacter('0');
            fmtHora.setFormatterFactory(new DefaultFormatterFactory(mfHora));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void carregaHemocentros() {
        cmbHemocentros.removeAllItems();
        HemocentroDAO hDao = new HemocentroDAO();
        List<Hemocentro> lista = hDao.listarTodos();
        if (lista.isEmpty()) {
            cmbHemocentros.addItem("");
        } else {
            for (Hemocentro h : lista) {
                cmbHemocentros.addItem(h.getNome());
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DoacaoScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbHemocentros;
    private javax.swing.JFormattedTextField fmtData;
    private javax.swing.JFormattedTextField fmtHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblHora2;
    private javax.swing.JLabel lblSelecioneLocal;
    // End of variables declaration//GEN-END:variables
}