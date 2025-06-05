package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoacaoDAO;
import com.mycompany.projeto.ods.dao.HemocentroDAO;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.model.Doador;
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
    
    /**
     * Construtor padrão para testes isolados.
     */
    public DoacaoScreen() {
        this.usuario = null;
        initComponents();
        configuraFormatters();
        carregaHemocentros();
    }

    /**
     * Construtor principal: recebe o usuário logado.
     */
    public DoacaoScreen(Doador usuario) {
        this.usuario = Objects.requireNonNull(usuario);
        initComponents();
        configuraFormatters();
        carregaHemocentros();
    }

    @SuppressWarnings("unchecked")
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelecioneLocal.setText("Selecione o Local:");

        lblData.setText("Selecione a Data:");

        lblHora.setText("Selecione o Horário:");

        fmtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtHoraActionPerformed(evt);
            }
        });

        fmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtDataActionPerformed(evt);
            }
        });

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAgendar.setText("AGENDAR");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSelecioneLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgendar))
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHemocentros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fmtData)
                    .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblSelecioneLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHemocentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnVoltar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        
        // 1) Primeiro, pega a string que foi adicionada ao combo:
        String nomeSelecionado = (String) cmbHemocentros.getSelectedItem();
        // 2) Busca o objeto Hemocentro correspondente no banco
        Hemocentro selecionado = new HemocentroDAO().buscarPorNome(nomeSelecionado);
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um hemocentro.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dataStr = fmtData.getText();   // ex.: "25/12/1990"
        String horaStr = fmtHora.getText();   // ex.: "14:30"

        // Converter data e hora
        LocalDate data;
        LocalTime hora;
        try {
            DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataStr, fmtBR);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use DD/MM/AAAA.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            fmtData.requestFocusInWindow();
            return;
        }
        try {
            DateTimeFormatter fmtHoraPattern = DateTimeFormatter.ofPattern("HH:mm");
            hora = LocalTime.parse(horaStr, fmtHoraPattern);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Horário inválido. Use HH:mm.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            fmtHora.requestFocusInWindow();
            return;
        }

        LocalDateTime dataHora = LocalDateTime.of(data, hora);
        if (dataHora.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(this, "Não é possível agendar em horário passado.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar disponibilidade
        DoacaoDAO dDao = new DoacaoDAO();
        boolean disponivel = dDao.verificarDisponibilidade(selecionado.getId(), data, hora);
        if (!disponivel) {
            JOptionPane.showMessageDialog(this, "Horário indisponível neste hemocentro.", "Erro de Disponibilidade", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Salvar agendamento
        Doacao nova = new Doacao();
        nova.setIdDoador(usuario != null ? usuario.getId() : 0);
        nova.setIdLocalColeta(selecionado.getId());
        nova.setData(data);
        nova.setHorario(hora);
        nova.setStatus("agendado");

        try {
            dDao.salvar(nova);
            JOptionPane.showMessageDialog(this, "Agendamento confirmado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            new MenuPrincipal(usuario).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao agendar: " + e.getMessage(), "Erro no Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // Volta ao menu principal
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true); // caso de teste isolado
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void fmtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtDataActionPerformed
        // Focar no campo de horário ao pressionar Enter na data
        fmtHora.requestFocusInWindow();
    }//GEN-LAST:event_fmtDataActionPerformed

    private void fmtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtHoraActionPerformed
        // Focar no botão Agendar ao pressionar Enter no horário
        btnAgendar.requestFocusInWindow();
    }//GEN-LAST:event_fmtHoraActionPerformed

    /**
     * Configura as máscaras de data e horário para o JFormattedTextField
     */
    private void configuraFormatters() {
        try {
            // Máscara para data: DD/MM/AAAA
            MaskFormatter mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            fmtData.setFormatterFactory(new DefaultFormatterFactory(mfData));

            // Máscara para horário: HH:mm
            MaskFormatter mfHora = new MaskFormatter("##:##");
            mfHora.setPlaceholderCharacter('0');
            fmtHora.setFormatterFactory(new DefaultFormatterFactory(mfHora));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Popula o JComboBox de hemocentros usando o DAO
     */
    private void carregaHemocentros() {
        cmbHemocentros.removeAllItems();
        HemocentroDAO hDao = new HemocentroDAO();
        List<Hemocentro> lista = hDao.listarTodos();
        if (lista.isEmpty()) {
            cmbHemocentros.addItem(""); // ou alguma mensagem vazia
        } else {
            for (Hemocentro h : lista) {
                // Adiciona apenas o nome (String) no JComboBox<String>
                cmbHemocentros.addItem(h.getNome());
            }
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoacaoScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbHemocentros;
    private javax.swing.JFormattedTextField fmtData;
    private javax.swing.JFormattedTextField fmtHora;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblSelecioneLocal;
    // End of variables declaration//GEN-END:variables
}
