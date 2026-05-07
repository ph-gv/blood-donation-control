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
    // Code">//GEN-BEGIN:initComponents
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelecioneLocal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        lblSelecioneLocal.setText("Selecione o Local:");

        lblData.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        lblData.setText("Selecione a Data:");

        lblHora.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        lblHora.setText("Selecione o Horário:");

        cmbHemocentros.setBackground(new java.awt.Color(70, 73, 55));

        fmtHora.setBackground(new java.awt.Color(70, 73, 55));
        fmtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtHoraActionPerformed(evt);
            }
        });

        fmtData.setBackground(new java.awt.Color(70, 73, 55));
        fmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(232, 160, 154));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAgendar.setBackground(new java.awt.Color(192, 57, 43));
        btnAgendar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12));
        btnAgendar.setText("AGENDAR");
        btnAgendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        lblHora1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18));
        lblHora1.setText("Doação");

        lblHora2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
        lblHora2.setText("Agende quando você irá fazer sua doação preenchendo abaixo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fmtData, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblSelecioneLocal,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmbHemocentros,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblData)
                                                        .addComponent(lblHora)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnVoltar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(85, 85, 85)
                                                                .addComponent(btnAgendar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(lblHora1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addComponent(lblHora2)))
                                .addContainerGap(131, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addComponent(lblHora1)
                                .addGap(29, 29, 29)
                                .addComponent(lblHora2)
                                .addGap(26, 26, 26)
                                .addComponent(lblSelecioneLocal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHemocentros, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fmtData, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnVoltar)
                                        .addComponent(btnAgendar))
                                .addGap(57, 57, 57)));

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
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblHora2;
    private javax.swing.JLabel lblSelecioneLocal;
    // End of variables declaration//GEN-END:variables
}